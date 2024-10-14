package com.task.Task.Management.service;

import com.task.Task.Management.dto.CategoryDTO;
import com.task.Task.Management.exception.CategoryNotFoundException;
import com.task.Task.Management.modal.Category;
import com.task.Task.Management.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO mapToCategoryDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(category.getCategoryName());

        return categoryDTO;
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO){

        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());

        return  mapToCategoryDTO(categoryRepository.save(category));
    }

    @Override
    public List<CategoryDTO> getAllCategory(){
        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(this::mapToCategoryDTO)
                .toList();
    }

    @Override
    public CategoryDTO getCategoryById(long categoryId){
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("Category Not Found"));
        return mapToCategoryDTO(category);
    }

    @Override
    public CategoryDTO updateCategory(long categoryId, CategoryDTO categoryDTO){
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("Category Not Found"));
        category.setCategoryName(categoryDTO.getCategoryName());

        return  mapToCategoryDTO(categoryRepository.save(category));
    }

    @Override
    public CategoryDTO deleteCategory(long categoryId){
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("Category Not Found"));

        categoryRepository.deleteById(categoryId);
        return mapToCategoryDTO(category);
    }

    @Override
    public CategoryDTO getCategoryByName(String categoryName){
        return mapToCategoryDTO(categoryRepository.findByCategoryName(categoryName));
    }
}
