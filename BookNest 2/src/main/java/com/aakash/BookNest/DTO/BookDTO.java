package com.aakash.BookNest.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Getter
@Setter
@Component
public abstract class BookDTO {

    @NotNull(message = "Title cannot be Null")
    @NotBlank(message = "Tille cannot be blank")
    @Size(min = 2, message = "Title should have at least 2 characters")
    @Getter
    @Setter
    private String title;

    @NotBlank(message = "Author cannot be blank")
    @Size(min = 2, message = "Author name should have at least 2 characters")
    private String author;

    @NotBlank(message = "Genre cannot be blank")
    @NotNull(message = "Genre cannot be Null")
    private String genre;

    @NotNull(message = "Available copies cannot be null")
    @PositiveOrZero(message = "Available copies must be a non-negative number")
    private Integer availableCopies;


}

