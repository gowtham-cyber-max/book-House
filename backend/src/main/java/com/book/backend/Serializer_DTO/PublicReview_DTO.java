package com.book.backend.Serializer_DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class PublicReview_DTO {
    private String id;
    private String name;
    private Integer stars;
    private String comment;
    public PublicReview_DTO() {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID
    }

}
