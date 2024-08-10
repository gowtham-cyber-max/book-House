import React from "react";
import "../styles/home.css";
export default function SellerHome() {
  return (
    <div
      style={{
        position: "relative",
      }}
    >
      <div className="seller-hero">
        <p className="herotext">BookBite</p>
        <p className="herotext2">Sell. Earn. Satisfy. </p>

        <button
          className="get-started"
          onClick={() => {
            window.location.href = "/#/add-book";
          }}
        >
          Get started
          <span className="material-symbols-outlined"
            style={{
              position: "relative",
              top: "6px",
            }}
          >
            arrow_forward
          </span>
        </button>
      </div>
    </div>
  );
}
