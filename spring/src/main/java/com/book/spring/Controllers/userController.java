package com.book.spring.Controllers;

import com.book.spring.Models.userModel;
import com.book.spring.Services.userServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public  class userController {
    @Autowired
    private userServ s;
    @PostMapping("/post-user")
    String post(@RequestBody userModel m) {
        return s.post(m);
    }
    @GetMapping("/get-user")
    List<userModel> get(){
        return s.get();
    }

    @PostMapping("/auth")
    String auth(@RequestParam String user, @RequestParam String pass){
        return s.auth(user,pass);
    }


}