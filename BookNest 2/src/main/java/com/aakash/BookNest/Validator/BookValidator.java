package com.aakash.BookNest.Validator;

import com.aakash.BookNest.Exception.ValidationBookException;
import com.aakash.BookNest.Model.Book;
import com.aakash.BookNest.Validator.Constants.ValidationConstants;
import org.springframework.stereotype.Component;

@Component
public class BookValidator {

    public boolean validate(Book book) throws ValidationBookException {
        if (book == null) {
            throw new ValidationBookException(ValidationConstants.NULL_BOOK_ERROR);
        }

        validateTitle(book.getTitle());
        validateAuthor(book.getAuthor());
        validateGenre(book.getGenre());
        validateAvailableCopies(book.getAvailableCopies());

        return true;
    }

    public boolean validId(int id) throws ValidationBookException {
        if (id < 0) {
            throw new ValidationBookException(ValidationConstants.INVALID_ERROR);
        }
        return true;
    }

    private void validateTitle(String title) throws ValidationBookException {
        if (isNullOrEmpty(title)) {
            throw new ValidationBookException(ValidationConstants.TITLE_NULL_OR_EMPTY_ERROR);
        } else if (title.trim().length() < 2) {
            throw new ValidationBookException(ValidationConstants.TITLE_LENGTH_ERROR);
        }
    }

    private void validateAuthor(String author) throws ValidationBookException {
        if (isNullOrEmpty(author)) {
            throw new ValidationBookException(ValidationConstants.AUTHOR_NULL_OR_EMPTY_ERROR);
        } else if (author.trim().length() < 2) {
            throw new ValidationBookException(ValidationConstants.AUTHOR_LENGTH_ERROR);
        }
    }

    private void validateGenre(String genre) throws ValidationBookException {
        if (isNullOrEmpty(genre)) {
            throw new ValidationBookException(ValidationConstants.GENRE_NULL_OR_EMPTY_ERROR);
        }
    }

    private void validateAvailableCopies(int availableCopies) throws ValidationBookException {
        if (availableCopies <= 0) {
            throw new ValidationBookException(ValidationConstants.AVAILABLE_COPIES_NEGATIVE_ERROR);
        }
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
