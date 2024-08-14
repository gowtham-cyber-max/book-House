package com.book.backend.Controller;

import com.book.backend.Models.Book;
import com.book.backend.Serializer_DTO.User_DTO;
import com.book.backend.Service.Service_Class.UserServ;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserServ s;


    //Add one user
    @PostMapping("/add")
    public ResponseEntity<User_DTO>addUser(@RequestBody User_DTO user_dto){
        User_DTO Temp=s.addUser(user_dto);
        return new ResponseEntity<>(Temp, HttpStatus.CREATED);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<User_DTO>>getAllUser(){
        return new ResponseEntity<>(s.getAllUser(),HttpStatus.FOUND);
    }

    @PostMapping("/login")
    public ResponseEntity<Object>login(@RequestBody User_DTO u){
        String u_id = s.login(u.getUser(), u.getPassword());
        if(u_id.equals("User not found") || u_id.equals("Incorrect Password")){
            return new ResponseEntity<>(u_id, HttpStatus.NOT_ACCEPTABLE);
        }else{
            User_DTO ret = s.getUser(u_id);
            ret.setPassword(null);
            return new ResponseEntity<>(ret,HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/wish")
    public ResponseEntity<User_DTO> addToWishlist(@RequestParam String bid, @RequestParam String uid){
        return new ResponseEntity<>(s.wish(uid, bid),HttpStatus.OK);
    }

    @PostMapping("/friend-request")
    public ResponseEntity<User_DTO> addRequest(@RequestParam String uid,@RequestParam String newid){
        return new ResponseEntity<>(s.addRequest(uid,newid),HttpStatus.OK);
    }
    @PostMapping("/friend-request-accept")
    public ResponseEntity<User_DTO> acceptRequest(@RequestParam String uid,@RequestParam String acceptId){
        return new ResponseEntity<>(s.acceptRequest(uid,acceptId),HttpStatus.OK);
    }

}
