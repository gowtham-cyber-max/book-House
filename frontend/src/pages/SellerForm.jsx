import React, { useState } from "react";
import { postBook } from "../redux/actions/bookListAction";
import { useDispatch, useSelector } from "react-redux";
import "../styles/sellerform.css";


export default function SellerForm() {
  const cur = ""
  const [data, setData] = useState({
    author: "",
    name: "",
    description: "",
    price: 0,
    stock: 0,
    used: false,
    genre: [],
    discount: 0,
    binding: "",
    publisher: "",
    edition: "",
    isbn: "",
    language: "",
    imageIds: [],
  });
  const [imgFiles, setImgFiles] = useState([]);
  const dispatch = useDispatch();
  const genres = useSelector((state) => state.books).genres;
  function handleSubmit(e) {
    e.preventDefault();
    if (data.genre.length === 0) {
      alert("Please add at least one genre");
      return;
    }
    if (!imgFiles) {
      alert("Please select a file first!");
      return;
    }
    const formData = new FormData();
    for (let i = 0; i < imgFiles.length; i++) {
      formData.append("file", imgFiles[i]);
    }
    dispatch(postBook(data, formData));
    // setData({
    //   author: "",
    //   name: "",
    //   description: "",
    //   price: 0,
    //   stock: 0,
    //   used: false,
    //   genre: [],
    //   discount: 0,
    //   binding: "",
    //   publisher: "",
    //   edition: "",
    //   isbn: "",
    //   language: "",
    //   imageIds: [],
    // })
  }
  const onChange = (e) => {
    setImgFiles([...imgFiles, ...e.target.files]);
  };

  const onDrop = (event) => {
    event.preventDefault();
    setImgFiles([...imgFiles, ...event.dataTransfer.files]);
  };

  const onDragOver = (event) => {
    event.preventDefault();
  };
  return (
    <form className="add-book" onSubmit={handleSubmit}>
      <h1>Add Book</h1>
      <label>Author</label>
      <input
        type="text"
        value={data.author}
        onChange={(e) => setData({ ...data, author: e.target.value })}
        placeholder="Author"
        required
      />
      <label>Name</label>
      <input
        type="text"
        value={data.name}
        onChange={(e) => setData({ ...data, name: e.target.value })}
        placeholder="Name"
        required
      />
      <label>Description</label>
      <textarea
        type="text"
        value={data.description}
        onChange={(e) => setData({ ...data, description: e.target.value })}
        placeholder="Description"
        required
      />
      <label>Price</label>
      <input
        type="number"
        value={data.price}
        onChange={(e) => setData({ ...data, price: e.target.value })}
        min={1}
        required
      />
      <label>Stock</label>
      <input
        type="number"
        value={data.stock}
        onChange={(e) => setData({ ...data, stock: e.target.value })}
        min={1}
        required
      />
      <label>Used</label>
      <input
        type="checkbox"
        value={data.used}
        onChange={(e) => setData({ ...data, used: e.target.checked })}
      />
      <label>Genres</label>
      <div
        style={{
          width: "100%",
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
          flexWrap: "wrap",
          flexDirection: "column",
        }}
      >
        <div className="genres">
          <div
            style={{
              width: "85%",
              overflow: "scroll",
              display: "flex",
              justifyContent: "flex-start",
              alignItems: "center",
              flexWrap: "nowrap",
              gap: "1rem"
            }}
          >
            {data.genre.map((genre) => (
              <span className="genre" key={genre}>{genre}</span>
            ))}
          </div>
          {data.genre.length >= 1 &&
            <span
              className="backspace material-symbols-outlined"
              style={{ cursor: "pointer" }}
              onClick={() => {
                setData({
                  ...data,
                  genre: data.genre.slice(0, data.genre.length - 1),
                });
              }}
            >
              backspace
            </span>
          }
        </div>
        <select
          style={{
            width: "85%"
          }}
          value={cur}
          onChange={(e) => {
            setData({
              ...data, genre: [...data.genre, e.target.value]
            })
          }}
        >
          <option value="" disabled>Add Genre</option>
          {genres.map((genre) => (
            <option key={genre} value={genre}>
              {genre}
            </option>
          ))}
        </select>
      </div>
      <label>Discount</label>
      <input
        type="number"
        value={data.discount}
        min={0}
        max={100}
        onChange={(e) => setData({ ...data, discount: e.target.value })}
      />
      <label>Binding</label>
      <select
        value={data.binding}
        onChange={(e) => setData({ ...data, binding: e.target.value })}
        required
      >
        <option value="" disabled>Select Binding</option>
        <option value="Hardcover">Hardcover</option>
        <option value="Paperback">Paperback</option>
      </select>
      <label>Publisher</label>
      <input
        type="text"
        value={data.publisher}
        onChange={(e) => setData({ ...data, publisher: e.target.value })}
        placeholder="Publisher"
        required
      />
      <label>Edition</label>
      <input
        type="text"
        value={data.edition}
        onChange={(e) => setData({ ...data, edition: e.target.value })}
        placeholder="Edition"
      />
      <label>ISBN</label>
      <input
        type="text"
        value={data.isbn}
        onChange={(e) => setData({ ...data, isbn: e.target.value })}
        placeholder="ISBN"
        required
      />
      <label>Language</label>
      <input
        type="text"
        value={data.language}
        onChange={(e) => setData({ ...data, language: e.target.value })}
        placeholder="Language"
        required
      />
      <label>Upload images</label>
      <div style={{
        border: "1px solid black",
        width: "80%",
        height: "50px",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        cursor: "pointer",
        margin: "1rem 0"
      }} onDrop={onDrop} onDragOver={onDragOver}>
        <input
          type="file"
          accept="images/*"
          onChange={onChange}
          style={{ display: 'none' }}
          id="fileInput"
        />
        <label htmlFor="fileInput">
          {imgFiles.length > 0 ? (imgFiles.length == 1 ? imgFiles[0].name : imgFiles[0].name + ",...") : "Choose or drop a file"}
          {imgFiles.length > 0 &&
            <button className="secondary-button" onClick={() => {
              setImgFiles([]);
            }}>x</button>
          }
        </label>
      </div>
      <button type="submit">Add</button>
    </form>
  );
}
