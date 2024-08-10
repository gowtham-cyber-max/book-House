package com.book.backend.Repo;

import com.book.backend.Models.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends MongoRepository<Book,String> {
    @Transactional
    @Query("{$or :[{author: {$regex: ?0, $options: 'i'}},{name: {$regex: ?0, $options: 'i'}},{'publisher': {$regex: ?0, $options: 'i'}},{'isbn': {$regex: ?0, $options: 'i'}}]}")
    public List<Book> searchBooks(String word);
    @Query(value ="{}", sort = "{ stock: -1 }")
    List<Book> getbestseller(Pageable page);
    @Query("{genre: ?0}")
    List<Book> filterByGenre(String word);
    @Query("{ 'genre': ?0 }")
    List<Book> getBooksOfGenre(String genre, Pageable page);

    @Query("{'id': ?0}")
    Book findByIdCustom(String id);


}
