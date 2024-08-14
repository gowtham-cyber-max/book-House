import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux'
import { getWishlist } from '../redux/actions/userAction';
import Card from '../components/Card';
import "../styles/profile.css";
import axios from 'axios';
import { API_URL } from '../redux/store';
import ReviewItem from '../components/ReviewItem';

export default function Profile() {
    const selector = useSelector(state => state.user)
    if (selector.user == null) {
        return (
            <h2>{"Please "}
                <a href='#/sign-in'>
                    Login
                </a>
                {" to continue"}</h2>
        )
    }
    const dispatch = useDispatch();
    const [reviews, setReviews] = useState([]);
    async function getReviews() {
        try {
            const reviewsRes = await axios.get(API_URL + `/api/review/get-by-id?id=${selector.user.id}`);
            setReviews(reviewsRes.data);
        } catch (error) {
            console.log(error)
        }
    }
    useEffect(() => {
        getReviews();
        dispatch(getWishlist());
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
            <div className='profile-reviews'>
            <div>
                <h1>Your reviews</h1>
            </div>
            <div className='reviews-section'>

            {reviews.map((review) => <ReviewItem profile review={review} />)}
            </div>
            </div>

        </div>
    )
}
