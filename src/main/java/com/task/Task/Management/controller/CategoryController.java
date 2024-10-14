package com.task.Task.Management.controller;

import com.task.Task.Management.dto.CategoryDTO;
import com.task.Task.Management.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public CategoryDTO addCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        return categoryService.addCategory(categoryDTO);
    }

    @GetMapping("/getAllCategories")
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/getById/{categoryId}")
    public CategoryDTO getCategoryById(@PathVariable long categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping("/update/{categoryId}")
    public CategoryDTO updateCategory(@PathVariable long categoryId,@Valid @RequestBody CategoryDTO categoryDTO){
        return categoryService.updateCategory(categoryId,categoryDTO);
    }

    @DeleteMapping("/delete/{categoryId}")
    public CategoryDTO deleteCategory(@PathVariable long categoryId){
        return categoryService.deleteCategory(categoryId);
    }

    @GetMapping("/getByName/{categoryName}")
    public CategoryDTO getCategoryByName(@PathVariable String categoryName){
        return categoryService.getCategoryByName(categoryName);
    }
}
