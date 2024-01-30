package com.aakash.BookNest.Controller;

import com.aakash.BookNest.DTO.CategoryDTOWithId;
import com.aakash.BookNest.DTO.CategoryDTOWithOutId;
import com.aakash.BookNest.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "add" , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CategoryDTOWithId addCategory(@RequestBody CategoryDTOWithOutId categoryDTO){
        System.out.print(categoryDTO.getName());
        return categoryService.addCategory(categoryDTO);
    }
}
