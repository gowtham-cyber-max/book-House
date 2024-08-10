package com.book.spring.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Entity
@Document("publicReview")
public class publicReview {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String name;
	private Integer stars;
	private String comment;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public publicReview() {
		this.id = UUID.randomUUID().toString(); // Generate a unique ID
	}

	
}
