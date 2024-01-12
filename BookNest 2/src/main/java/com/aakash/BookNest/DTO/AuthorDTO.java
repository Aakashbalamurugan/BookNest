package com.aakash.BookNest.DTO;

import com.aakash.BookNest.Model.Book;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public abstract class AuthorDTO {

    protected String name ;

}
