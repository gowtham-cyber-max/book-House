package com.book.backend.Mapper;

import com.book.backend.Models.PublicReview;
import com.book.backend.Serializer_DTO.PublicReview_DTO;

public class PublicReviewMapper {
    public static PublicReview convertToPublicReview(PublicReview_DTO pr){
        return new PublicReview(
                pr.getId(),
                pr.getUserid(),
                pr.getBookid(),
                pr.getName(),
                pr.getBookname(),
                pr.getStars(),
                pr.getComment()
        );
    }
    public static PublicReview_DTO convertToPublicReview_DTO(PublicReview pr){
        return new PublicReview_DTO(
                pr.getId(),
                pr.getUserid(),
                pr.getBookid(),
                pr.getName(),
                pr.getBookname(),
                pr.getStars(),
                pr.getComment()
        );
    }
}
