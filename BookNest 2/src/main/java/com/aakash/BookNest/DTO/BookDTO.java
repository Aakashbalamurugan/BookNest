package com.aakash.BookNest.DTO;

import com.aakash.BookNest.Model.Author;
import com.aakash.BookNest.Model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Component
public abstract class BookDTO {

    protected String title;


    protected List<String> author;
    protected String category;

    protected Integer availableCopies;


}

