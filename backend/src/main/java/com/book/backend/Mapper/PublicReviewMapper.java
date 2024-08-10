package com.book.backend.Mapper;

import com.book.backend.Models.PublicReview;
import com.book.backend.Serializer_DTO.PublicReview_DTO;

public class PublicReviewMapper {
    public static PublicReview convertToPublicReview(PublicReview_DTO pr){
        return new PublicReview(
                pr.getId(),
                pr.getName(),
                pr.getStars(),
                pr.getComment()
        );
    }
    public static PublicReview_DTO convertToPublicReview_DTO(PublicReview_DTO pr){
        return new PublicReview_DTO(
                pr.getId(),
                pr.getName(),
                pr.getStars(),
                pr.getComment()
        );
    }
}
