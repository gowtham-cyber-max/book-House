import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux'
import { getWishlist } from '../redux/actions/userAction';
import Card from '../components/Card';
import "../styles/profile.css";

export default function Profile() {
    const selector = useSelector(state => state.user)
    if (selector.user == null) {
        return (
            <h2>login to continue</h2>
        )
    }
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(getWishlist());
        console.log(selector)
    }, [])
    return (
        <div className='profile'>
            <h1>{selector.user.user}</h1>
            <h2>Wishlist</h2>
            <div className="book-list">
                {selector.wishlist.map(bk => {
                    return (
                        <Card book={bk} />
                    )
                })}
            </div>
        </div>
    )
}
