package com.aakash.BookNest.DTO;


import com.aakash.BookNest.Model.Role;

public record SignUpDto(
    String login,
    String password,
    Role role) {
}
