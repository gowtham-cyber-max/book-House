import bookListService from "../services/bookListService";
const serv = bookListService;

export const postBook = (data, formData) => async (dispatch, getState) => {
  try {
    const imgRes = await serv.postImages(formData);
    if (imgRes.status == 201) {
      data.imageIds = imgRes.data;
      console.log(imgRes.data)
    } else {
      console.log(imgRes)
      console.log("Error uploading images");
      return;
    }
  } catch (error) {
    console.log(error)
  }
  try {
    const res = await serv.postBook(data);
    if (res.status == 200) {
      alert("Book added successfully");
    } else {
      console.log("Error adding book");
    }
  } catch (error) {
    console.log(error)
  }
};

export const getNextBooks = (sort = "id", genre = "All", order = true, filter = false) => async (dispatch, getState) => {
  if (filter)
    dispatch({ type: "EMPTY_LIST" });
  if (getState().books.limitReached) return;
  dispatch({ type: "NEXT_BOOKS" })
  try {
    const res = await serv.getAllBooks(getState().books.currentPage, sort, genre, order);
    if (res.status == 200) {
      if (res.data.length == 0) {
        dispatch({ type: "LIMIT_REACHED" });
        return;
      } else {
        dispatch({ type: "ADD_BOOKS", payload: res.data });
        if (res.data.length < 9) { // page limit
          dispatch({ type: "LIMIT_REACHED" });
        }
      }
    }
  } catch (error) {
    console.log(error)
  }
}

export const getBooks =
  (attribute = "id", order = true) =>
    async (dispatch, getState) => {
      try {
        const res = await serv.getBooks(
          getState().books.currentPage,
          attribute,
          order
        );
        if (res.status == 200) {
          if (res.data.length == 0) {
            dispatch({ type: "LIMIT_REACHED" });
            return;
          } else {
            dispatch({ type: "ADD_BOOKS_SUCCESS", payload: res.data });
            if (res.data.length < 6) {
              dispatch({ type: "LIMIT_REACHED" });
            }
          }
        } else {
          console.log(res);
        }
      } catch (error) {
        console.log(error)
      }
    };

export const searchBooks = (search) => async (dispatch, getState) => {
  try {
    const res = await serv.searchBooks(search);
    if (res.status == 200) {
      dispatch({ type: "SEARCHED_BOOKS", payload: res.data });
    } else {
      console.log(res);
    }
  } catch (error) {
    console.log(error)
  }
};

export const getGenres = () => async (dispatch, getState) => {
  try {
    const res = await serv.getGenres();
    if (res.status == 200) {
      dispatch({ type: "GENRES", payload: res.data });
    } else {
      console.log(res);
    }
  } catch (error) {
    console.log(error)
  }
};