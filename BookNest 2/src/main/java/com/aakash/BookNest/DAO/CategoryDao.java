package com.aakash.BookNest.DAO;

import com.aakash.BookNest.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component

public interface CategoryDao extends JpaRepository<Category,Integer> {
     public Category findByname(String name);
}
