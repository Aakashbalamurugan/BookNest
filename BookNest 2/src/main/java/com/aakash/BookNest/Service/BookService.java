package com.aakash.BookNest.Service;

import java.util.ArrayList;
import java.util.List;

import com.aakash.BookNest.Converter.BookConverter;
import com.aakash.BookNest.DAO.AuthorDao;
import com.aakash.BookNest.DTO.BookDTOWithOutId;
import com.aakash.BookNest.DTO.BookDTOWithId;
import com.aakash.BookNest.Exception.ServiceException;
import com.aakash.BookNest.Exception.ValidationBookException;
import com.aakash.BookNest.Model.Author;
import com.aakash.BookNest.Validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.aakash.BookNest.DAO.BookDao;

import com.aakash.BookNest.Model.Book;


@Service
public class BookService extends Services {

    @Autowired
    private BookDao bookDAO;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookValidator validator;

    @Autowired
    BookConverter converter;


    public List<BookDTOWithId> getAll() throws ServiceException {
        try {
            List<Book> bookList = bookDAO.findAll();

            List<BookDTOWithId> bookDTOWithIds = new ArrayList<>();
            for (Book i : bookList) {
                bookDTOWithIds.add(converter.BookToBookRep(i));
            }
            return bookDTOWithIds;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }

    }


    public BookDTOWithId add(BookDTOWithOutId bookDTO) throws ServiceException {
        try {
            Book book = converter.BookReqDTOToBook(bookDTO);
            validator.validate(book);

            if (!bookDAO.existsById(book.getId()) && !bookDAO.existsByTitle(book.getTitle())) {
                for(Author i:book.getAuthors()) {
                    if (!authorService.existByName(i.getName())){
                        throw new ServiceException("invalid Author Defined");
                    }
                }
                Book result = bookDAO.save(book);
                System.out.print(result);
                System.out.print(result.getCategory().getName());
                return converter.BookToBookRep(result);
            } else {
                throw new ServiceException("Invalid book ID Or Book already Exists");
            }
        } catch (ValidationBookException e) {
            throw new ServiceException("Invalid book data: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());

        }
    }

    public BookDTOWithId get(int id) throws ServiceException {
        try {
            validator.validId(id);
            Book result = bookDAO.getOne(id);
            return converter.BookToBookRep(result);
        } catch (ValidationBookException e) {
            throw new ServiceException(" Invalid Input" + e.getMessage());
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public BookDTOWithId update(BookDTOWithId newFieldDTO) throws ServiceException {
        try {
            Book newBook = converter.BookRepDTOToBook(newFieldDTO);

            Book oldBook = bookDAO.findById(newBook.getId()).orElse(null);

            Book updatedBook = updateBookFields(oldBook, newBook);

            Book result = bookDAO.save(updatedBook);

            return converter.BookToBookRep(result);

        } catch (Exception e) {
            throw new ServiceException("Error " + e.getMessage());
        }
    }

    public boolean delete(int id) throws ServiceException {
        try {
            validator.validId(id);
            bookDAO.deleteById(id);
            return true;
        } catch (ValidationBookException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Book getByTitle(String title) throws ServiceException {
        try {

            return bookDAO.findByTitle(title);

        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }



    private boolean nullCheck(String str) {
        return str != null && !str.isEmpty();
    }

    private Book updateBookFields(Book oldBook, Book newBook) throws ServiceException {


        if (oldBook != null) {


            if (nullCheck(newBook.getTitle())) {
                if (bookDAO.countByTitle(newBook.getTitle()) > 1) {
                    throw new ServiceException(newBook.getTitle() + " already exists.");
                }
                oldBook.setTitle(newBook.getTitle());
            }
//            if (nullCheck(newBook.getGenre())) {
//                oldBook.setGenre(newBook.getGenre());
//            }
          if (!newBook.getAuthors().isEmpty()){
              boolean flag = false;
              for(Author i: newBook.getAuthors()) {
                  if (authorService.existByName(i.getName())) {
                      flag = true;
                  }
                  else {
                      throw new ServiceException("invalid Author Defined");
                  }
              }

              if (flag) {
                  oldBook.setAuthors(newBook.getAuthors());
              }
          }
            if (newBook.getAvailableCopies() != 0) {
                oldBook.setAvailableCopies(newBook.getAvailableCopies());
            }


            return oldBook;
        } else {
            throw new ServiceException("Book not found " + newBook.getId());
        }
    }
}







