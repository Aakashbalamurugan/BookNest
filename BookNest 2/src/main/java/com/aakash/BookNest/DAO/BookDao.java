package com.aakash.BookNest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aakash.BookNest.Model.Book;

public interface BookDao extends JpaRepository<Book,Integer>{

}
