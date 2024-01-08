package com.aakash.BookNest.Validator;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aakash.BookNest.Model.Book;
import com.aakash.BookNest.Validator.Constants.ValidationConstants;

@Component
public class BookValidator {

    public List<String> validate(Book book) {
        List<String> errors = new ArrayList<>();

        if (book == null) {
            errors.add(ValidationConstants.NULL_BOOK_ERROR);
            return errors;
        }

        // Validate title
        if (isNullOrEmpty(book.getTitle())) {
            errors.add(ValidationConstants.TITLE_NULL_OR_EMPTY_ERROR);
        } else if (book.getTitle().trim().length() < 2) {
            errors.add(ValidationConstants.TITLE_LENGTH_ERROR);
        }

        // Validate author
        if (isNullOrEmpty(book.getAuthor())) {
            errors.add(ValidationConstants.AUTHOR_NULL_OR_EMPTY_ERROR);
        } else if (book.getAuthor().trim().length() < 2) {
            errors.add(ValidationConstants.AUTHOR_LENGTH_ERROR);
        }

        // Validate genre
        if (isNullOrEmpty(book.getGenre())) {
            errors.add(ValidationConstants.GENRE_NULL_OR_EMPTY_ERROR);
        }

        // Validate available copies
        if (book.getAvailableCopies() < 0) {
            errors.add(ValidationConstants.AVAILABLE_COPIES_NEGATIVE_ERROR);
        }

        return errors;
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
