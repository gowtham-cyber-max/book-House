import React from 'react'
import Rating from 'react-rating'
import  '../styles/reviewitem.css' // Import the CSS file

export default function ReviewItem({ review, profile = false }) {
    return (
        <div className="review-item" onClick={() => {
            if (profile)
                window.location.href = "#/book/" + review.bookid
        }}>
            <div className="review-header">
                <span className="review-name">{window.location.href=="http://localhost:3000/#/profile"&&review.bookname!==null?review.bookname:review.name}</span>
                <Rating 
                    readonly 
                    initialRating={review.stars} 
                    emptySymbol={<span className="material-symbols-outlined star-icon">star</span>} 
                    fullSymbol={<span className="material-symbols-outlined star-icon full-star">star</span>} 
                />
            </div>
            <div className="review-comment">
                {review.comment}
            </div>
        </div>
    )
}
