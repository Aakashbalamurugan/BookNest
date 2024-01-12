package com.aakash.BookNest.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class BookDTOWithId extends BookDTO {
    private int id;

}
