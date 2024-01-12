package com.aakash.BookNest.Converter;

import com.aakash.BookNest.DTO.AuthorDTOWithId;
import com.aakash.BookNest.DTO.AuthorDTOWithOutId;
import com.aakash.BookNest.Exception.ServiceException;
import com.aakash.BookNest.Model.Author;
import com.aakash.BookNest.Model.Book;
import com.aakash.BookNest.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorConvert {

    @Autowired
    BookService bookService;

    public AuthorDTOWithId authorToAuthorDTOWithId(Author author) {
        AuthorDTOWithId dto = new AuthorDTOWithId();
        dto.setId(author.getId());
        dto.setName(author.getName());
        List<Book> bookList = author.getBooks();
        List<String> bookNames = new ArrayList<>();
        for (Book book : bookList) {
            bookNames.add(book.getTitle());
        }
        dto.setBooks(bookNames);
        return dto;
    }

    public Author authorDTOWithOutIdToAuthor(AuthorDTOWithOutId authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());


        return author;
    }

    public Author authorDTOWithIdToAuthor(AuthorDTOWithId authorDTO) throws ServiceException {
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        List<String> bookName =authorDTO.getBooks();
        List<Book> books = new ArrayList<>();
        for (String i : bookName) {
            books.add(bookService.getByTitle(i));
        }

        return author;
    }


}
