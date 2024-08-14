package com.book.backend.Service.Service_Interface;

import com.book.backend.Mapper.BookMapper;
import com.book.backend.Models.Book;
import com.book.backend.Serializer_DTO.Book_DTO;
import com.book.backend.Serializer_DTO.PublicReview_DTO;

import java.util.List;

public interface BookInterface {
    public Book_DTO add(Book_DTO book_dto);
    public List<Book_DTO> getAll();

    public Book_DTO updateBook(String id, Book_DTO bookDto);

    public Book_DTO deleteOneBook(String id);
    public List<Book_DTO> searchBooks(String word);
    public List<String> getAllGenres();
    public List<Book_DTO> getByBestSeller();
    public List<Book_DTO> customGet(Integer page,String sort, Boolean order, String genre);
    public Book_DTO addImageIdList(List<String> newImgIds,String id);
    public String deleteImgById(String bookId, String imgId);
    public List<Book_DTO> getBookList(List<String> IDs);
    public Book_DTO get(String bId);
    public String buyBooks(List<String>ids);

    void addOneReview(String id, String bookid,Double star);
}
