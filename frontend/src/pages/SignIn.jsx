import React, { useEffect, useState } from "react";
import "../styles/signin.css";
import { useDispatch, useSelector } from "react-redux";
import { signIn } from "../redux/actions/userAction";

function SignIn() {
  const [user, setUser] = useState("");
  const [password, setPassword] = useState("");
  const userDet = useSelector((state) => state.user.user);
  const dispatch = useDispatch();
  function handleSubmit(e) {
    e.preventDefault();
    dispatch(signIn(user, password));
  }
  useEffect(() => {
    if (userDet) {
      window.history.back();
    }
  }, [userDet])
  return (
    <div className="auth-container">
      <form onSubmit={handleSubmit}>
        <fieldset>
          <div className="input-grid">
          <h2 align="left">Sign In</h2>
            <input type="text" placeholder="Username" value={user} onChange={(e) => {
              setUser(e.target.value);
            }} />
            <input type="password" placeholder="Password" value={password} onChange={(e) => {
              setPassword(e.target.value);
            }} />
            <button className="signin-button" type="submit">Sign In</button>
            <a href="#/sign-up">Don't have an account? Sign Up</a>
          </div>
        </fieldset>
      </form>
    </div>
  );
}

export default SignIn;
