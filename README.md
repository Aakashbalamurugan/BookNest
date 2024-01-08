# BookNest
BookNest is a library management application ,
its still in development stage , and works for backend and UI/UX needs to be implemented .

## Technology 
java springBoot
Used mySql for DataBase

## Book

| Field           | Type    | Extras                                        |
| --------------- | ------- | ---------------------------------------------- |
| id              | Integer | Primary key, unique identifier for the book.   |
| title           | String  | Title of the book.                             |
| author          | String  | Author of the book.                            |
| genre           | String  | Genre or category of the book.                 |
| availableCopies | Integer | Number of copies available for the book.       |


## Features
### AddBook 
  Add a new book object to the DB after validation for the fields 
### UpdateBook
 update the values of a particular book with id , in the DB after validation for the fields 
### GetBook
  Get the Books details with id from th DB as a JSON format
### GetAllBook
 Get all the Books details in the DB as a JSON format
### DeleteBook
   Deletes the book values with reference of the id

