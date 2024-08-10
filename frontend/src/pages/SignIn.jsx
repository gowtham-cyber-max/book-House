import React, { useState } from "react";
import "../styles/signin.css";
import { useDispatch } from "react-redux";
import { signIn } from "../redux/actions/userAction";

function SignIn() {
  const [user, setUser] = useState("");
  const [password, setPassword] = useState("");
  const dispatch = useDispatch();
  function handleSubmit(e) {
    e.preventDefault();
    dispatch(signIn(user, password));
    window.location.href = "/#/home"
  }
  return (
    <div className="auth-container">
      <form onSubmit={handleSubmit}>
        <fieldset>
          <legend align="left">Sign In</legend>
          <div className="input-grid">
            <input type="text" placeholder="Username" value={user} onChange={(e) => {
              setUser(e.target.value);
            }} />
            <input type="password" placeholder="Password" value={password} onChange={(e) => {
              setPassword(e.target.value);
            }} />
            <button type="submit">Sign In</button>
            <a href="#/sign-up">Don't have an account? Sign Up</a>
          </div>
        </fieldset>
      </form>
    </div>
  );
}

export default SignIn;
