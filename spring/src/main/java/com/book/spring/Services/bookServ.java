package com.book.spring.Services;

import java.util.*;

import com.book.spring.Models.books;
import com.book.spring.Models.publicReview;
import com.book.spring.Repos.bookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class bookServ {
	@Autowired
	private bookRepo r;

	public String add(books b) {
		r.save(b);
		return "sucess";
	}

	public List<books> getPage(Pageable pg) {
		List<books> arr = r.findAll(pg).toList();
		return arr;
	}

	public books put(String id, books b) {
		b.setId(id);
		// save another value at same id equal to delete previous value
		r.save(b);
		return b;
	}

	public String delete(String id) {
		r.deleteById(id);
		return "del sucess";
	}

	public List<books> searchBooks(String word) {
		List<books> a = r.searchBooks(word);
		if (a != null)
			return a;
		else
			return null;
	}

	public List<books> getPage() {
		return r.findAll();
	}

	public List<String> getgenres() {
		List<String> genrelist = Arrays.asList("Romance", "Historical", "Mystery", "Comic", "Philosophy", "Thriller",
				"Fiction", "Non - fiction", "Novel", "Sci-fi", "Mythology", "Biography", "Adventure", "Crime",
				"Psychology", "Horror", "Humor");

		return genrelist;
	}

	public List<books> getBybestseller() {
		Pageable page = PageRequest.of(0, 4);
		List<books> b = r.getbestseller(page);

		return b;
	}

	public books postReview(String id, publicReview pr) {
		books b = r.findById(id).orElseThrow(() -> new NoSuchElementException("Book not found with id: " + id));
		// List<publicReview> publicReviewList=b.getRatings();
		// if(publicReviewList==null)
		// publicReviewList=new ArrayList<>();
		// publicReviewList.add(pr);
		// b.setRatings(publicReviewList);

		// i add above functionalities in book model
		b.addRatings(pr);

		r.save(b);

		return b;

	}

	public List<publicReview> getReview(String id) {
		books b = r.findById(id).orElseThrow(() -> new NoSuchElementException("Book not found with id: " + id));
		return b.getRatings();
	}

	public String deleteAllReview(String bookid) {
		books b = r.findById(bookid).orElseThrow(() -> new NoSuchElementException("Book not found with id: " + bookid));
		b.setRatings(null);
		r.save(b);
		return "success";
	}

	public List<books> filterByGenre(String word) {
		return r.filterByGenre(word);
	}

	public List<books> customGet(String sort, Boolean order, String genre) {
		if (genre.equals("All") && order)
			return r.findAll(Sort.by(sort).ascending());
		else if (genre.equals("All"))
			return r.findAll(Sort.by(sort).descending());
		else {
			if (order) {
				return r.getBooksOfGenre(genre, Sort.by(sort).ascending());
			} else {
				return r.getBooksOfGenre(genre, Sort.by(sort).descending());
			}
		}
	}
}
