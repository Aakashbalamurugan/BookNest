<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import com.aakash.bookNest.Model.Book%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Add Book</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-T5P7CfXVO1CVP3IrOiAN6m3Hg4W7uXT6x+5H/wlC4l5Y4bP6j8F5d4sUqVKAAWA" crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <h2>${empty book.id ? 'Add Book' : 'Update Book'}</h2>
    <form action="/saveBook" method="post"> <!-- Adjust the action URL based on your mapping -->

<%
    Book book = (Book) request.getAttribute("book");
    if (book == null) {
        book = new Book(); // or initialize it as needed
    }
%>
        <%-- Add a hidden input field to send the book ID for update --%>
        <% if (book.id != null) { %>
            <input type="hidden" name="id" value="<%= book.id %>">
        <% } %>

        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" id="title" name="title" value="<%= book.title != null ? book.title : "" %>" required>
        </div>

        <div class="form-group">
            <label for="author">Author:</label>
            <input type="text" class="form-control" id="author" name="author" value="<%= book.author != null ? book.author : "" %>" required>
        </div>

        <div class="form-group">
            <label for="genre">Genre:</label>
            <input type="text" class="form-control" id="genre" name="genre" value="<%= book.genre != null ? book.genre : "" %>" required>
        </div>

        <div class="form-group">
            <label for="availableCopies">Available Copies:</label>
            <input type="number" class="form-control" id="availableCopies" name="availableCopies" value="<%= book.availableCopies != null ? book.availableCopies : "" %>" required>
        </div>

        <button type="submit" class="btn btn-primary">${ empty book.id ? "Add" : "Update" } Book</button>
    </form>
</div>


<!-- Bootstrap JS and jQuery (needed for Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-btOaZhEsrg3lvRxSrfbXjcOMQgtWyowDMvb1s0dhyybblSb8eXU9l7f5VqQ2fQt"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-9aIt2nRp8A+b8ibpwvFqVu4ZRyUl0i/zOqAMfl/HL8fo3BSe2CfW8e+1Uq4Zabx"
        crossorigin="anonymous"></script>
</body>
</html>