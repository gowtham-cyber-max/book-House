import React, { useEffect, useState } from "react";
import "../styles/home.css";
import Navbar from "../components/Navbar";

export default function Home() {
  const [B1, setB1] = useState(0);
  const [B2, setB2] = useState(0);
  const [B3, setB3] = useState(0);
  const [inter, setInter] = useState(null);

  function updateDegrees() {
    setB1((prevB1) => {
      if (prevB1 + 1 >= 20) {
        setB2((prevB2) => {
          if (prevB2 + 2 >= 20) {
            setB3((prevB3) => prevB3 + 3);
          }
          if (prevB2 + 2 <= 30)
            return prevB2 + 2;
          return prevB2 + 1
        });
      }
      return prevB1 + 1;
    });
  }

  useEffect(() => {
    const interval = setInterval(updateDegrees, 50);
    setInter(interval);
    return () => clearInterval(interval);
  }, []);

  useEffect(() => {
    if (B1 >= 35) {
      clearInterval(inter);
      setB1(39)
    }
  }, [B1, inter]);
  return (
    <div style={{
      position: 'relative'
    }}>
      <div className="hero-container">
        <div className="hero">
          <p className="herotext">BookBite</p>
          <p className="herotext2">Read. Review. Repeat.</p>
          <button className="get-started" onClick={() => { window.location.href = "/#/store"; }}>Get started
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
        <div className="books">
          <div className="book" style={{
            transform: `rotate(${B1}deg)`,
          }}>
            <p>
              Fiction
            </p>
          </div>
          <div className="book var-1" style={{
            transform: `rotate(${B2}deg)`,

          }}>
            <p>
              Non - Fiction
            </p>
          </div>
          <div className="book var-2" style={{
            transform: `rotate(${B3}deg)`,
          }}
          >
            <p>
              Romance
            </p>
          </div>
        </div>

      </div>
    </div>
  );
}
