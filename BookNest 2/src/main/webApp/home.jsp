<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.aakash.BookNest.Model.Book" %>
<%@ page import="java.util.Iterator" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Library Management System - Books</title>
    <!-- Link to Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2>Book List</h2>

    <div class="row">
        <% 
            List<Book> bookList = (List<Book>) request.getAttribute("allBooks");
            Iterator<Book> iterator = bookList.iterator();
            while(iterator.hasNext()) {
                Book book = iterator.next();
        %>
            <div class="col-md-4 mb-4">
                <div class="card">
                   <a href="/book?id=<%= book.getId() %>">
                    <div class="card-body">
                        <h5 class="card-title"><%= book.getTitle() %></h5>
                        <p class="card-text">Author: <%= book.getAuthor() %></p>
                        <p class="card-text">Genre: <%= book.getGenre() %></p>
                        <p class="card-text">Available Copies: <%= book.getAvailableCopies() %></p>
                    </div>
                   </a>
                </div>
            </div>
        <%
            }
        %>
    </div>

    <a class="btn btn-primary" href="addBook.jsp">Add Book</a>

    <footer class="mt-5">
        <p>&copy; 2024 Library Management System</p>
    </footer>
</div>

<!-- Link to Bootstrap JS and Popper.js (required for Bootstrap dropdowns) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
