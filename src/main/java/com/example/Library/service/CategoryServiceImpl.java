package com.example.Library.service;

import com.example.Library.dto.CategoryDto;
import com.example.Library.entity.Category;
import com.example.Library.mapper.CategoryMapper;
import com.example.Library.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> getAllCategories(){
        return categoryRepository.findAll().stream().map(categoryMapper::mapToDto).collect(Collectors.toList());
    }

    public CategoryDto getCategoryById(Long categoryId) {
        return categoryMapper.mapToDto(categoryRepository.findById(categoryId).orElseThrow());
    }

    public void saveCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.mapToEntity(categoryDto);
        categoryRepository.save(category);
    }

    public Category updateCategoryById(Long categoryId,CategoryDto categoryDto) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        category.setCategoryType(categoryDto.getCategoryType());
        return categoryRepository.save(category);
    }

    public void deleteCategoryById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
