package com.aakash.BookNest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aakash.BookNest.Model.Book;
import org.springframework.stereotype.Component;

@Component
public interface BookDao extends JpaRepository<Book, Integer> {

    boolean existsByTitle(String title);


    long countByTitle(String title);
}
