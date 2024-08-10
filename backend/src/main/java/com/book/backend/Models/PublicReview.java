package com.book.backend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Entity
@Document("PublicReview")
@Getter
@Setter
@AllArgsConstructor
public class PublicReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private Integer stars;
    private String comment;
    public PublicReview() {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID
    }

}
