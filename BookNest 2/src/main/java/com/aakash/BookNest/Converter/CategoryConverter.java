package com.aakash.BookNest.Converter;

import com.aakash.BookNest.DTO.CategoryDTOWithId;
import com.aakash.BookNest.DTO.CategoryDTOWithOutId;
import com.aakash.BookNest.Model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryDTOWithOutId categoryToCategoryDTOWithOutId(Category category) {
        CategoryDTOWithOutId dto = new CategoryDTOWithOutId();
        dto.setName(category.getName());
        // Add any other properties you want to copy
        return dto;
    }

    public Category categoryDTOWithOutIdToCategory(CategoryDTOWithOutId categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        // Add any other properties you want to copy
        return category;
    }

    public CategoryDTOWithId categoryToCategoryDTOWithId(Category category) {
        CategoryDTOWithId dto = new CategoryDTOWithId();
        dto.setId(category.getId());
        dto.setName(category.getName());
        // Add any other properties you want to copy
        return dto;
    }

    public Category categoryDTOWithIdToCategory(CategoryDTOWithId categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        // Add any other properties you want to copy
        return category;
    }

    // Add more methods if needed
}

