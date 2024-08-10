package com.book.spring.Services;

import com.book.spring.Models.userModel;
import com.book.spring.Repos.userRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class userServ {
	@Autowired
	private userRepo r;

	public String post(userModel m) {
		r.save(m);
		return "Sucess user upload";
	}

	public List<userModel> get() {
		return r.findAll();
	}

	public String auth(String user, String pass) {
		userModel u=r.auth(user);
		if(u==null)
			return "denied";
		else if(u.getPassword().equals(pass)){
			return "granted";
		}
		else {
			return "pass wrong";
		}
	}
}
