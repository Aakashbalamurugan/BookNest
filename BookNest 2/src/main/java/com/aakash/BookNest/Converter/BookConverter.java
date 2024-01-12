package com.aakash.BookNest.Converter;

import com.aakash.BookNest.DTO.BookDTOWithOutId;
import com.aakash.BookNest.DTO.BookDTOWithId;
import com.aakash.BookNest.Model.Author;
import com.aakash.BookNest.Model.Book;
import com.aakash.BookNest.Service.AuthorService;
import com.aakash.BookNest.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookConverter {

    @Autowired
    AuthorService authorService;

    @Autowired
    CategoryService catagoryService;


    public Book BookReqDTOToBook(BookDTOWithOutId BookReqDTO) {
        Book book = new Book();
        System.out.print(BookReqDTO.getTitle() +" author "+ BookReqDTO.getAuthor());
        book.setTitle(BookReqDTO.getTitle());
        book.setCategory(catagoryService.getByName(BookReqDTO.getCategory()));
        List<String> authorsName = BookReqDTO.getAuthor() ;

        List<Author> authors = new ArrayList<>();
        for(String i:authorsName){
            authors.add(authorService.getByName(i));
        }
        book.setAuthors(authors);
        book.setAvailableCopies(BookReqDTO.getAvailableCopies());
        return book;
    }

    public BookDTOWithId BookToBookRep(Book book) {
        BookDTOWithId bookRepDTO = new BookDTOWithId();
        bookRepDTO.setId(book.getId());
        bookRepDTO.setTitle(book.getTitle());
        bookRepDTO.setCategory(book.getCategory().getName());
        List<Author> authors = book.getAuthors();
        List<String> authorsName = new ArrayList<>();
        for(Author i:authors){
            authorsName.add(i.getName());
        }
        bookRepDTO.setAuthor(authorsName);
        bookRepDTO.setAvailableCopies(book.getAvailableCopies());
System.out.print(bookRepDTO);
        return bookRepDTO;
    }

    public Book BookRepDTOToBook(BookDTOWithId bookRepDTO) {
        Book book = new Book();
        book.setId(bookRepDTO.getId());
        book.setTitle(bookRepDTO.getTitle());

        List<String> authorsName = bookRepDTO.getAuthor() ;
        List<Author> authors = new ArrayList<>();
        for(String i:authorsName){
            authors.add(authorService.getByName(i));
        }
        book.setCategory(catagoryService.getByName(bookRepDTO.getCategory()));
        book.setAvailableCopies(bookRepDTO.getAvailableCopies());

        return book;
    }
}