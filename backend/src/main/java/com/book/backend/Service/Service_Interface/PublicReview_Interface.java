package com.book.backend.Service.Service_Interface;

import com.book.backend.Serializer_DTO.Book_DTO;
import com.book.backend.Serializer_DTO.PublicReview_DTO;

import java.util.List;

public interface PublicReview_Interface {
    public PublicReview_DTO addOneReview(PublicReview_DTO pr);
    public List<PublicReview_DTO> getByBookUserId(String id);

    public PublicReview_DTO getOneReview(String id) ;
    public String deleteOneReview(String id);
    public PublicReview_DTO updateOneReview(String id,PublicReview_DTO pr);

}
