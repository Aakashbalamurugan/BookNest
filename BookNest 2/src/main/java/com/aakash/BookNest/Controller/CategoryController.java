package com.aakash.BookNest.Controller;

import com.aakash.BookNest.DTO.CategoryDTOWithId;
import com.aakash.BookNest.DTO.CategoryDTOWithOutId;
import com.aakash.BookNest.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("add")
    @ResponseBody
    public CategoryDTOWithId addCategory(@ModelAttribute CategoryDTOWithOutId categoryDTO){
        return categoryService.addCategory(categoryDTO);
    }
}
