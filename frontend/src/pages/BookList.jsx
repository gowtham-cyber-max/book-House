import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { getNextBooks } from "../redux/actions/bookListAction";
import Card from "../components/Card";
import "../styles/bookList.css";

/**
 * Renders a list of books and provides search functionality.
 * @returns {JSX.Element} The BookList component.
 */

export default function BookList() {
  const dispatch = useDispatch();
  const selector = useSelector((state) => state.books);
  const [genre, setSelectedGenre] = React.useState("All");
  const [sort, setSort] = React.useState("id");
  const [order, setOrder] = React.useState(true);


  function handleGenreFilter(e) {
    setSelectedGenre(e.target.innerText);
    dispatch(getNextBooks(sort, e.target.innerText, order, true));
  }

  function handleSort(e) {
    const sortOptions = {
      Default: "id",
      "Price (Low to High)": "price",
      "Price (High to Low)": "price",
      Rating: "avg",
      "Title (Ascending)": "name",
      "Title (Descending)": "name",
    };

    const sortOrders = {
      Default: true,
      "Price (Low to High)": true,
      "Price (High to Low)": false,
      Rating: false,
      "Title (Ascending)": true,
      "Title (Descending)": false,
    };

    setSort(sortOptions[e.target.value]);
    setOrder(sortOrders[e.target.value]);

    dispatch(
      getNextBooks(
        sortOptions[e.target.value],
        genre,
        sortOrders[e.target.value],
        true
      )
    );
  }

  return (
    <div className="book-list-container">
      <div className="filters">
        <div className="filters-genres">
          <button
            className={`${genre == "All" ? "selected-genre " : ""
              }filters-genre secondary-button`}
            onClick={handleGenreFilter}
          >
            All
          </button>
          {selector.genres.map((genre_option) => {
            return (
              <button
                key={genre_option}
                className={`${genre_option == genre ? "selected-genre " : ""
                  }filters-genre secondary-button`}
                onClick={handleGenreFilter}
              >
                {genre_option}
              </button>
            );
          })}
        </div>
        <select defaultValue="Default" className="sort" onChange={handleSort}>
          <option value="Default">Default</option>
          <option>Price (Low to High)</option>
          <option>Price (High to Low)</option>
          <option>Rating</option>
          <option>Title (Ascending)</option>
          <option>Title (Descending)</option>
        </select>
      </div>
      <div className="book-list">
        {selector.searched ? (
          <span className="material-symbols-outlined loading">
            progress_activity
          </span>
        ) : (
          selector.books.map((book, index) => {
            return <Card book={book} isMainList={!selector.limitReached && index % 9 == 8} key={book.id} />;
          })
        )}
      </div>
      {selector.limitReached ?
        <p>End of list.</p>
        :
        <span className="material-symbols-outlined loading">
          progress_activity
        </span>
      }
    </div>
  );
}
