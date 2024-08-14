package com.book.backend.Service.Service_Class;

import com.book.backend.Mapper.BookMapper;
import com.book.backend.Mapper.PublicReviewMapper;
import com.book.backend.Models.Book;
import com.book.backend.Models.PublicReview;
import com.book.backend.Repo.BookRepo;
import com.book.backend.Serializer_DTO.Book_DTO;
import com.book.backend.Serializer_DTO.PublicReview_DTO;
import com.book.backend.Service.Service_Interface.BookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServ implements BookInterface{
    @Autowired
    private BookRepo r;
    // # Crud Operation

    // -----> Add one Book it will return Book
    public Book_DTO add(Book_DTO book_dto) {
        Book b = BookMapper.convertToBook(book_dto);
        if(b.getImageIds()==null){
            b.setImageIds(List.of()); // it will intialize the image
        }
        if(b.getReviewIds()==null){
            b.setReviewIds(List.of());
        }
        r.save(b);
        return BookMapper.convertToBook_DTO(b);
    }
    public Book_DTO get(String id){
        Book b=r.findByIdCustom(id);
        return BookMapper.convertToBook_DTO(b);
    }

    // ----> get all books
    public List<Book_DTO> getAll() {
        List<Book> allBooks = r.findAll();
        return allBooks.stream().map(BookMapper::convertToBook_DTO)
                .collect(Collectors.toList());
    }

    // --->Update the book

    public Book_DTO updateBook(String id, Book_DTO book_dto) {
        Book newBook = BookMapper.convertToBook(book_dto);
        newBook.setId(id);
        r.save(newBook);
        return BookMapper.convertToBook_DTO(newBook);
    }

    // delete the book

    public Book_DTO deleteOneBook(String id) {
        Book b = r.findByIdCustom(id);
        r.deleteById(id);
        return BookMapper.convertToBook_DTO(b);
    }

    // Search books based on word

    public List<Book_DTO> searchBooks(String word) {
        List<Book> a = r.searchBooks(word);

        if (a != null) {
            return a.stream().map(BookMapper::convertToBook_DTO)
                    .collect(Collectors.toList());
        } else
            return null;
    }

    // get the list of genres

    public List<String> getAllGenres() {
        List<String> genrelist = Arrays.asList("Romance", "Historical", "Mystery", "Comic", "Philosophy", "Thriller",
                "Fiction", "Non - fiction", "Novel", "Sci-fi", "Mythology", "Biography", "Adventure", "Crime",
                "Psychology", "Horror", "Humor");

        return genrelist;
    }

    // return the bestSeller books based on stock

    public List<Book_DTO> getByBestSeller() {
        Pageable page = PageRequest.of(0, 4);
        List<Book> books = r.getbestseller(page);

        return books.stream().map(BookMapper::convertToBook_DTO)
                .collect(Collectors.toList());
    }

    // sorting and filtering get
    public List<Book_DTO>   customGet(Integer page, String sort, Boolean order, String genre) {
        List<Book> bookList;
        if (genre.equals("All") && order)
            bookList = r.findAll(PageRequest.of(page, 9, Sort.by(sort).ascending())).toList();
        else if (genre.equals("All"))
            bookList = r.findAll(PageRequest.of(page, 9, Sort.by(sort).descending())).toList();
        else {
            if (order) {
                bookList = r.getBooksOfGenre(genre, PageRequest.of(page, 9, Sort.by(sort).ascending()));
            } else {
                bookList = r.getBooksOfGenre(genre, PageRequest.of(page, 9, Sort.by(sort).descending()));
            }
        }
        return bookList.stream().map(BookMapper::convertToBook_DTO)
                .collect(Collectors.toList());

    }

    // Adding Images

    public Book_DTO addImageIdList(List<String> newImgIds, String id) {
        Book b = r.findByIdCustom(id);
       // b.getImgIds().add() it will add the values in book model
        // insert new ids using one cmd
        b.getImageIds().addAll(newImgIds);
        // so we reduce this step b.setImageIds(imgList);
        r.save(b);
        return BookMapper.convertToBook_DTO(b);
    }

    public String deleteImgById(String bookId, String imgId) {
        Book b = r.findByIdCustom(bookId);
        b.getImageIds().remove(imgId);
        r.save(b);
        return "Sucess";
    }

    public List<Book_DTO> getBookList(List<String> IDs) {
        return r.findAllById(IDs).stream().map(BookMapper::convertToBook_DTO).collect(Collectors.toList());
    }

    public String buyBooks(List<String>ids){
        for(String i:ids){
            Book b=r.findByIdCustom(i);
            System.out.println(b.getSold());
            b.setSold(b.getSold()+1);

        }
        return "Sucess";
    }
    public void addOneReview(String reviewId, String bookId,Double newstar){
        Book b=r.findByIdCustom(bookId);
        if(b==null){
            return;
        }
        if(b.getReviewIds()==null){
           b.setReviewIds(new ArrayList<>());
        }
        b.getReviewIds().add(reviewId);
        if(b.getAvg()==null || b.getAvg()==0){
            b.setAvg(newstar);
        }
        else{
            Double Totalstars=(b.getAvg()*(b.getReviewIds().size()-1))+(newstar);

        System.out.println(b.getAvg());
            b.setAvg(Totalstars/b.getReviewIds().size());

        }
        r.save(b);
    }


}
