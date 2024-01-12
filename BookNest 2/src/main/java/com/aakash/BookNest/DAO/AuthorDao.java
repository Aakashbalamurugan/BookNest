package com.aakash.BookNest.DAO;

import com.aakash.BookNest.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AuthorDao extends JpaRepository<Author,Long> {

   public Author findByname(String name);

   public boolean existsByname(String name);
}



