package com.book.spring.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document("books")
public class books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	private String author;
	private String  name;
	private String  description;
	private Integer  price;
	private Integer  stock;
	private boolean  used;
	private List<String>  genre;
	private Double  discount;
	private String binding ;
	private String publisher ;
	private String edition ;
	private String isbn;
	private Integer sold;
	private List<publicReview> ratings;
	private List<String> imageIds;

	public Integer getSold() {
		return sold;
	}

	public void setSold(Integer sold) {
		this.sold = sold;
	}

	private String languages;
	public List<String> getImageIds() {
		return imageIds;
	}

	public void setImageIds(List<String> imageIds) {
		this.imageIds = imageIds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}


	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<publicReview> getRatings() {
		return ratings;
	}

	public void setRatings(List<publicReview> ratings) {
		this.ratings = ratings;
	}
	public void addRatings(publicReview pr) {
		if (ratings==null)
			ratings=new ArrayList<>();
		this.ratings.add(pr);
	}


	

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}
}
