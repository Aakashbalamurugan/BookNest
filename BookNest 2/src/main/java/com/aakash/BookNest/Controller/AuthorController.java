package com.aakash.BookNest.Controller;

import com.aakash.BookNest.DTO.AuthorDTOWithId;
import com.aakash.BookNest.DTO.AuthorDTOWithOutId;
import com.aakash.BookNest.Exception.ServiceException;
import com.aakash.BookNest.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    @GetMapping("/get-all")
    @ResponseBody
    public ResponseEntity<List<AuthorDTOWithId>> getall(){
      try{
          return ResponseEntity.ok(authorService.getAll());
      } catch (ServiceException e) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
      }
    }

    @PostMapping(value = "/addAuthor" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResponseEntity<AuthorDTOWithId> addAuthor(@ModelAttribute AuthorDTOWithOutId authorDTO){
        try{
            return ResponseEntity.ok(authorService.add(authorDTO));
        } catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping(value = "/updateAuthor" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResponseEntity<AuthorDTOWithId> updateAuthor(@ModelAttribute AuthorDTOWithId authorDTO){
        try{
            return ResponseEntity.ok(authorService.update(authorDTO));
        } catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
