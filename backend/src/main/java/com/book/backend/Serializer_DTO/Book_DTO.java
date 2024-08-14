package com.book.backend.Serializer_DTO;

import com.book.backend.Models.PublicReview;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book_DTO {
    private String id;

    private String author;
    private String  name;
    private String  description;
    private Integer  price;
    private Integer  stock;
    private boolean  used;
    private List<String> genre;
    private Double  discount;
    private String binding ;
    private String publisher ;
    private String isbn;
    private Integer sold;
    private String buy;
    private String read;
    private Double avg;
    private List<String> reviewIds;
    private List<String> imageIds;
    private String language;
}
