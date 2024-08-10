package com.book.backend.Mapper;

import com.book.backend.Models.Book;
import com.book.backend.Serializer_DTO.Book_DTO;

public class BookMapper {
    public static Book_DTO convertToBook_DTO(Book book){
        return new Book_DTO(
                book.getId(),
                book.getAuthor(),
                book.getName(),
                book.getDescription(),
                book.getPrice(),
                book.getStock(),
                book.isUsed(),
                book.getGenre(),
                book.getDiscount(),
                book.getBinding(),
                book.getPublisher(),
                book.getEdition(),
                book.getIsbn(),
                book.getSold(),
                book.getRatings(),
                book.getImageIds(),
                book.getLanguage()

        );
    }
    public static Book convertToBook(Book_DTO book_dto){
        return new Book(
                book_dto.getId(),
                book_dto.getAuthor(),
                book_dto.getName(),
                book_dto.getDescription(),
                book_dto.getPrice(),
                book_dto.getStock(),
                book_dto.isUsed(),
                book_dto.getGenre(),
                book_dto.getDiscount(),
                book_dto.getBinding(),
                book_dto.getPublisher(),
                book_dto.getEdition(),
                book_dto.getIsbn(),
                book_dto.getSold(),
                book_dto.getRatings(),
                book_dto.getImageIds(),
                book_dto.getLanguage()

        );
    }

}
