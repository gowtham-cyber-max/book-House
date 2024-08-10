package com.book.spring.Repos;

import java.util.List;

import com.book.spring.Models.books;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookRepo extends MongoRepository<books, String> {

	@Transactional
	@Query("{$or :[{author: {$regex: ?0, $options: 'i'}},{name: {$regex: ?0, $options: 'i'}},{'publisher': {$regex: ?0, $options: 'i'}},{'isbn': {$regex: ?0, $options: 'i'}}]}")
	public List<books> searchBooks(String word);
	@Query(value ="{}", sort = "{ stock: -1 }")
	List<books> getbestseller(Pageable page);
	@Query("{genre: ?0}")
	List<books> filterByGenre(String word);
	@Query("{ 'genre': ?0 }")
	List<books> getBooksOfGenre(String genre, Sort sort);
}
