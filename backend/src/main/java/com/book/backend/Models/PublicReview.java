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
@Document("Reviews")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String userid;
    private String bookid;
    private String name;
    private String bookname;
    private Double stars;
    private String comment;

}
