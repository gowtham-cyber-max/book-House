package com.book.backend.Serializer_DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicReview_DTO {
    private String id;
    private String userid;
    private String bookid;
    private String name;
    private String bookname;
    private Double stars;
    private String comment;

}
