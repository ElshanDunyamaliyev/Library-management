package com.example.Library.service;

import com.example.Library.dto.BookDto;
import com.example.Library.dto.CategoryDto;
import com.example.Library.entity.Book;
import com.example.Library.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<CategoryDto> getAllCategories();
    public CategoryDto getCategoryById(Long id);
    public void saveCategory(CategoryDto categoryDto);
    public Category updateCategoryById(Long categoryId, CategoryDto categoryDto);
    public void deleteCategoryById(Long categoryId);
}
