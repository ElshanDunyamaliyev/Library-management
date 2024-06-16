package com.example.Library.service;

import com.example.Library.dto.BookDto;
import com.example.Library.dto.CategoryDto;
import com.example.Library.entity.Book;
import com.example.Library.entity.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Long id);
    void saveCategory(CategoryDto categoryDto);
    Category updateCategoryById(Long categoryId, CategoryDto categoryDto);
    void deleteCategoryById(Long categoryId);
}
