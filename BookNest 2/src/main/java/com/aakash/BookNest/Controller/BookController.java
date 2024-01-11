package com.aakash.BookNest.Controller;

import com.aakash.BookNest.DTO.BookRequestDTO;
import com.aakash.BookNest.DTO.BookResponseDTO;
import com.aakash.BookNest.Exception.ServiceException;
import com.aakash.BookNest.Service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping("all-book")
    @ResponseBody
    public ResponseEntity<List<BookResponseDTO>> showAllBook() {

        try {

            List<BookResponseDTO> bookResponseDTOS = bookService.getAll();
            return ResponseEntity.ok(bookResponseDTOS);

        } catch (ServiceException e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/add-book", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResponseEntity<BookResponseDTO> addBook(@ModelAttribute BookRequestDTO bookDTO) {
        try {

            BookResponseDTO result = bookService.add(bookDTO);
            return ResponseEntity.ok(result);

        } catch (ServiceException e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("book/{id}")
    @ResponseBody
    public ResponseEntity<BookResponseDTO> showBook(@PathVariable("id") int id) {

        try {
            BookResponseDTO result = bookService.get(id);
            return ResponseEntity.ok(result);
        } catch (ServiceException e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }


    }

    @PutMapping(value = "update-Book", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResponseEntity<BookResponseDTO> updateBook(@ModelAttribute BookResponseDTO bookDTO) {

        try {
            System.out.print("update  " + bookDTO.getId());
            BookResponseDTO result = bookService.update(bookDTO);
            return ResponseEntity.ok(result);

        } catch (ServiceException e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }


    }

    @DeleteMapping("deleteBook/{id}")
    @ResponseBody
    public ResponseEntity<String> DeleteBook(@PathVariable("id") int id) {
        try {
            if (bookService.delete(id))
                return ResponseEntity.ok().build();
            else
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (ServiceException e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
