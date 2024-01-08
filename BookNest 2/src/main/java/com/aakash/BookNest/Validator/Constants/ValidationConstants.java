package com.aakash.BookNest.Validator.Constants;

//ValidationConstants.java

public class ValidationConstants {

 public static final String NULL_BOOK_ERROR = "Book object is null.";
 public static final String TITLE_NULL_OR_EMPTY_ERROR = "Title cannot be null or empty.";
 public static final String AUTHOR_NULL_OR_EMPTY_ERROR = "Author cannot be null or empty.";
 public static final String GENRE_NULL_OR_EMPTY_ERROR = "Genre cannot be null or empty.";
 public static final String AVAILABLE_COPIES_NEGATIVE_ERROR = "Available copies must be a non-negative number.";
 public static final String TITLE_LENGTH_ERROR = "Title should have at least 2 characters.";
 public static final String AUTHOR_LENGTH_ERROR = "Author name should have at least 2 characters.";

 private ValidationConstants() {
     // Private constructor to prevent instantiation.
 }
}

