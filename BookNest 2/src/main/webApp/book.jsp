<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.aakash.BookNest.Model.Book" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Book Detail</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        .book-details {
            max-width: 600px;
            margin: 0 auto;
        }
        .btn-back {
            margin-top: 20px;
        }
        footer {
            margin-top: 50px;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="book-details">
        <h2>${book.title}</h2>
        <p><strong>Author:</strong> ${book.author}</p>
        <p><strong>Genre:</strong> ${book.genre}</p>
        <p><strong>Available Copies:</strong> ${book.availableCopies}</p>
        <!-- Add more details as needed -->
    </div>

    <a class="btn btn-primary btn-back" href="bookList.jsp">Back to Book List</a>

    <footer class="mt-5">
        <p>&copy; 2024 Library Management System</p>
    </footer>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
