package com.book.backend.Serializer_DTO;

import com.book.backend.Models.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User_DTO {
    private String id;
    private String user;
    private String email;
    private String password;
    private Set<String> wishlist;
    private Set<String>friendlist;
    private Set<String>friendrequest;


}
