package com.book.backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Entity
@Document("User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String user;
	private String email;
	private String password;
	private Set<String> wishlist;
	private Set<String>friendlist;
	private Set<String>friendrequest;

}
