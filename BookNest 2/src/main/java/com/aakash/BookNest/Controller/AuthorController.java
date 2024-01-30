package com.aakash.BookNest.Controller;

import com.aakash.BookNest.DTO.AuthorDTOWithId;
import com.aakash.BookNest.DTO.AuthorDTOWithOutId;
import com.aakash.BookNest.Exception.ServiceException;
import com.aakash.BookNest.Service.AuthorService;
import jakarta.validation.Valid;
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

          return ResponseEntity.ok(authorService.getAll());

    }

    @PostMapping(value = "/addAuthor")
    @ResponseBody
    public ResponseEntity<AuthorDTOWithId> addAuthor(@RequestBody AuthorDTOWithOutId authorDTO){

            return ResponseEntity.ok(authorService.add(authorDTO));

    }

    @PostMapping(value = "/updateAuthor" )
    @ResponseBody
    public ResponseEntity<AuthorDTOWithId> updateAuthor(@RequestBody  AuthorDTOWithId authorDTO){
        try{
            return ResponseEntity.ok(authorService.update(authorDTO));
        } catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
