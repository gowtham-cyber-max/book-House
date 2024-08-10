package com.book.spring.Repos;

import com.book.spring.Models.userModel;
import jakarta.transaction.Transactional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends  MongoRepository<userModel,String>{
    @Transactional
    @Query("{ '$or': [{'user': ?0}, {'email': ?0}] }")
    userModel auth(String user);
}
