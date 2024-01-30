package com.aakash.BookNest.Controller;

import com.aakash.BookNest.DTO.BookDTOWithOutId;
import com.aakash.BookNest.DTO.BookDTOWithId;
import com.aakash.BookNest.Exception.ServiceException;
import com.aakash.BookNest.Service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping("all-book")
    @ResponseBody
    public ResponseEntity<List<BookDTOWithId>> showAllBook() {

        try {

            List<BookDTOWithId> bookDTOWithIds = bookService.getAll();
            return ResponseEntity.ok(bookDTOWithIds);

        } catch (ServiceException e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/add-book", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<BookDTOWithId> addBook(@RequestBody BookDTOWithOutId bookDTO) {
        try {

            BookDTOWithId result = bookService.add(bookDTO);
            return ResponseEntity.ok(result);

        } catch (ServiceException e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("book/{id}")
    @ResponseBody
    public ResponseEntity<BookDTOWithId> showBook(@PathVariable("id") int id) {

        try {
            BookDTOWithId result = bookService.get(id);
            return ResponseEntity.ok(result);
        } catch (ServiceException e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }


    }

    @PutMapping(value = "update-Book", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<BookDTOWithId> updateBook(@RequestBody BookDTOWithId bookDTO) {

        try {
            System.out.print("update  " + bookDTO.getId());
            BookDTOWithId result = bookService.update(bookDTO);
            return ResponseEntity.ok(result);

        } catch (ServiceException e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }


    }

    @DeleteMapping("deleteBook/{id}")
    @ResponseBody
    public ResponseEntity<String> DeleteBook(@PathVariable("id") @NotNull int id) {
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
