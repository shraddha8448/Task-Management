package com.task.Task.Management.service;

import com.task.Task.Management.dto.CategoryDTO;
import com.task.Task.Management.modal.Category;

import java.util.List;

public interface CategoryService {

    CategoryDTO addCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> getAllCategory();

    CategoryDTO getCategoryById(long categoryId);

    CategoryDTO updateCategory(long categoryId, CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(long categoryId);

    CategoryDTO getCategoryByName(String categoryName);
}
