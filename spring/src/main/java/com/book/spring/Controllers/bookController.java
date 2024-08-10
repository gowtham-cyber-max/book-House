package com.book.spring.Controllers;

import java.util.List;

import com.book.spring.Models.books;
import com.book.spring.Models.publicReview;
import com.book.spring.Models.userModel;
import com.book.spring.Services.userServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.book.spring.Services.bookServ;

@RestController
public class bookController {
	@Autowired
	private bookServ s;

	@PostMapping("/post-book")
	String post(@RequestBody books b) {
		return s.add(b);
	}

	@GetMapping("/get-book-page/{pgnum}")
	List<books> get(@PathVariable Integer pgnum, @RequestParam String attribute, @RequestParam Boolean order) {
		if (attribute == null) {
			attribute = "id";
		}
		Pageable pg;
		if (order) {
			pg = PageRequest.of(pgnum, 6, Sort.by(attribute).ascending());
		} else {
			pg = PageRequest.of(pgnum, 6, Sort.by(attribute).descending());
		}
		return s.getPage(pg);
	}

	@GetMapping("/get-book")
	List<books> get() {
		return s.getPage();
	}

	@PutMapping("/put-book/{id}")
	books put(@PathVariable String id, @RequestBody books b) {
		return s.put(id, b);
	}

	@DeleteMapping("/delete/{id}")
	String delete(@PathVariable String id) {
		return s.delete(id);
	}

	@GetMapping("/search-book/{word}")
	List<books> searchBooks(@PathVariable String word) {
		return s.searchBooks(word);
	}
	@GetMapping("/genres")
	List<String>getgenres(){
		return s.getgenres();
	}

	@GetMapping("/best-seller")
	List<books>getbestseller(){
		return s.getBybestseller();
	}

	@PostMapping("/post-review/{id}")
	books postReview(@PathVariable String id,@RequestBody publicReview pr){
		return s.postReview(id,pr);
	}

	@GetMapping("/get-review/{id}")
	List<publicReview> getReview(@PathVariable String id){
		return s.getReview(id);
	}


	@DeleteMapping("/delete-review/{bookid}")
	String deleteAllReview(@PathVariable String bookid) {
		return s.deleteAllReview(bookid);
	}

	@GetMapping("/filter-genre/{word}")
	List<books> filterByGenre(@PathVariable String word){
		return s.filterByGenre(word);
	}
	@GetMapping("/custom-get-book")
	List<books> customGet(@RequestParam String sort, @RequestParam Boolean order,@RequestParam String genre ){
		return s.customGet(sort,order,genre);
	}
}
