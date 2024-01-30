package com.aakash.BookNest.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public abstract class BookDTO {

    protected String title;


    protected List<String> author;
    protected String category;

    protected Integer availableCopies;


}

