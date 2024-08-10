package com.book.backend.Repo;

import com.book.backend.Models.User;


import jakarta.transaction.Transactional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User,String> {
    @Transactional
    @Query("{ '$or': [{'user': ?0}, {'email': ?0}] }")
    User login(String user);
}
