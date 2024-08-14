package com.book.backend.Controller;

import com.book.backend.Serializer_DTO.Book_DTO;
import com.book.backend.Serializer_DTO.PublicReview_DTO;
import com.book.backend.Service.Service_Class.PublicReviewServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class PublicReviewController {
    @Autowired
    PublicReviewServ s;

    @PostMapping("/add")
    ResponseEntity<PublicReview_DTO> addOneReview(@RequestBody PublicReview_DTO pr){
        return new ResponseEntity<>(s.addOneReview(pr), HttpStatus.OK);
    }
    @GetMapping("/get-by-id")
    ResponseEntity<List<PublicReview_DTO>>getReviewById(@RequestParam String id){
        return new ResponseEntity<>(s.getByBookUserId(id),HttpStatus.OK);
    }
    @GetMapping("/get-one")
    ResponseEntity<PublicReview_DTO>getOneReview(@RequestParam String id){
        return new ResponseEntity<>(s.getOneReview(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete-one")
    ResponseEntity<?>deleteOne(@RequestParam String id){
        return new ResponseEntity<>(s.deleteOneReview(id),HttpStatus.OK);
    }
    @PutMapping("/update")
    ResponseEntity<PublicReview_DTO>UpdateOneReview(@RequestParam String id,@RequestBody PublicReview_DTO pr){
        return new ResponseEntity<>(s.updateOneReview(id,pr),HttpStatus.OK);
    }

}
