package com.aakash.BookNest.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Getter
@Setter
public class AuthorDTOWithId extends AuthorDTO{
    private long id;
    private List<String> books;
}
