package com.book.backend.Repo;

import com.book.backend.Models.PublicReview;
import com.book.backend.Serializer_DTO.PublicReview_DTO;
import jakarta.transaction.Transactional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicReviewRepo extends MongoRepository<PublicReview,String>{

    @Transactional
    @Query("{$or :[{'userid': ?0},{'bookid': ?0}]}")
    List<PublicReview> getReviewByUserId(String id);
}
