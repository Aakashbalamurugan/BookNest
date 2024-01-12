# BookNest
BookNest is a library management application ,
its still in development stage , and works for backend and UI/UX needs to be implemented .

## Technology 
java springBoot
Used mySql for DataBase

## Book

| Field             | Type          | Description                       |
|-------------------|---------------|-----------------------------------|
| id                | int           | Unique identifier                 |
| title             | String        | Book title                        |
| authors           | List<Author>  | List of authors associated        |
| category          | Category      | Category of the book              |
| availableCopies   | Integer       | Number of available copies        |
| createdAt         | Date          | Timestamp of creation             |
| updatedAt         | Date          | Timestamp of last update          |


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

## Author

| Field | Type   | Description               |
|-------|--------|---------------------------|
| id    | long   | Unique identifier         |
| name  | String | Author's name              |
| books | List   | List of books by the author|




