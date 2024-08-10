import React, { useEffect, useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useParams } from "react-router-dom";
import "../styles/bookDetails.css";
import { API_URL } from "../redux/store";
import { addToWish } from "../redux/actions/userAction";
import axios from "axios";

export default function BookDetails() {
  const { id } = useParams();
  const user = useSelector((state) => state.user.user)
  const [book, setBook] = useState(null);
  const [wished, setWished] = useState(user && user.wishlist.filter(
    (book) => book === id
  ).length > 0);

  const dispatch = useDispatch();
  const wish = () => {
    dispatch(addToWish(id));
    setWished(!wished);
  };
  useEffect(() => {
    async function getBook() {
      const res = axios.get(API_URL + "/api/book/get/" + id);
      setBook((await res).data)
    }
    if (id)
      getBook();
  }, [])
  if (book)
    return (
      <div className="book-details-container" >
        <div className="book-details">
          <div className="book-intro">
            <div>

              <img
                className="book-intro__img"
                src={
                  book.imageIds
                    ? `${API_URL}/api/file/download/${book.imageIds[0]}`
                    : "/src/assets/images.jpeg"
                }
              />
            </div>
            <div className="book-intro__info">
              <div className="options">
                <h1 className="book-intro__title">{book.name}</h1>
                {user != null ?
                  (wished ?
                    <span onClick={wish} className="material-symbols-outlined">
                      bookmark_added
                    </span>
                    : <span onClick={wish} className="material-symbols-outlined">
                      bookmark_add
                    </span>
                  ) : (
                    <span className="disabled material-symbols-outlined" onClick={() => (alert("Please Sign In"))} >bookmark_add</span>
                  )
                }
              </div>
              <h2 className="book-intro__author">{book.author}</h2>
              <div className="book-intro__genres">
                {book.genre.map((g) => {
                  return <span className="book-intro__genre secondary-button" key={g}>{g}</span>;
                })}
              </div>
              <p className="book-intro__description">{book.description}</p>

            </div>
          </div>
        </div>
      </div>
    );
  return (
    <span className="material-symbols-outlined loading">progress_activity</span>
  );
}
