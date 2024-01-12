package com.aakash.BookNest.Service;

import com.aakash.BookNest.Converter.CategoryConverter;
import com.aakash.BookNest.DAO.CategoryDao;
import com.aakash.BookNest.DTO.CategoryDTOWithId;
import com.aakash.BookNest.DTO.CategoryDTOWithOutId;
import com.aakash.BookNest.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    CategoryConverter converter;

    public CategoryDTOWithId addCategory(CategoryDTOWithOutId categoryDTO) {
        Category category = converter.categoryDTOWithOutIdToCategory(categoryDTO);
        Category savedCategory = categoryDao.save(category);
        return converter.categoryToCategoryDTOWithId(savedCategory);
    }


    public Category getByName(String name){
        return categoryDao.findByname(name);
    }
}
