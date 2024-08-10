import React from 'react'
import { useLocation } from 'react-router-dom';
import { searchBooks, getNextBooks } from '../redux/actions/bookListAction';
import { useDispatch, useSelector } from 'react-redux';
import "../styles/navbar.css";

export default function Navbar() {
    const loc = useLocation();
    const selector = useSelector(state => state.user)
    const no_z_list = ["store", "book", "profile"];
    const no_z = no_z_list.some(path => loc.pathname.includes(path));
    const no_search = ["/home", "/seller-home", "/add-book", "/profile"];
    const [q, setQ] = React.useState("");
    const dispatch = useDispatch();

    function handleInput(e) {
        setQ(e.target.value);
    }

    /**
   * Handles the search form submission.
   * @param {Event} e - The form submission event.
   */
    function handleSearch(e) {
        e.preventDefault();
        if (q === "") return;
        dispatch(searchBooks(q)).then(() => {
            window.location.href = "/#/store";
        });
    }

    /**
     * Handles the cancel button click.
     */
    function handleCancel() {
        setQ("");
        dispatch({ type: "CANCEL_SEARCH" });
        dispatch(getNextBooks());
    }

    if (loc.pathname === "/sign-in" || loc.pathname === "/sign-up") return null;
    return (
        <nav className={`navigation ${no_z && "navigation--no-z"}`}>
            <h2 onClick={
                () => {
                    window.location.href = "/#/home";
                }
            }>
                BookBite
                {loc.pathname === "/seller-home" ? (
                    <span
                        className="material-symbols-outlined"
                        onDoubleClick={() => {
                            window.location.href = "/#/home";
                        }}
                    >
                        sell
                    </span>
                ) : (
                    <span
                        className="material-symbols-outlined"
                        onDoubleClick={() => {
                            if (selector.userType == "admin")
                                window.location.href = "/#/seller-home";
                        }}
                    >
                        home
                    </span>
                )}
            </h2>
            {no_search.indexOf(loc.pathname) !== -1 ? null : (
                <div className="search-box">
                    <input
                        className={`search-input`}
                        type="text"
                        placeholder="Search Books"
                        value={q}
                        onChange={handleInput}
                    />
                    <button className="search-submit" onClick={handleCancel}>
                        <span className="material-symbols-outlined">Close</span>
                    </button>
                    <button className="search-submit" onClick={handleSearch}>
                        <span className="material-symbols-outlined">Search</span>
                    </button>
                </div>
            )}
            {selector.user ?
                (
                    <div className='logged-in'>
                        <button
                            className='secondary-button user-name'
                            onClick={() => {
                                window.location.href = "/#/profile";
                            }}
                        >
                            {selector.user.user}
                        </button>
                        <span
                            className='material-symbols-outlined'
                            onClick={() => {
                                dispatch({ type: "SET_USER", payload: null })
                            }}
                        >
                            logout
                        </span>
                    </div>
                )
                :
                (<div>
                    <button
                        className="secondary-button"
                        onClick={() => {
                            window.location.href = "/#/sign-in";
                        }}
                    >
                        Sign In
                    </button>
                    <button
                        onClick={() => {
                            window.location.href = "/#/sign-up";
                        }}
                    >
                        Sign Up
                    </button>
                </div>)
            }
        </nav>
    )
}
