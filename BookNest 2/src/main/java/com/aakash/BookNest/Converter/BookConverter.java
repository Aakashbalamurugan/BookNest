package com.aakash.BookNest.Converter;

import com.aakash.BookNest.DTO.BookRequestDTO;
import com.aakash.BookNest.DTO.BookResponseDTO;
import com.aakash.BookNest.Model.Book;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    public Book BookReqDTOToBook(BookRequestDTO BookReqDTO) {
        Book book = new Book();
        book.setTitle(BookReqDTO.getTitle());
        book.setAuthor(BookReqDTO.getAuthor());
        book.setGenre(BookReqDTO.getGenre());
        book.setAvailableCopies(BookReqDTO.getAvailableCopies());
        return book;
    }

    public BookResponseDTO BookToBookRep(Book book) {
        var bookRepDTO = new BookResponseDTO();
        bookRepDTO.setId(book.getId());
        bookRepDTO.setTitle(book.getTitle());
        bookRepDTO.setAuthor(book.getAuthor());
        bookRepDTO.setGenre(book.getGenre());
        bookRepDTO.setAvailableCopies(book.getAvailableCopies());

        return bookRepDTO;
    }

    public Book BookRepDTOToBook(BookResponseDTO bookRepDTO) {
        var book = new Book();
        book.setId(bookRepDTO.getId());
        book.setTitle(bookRepDTO.getTitle());
        book.setAuthor(bookRepDTO.getAuthor());
        book.setGenre(bookRepDTO.getGenre());
        book.setAvailableCopies(bookRepDTO.getAvailableCopies());

        return book;
    }
}