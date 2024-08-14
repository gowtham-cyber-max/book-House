package com.book.backend.Controller;

import com.book.backend.Models.Book;
import com.book.backend.Serializer_DTO.Book_DTO;
import com.book.backend.Serializer_DTO.PublicReview_DTO;
import com.book.backend.Service.Service_Class.BookServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {
    @Autowired
    private BookServ s;

//  # Crud Operation

    //    ----->  Add one Book it will return Book

    @PostMapping("/add")
    public ResponseEntity<Book_DTO> addBook(@RequestBody Book_DTO book_dto){
        return new ResponseEntity<Book_DTO>(s.add(book_dto), HttpStatus.OK);
    }

    // -----> Return All books

    @GetMapping("/get-all")
    public ResponseEntity<List<Book_DTO>> get() {
        return new ResponseEntity<List<Book_DTO>>(s.getAll(),HttpStatus.OK);
    }

    @GetMapping("/get/{bId}")
    public ResponseEntity<Book_DTO> getOne(@PathVariable String bId){
        return new ResponseEntity<>(s.get(bId),HttpStatus.OK);
    }
    // -----> update the book

    @PutMapping("/put/{id}")
    public ResponseEntity<Book_DTO> updateBook(@PathVariable String id, @RequestBody Book_DTO book_dto) {
        return new ResponseEntity<Book_DTO>(s.updateBook(id,book_dto),HttpStatus.OK);
    }

    // -----> delete one book

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book_DTO> deleteOneBook(@PathVariable String id) {
        return  new ResponseEntity<Book_DTO>(s.deleteOneBook(id),HttpStatus.OK);
    }

    // implementing search logic

    @GetMapping("/search-book/{word}")
    ResponseEntity<List<Book_DTO>> searchBooks(@PathVariable String word) {
        return  new ResponseEntity<List<Book_DTO>>(s.searchBooks(word),HttpStatus.OK);
    }

    // get list of all genres

    @GetMapping("/genres")
    ResponseEntity<List<String>>getAllGenres(){
        return  new ResponseEntity<List<String>>(s.getAllGenres(),HttpStatus.OK);
    }

    // return best seller based on stoc
    @GetMapping("/best-seller")
    ResponseEntity<List<Book_DTO>>getBestSeller(){
        return new ResponseEntity<List<Book_DTO>>(s.getByBestSeller(),HttpStatus.OK);
    }


    // gets a list of books from list of IDs
    @PostMapping("/get-list")
    ResponseEntity<List<Book_DTO>> getList(@RequestBody List<String> IDs){
        return new ResponseEntity<>(s.getBookList(IDs),HttpStatus.OK);
    }

    //sorting and filtering
    @GetMapping("/custom-get")
    ResponseEntity<List<Book_DTO>> customGet(@RequestParam Integer page,@RequestParam String sort, @RequestParam Boolean order,@RequestParam String genre ){
        return new ResponseEntity<>(s.customGet(page,sort,order,genre),HttpStatus.OK);
    }

    // Add image is List

    @PostMapping("/add-images-id")
    ResponseEntity<Book_DTO>addImageIdList(@RequestBody List<String> newImgIds ,@RequestParam String id){
        return new ResponseEntity<>(s.addImageIdList(newImgIds,id),HttpStatus.OK);
    }

    //delete image by id

    @DeleteMapping("/delete-image")
    ResponseEntity<String>deleteImgById(@RequestParam String bookId,@RequestParam String imgId){
        return new ResponseEntity<>(s.deleteImgById(bookId,imgId),HttpStatus.OK);
    }

    @PutMapping("/buy")
    ResponseEntity<?>buyOneBook(@RequestParam List<String> ids){
        return new ResponseEntity<>(s.buyBooks(ids),HttpStatus.OK);
    }



}
