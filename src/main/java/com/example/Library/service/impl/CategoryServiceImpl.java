package com.example.Library.service.impl;

import com.example.Library.dto.CategoryDto;
import com.example.Library.entity.Category;
import com.example.Library.exception.ResourceNotFoundException;
import com.example.Library.mapper.CategoryMapper;
import com.example.Library.repository.CategoryRepository;
import com.example.Library.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> getAllCategories(){
        log.info("ActionLog.getAllCategories.start");
        var categories = categoryRepository.findAll(PageRequest.of(0,5)).stream().map(categoryMapper::mapToDto).collect(Collectors.toList());
        log.info("ActionLog.getAllCategories.end");
        return categories;
    }

    public CategoryDto getCategoryById(Long categoryId) {
        log.info("ActionLog.getCategoryById.start");
        var category = categoryMapper.mapToDto(categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category Not Found")));
        log.info("ActionLog.getCategoryById.end");
        return category;
    }

    public void saveCategory(CategoryDto categoryDto) {
        log.info("ActionLog.saveCategory.start");
        Category category = categoryMapper.mapToEntity(categoryDto);
        categoryRepository.save(category);
        log.info("ActionLog.saveCategory.end");
    }

    public Category updateCategoryById(Long categoryId,CategoryDto categoryDto) {
        log.info("ActionLog.updateCategoryById.start");
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));
        category.setCategoryName(categoryDto.getCategoryName());
        log.info("ActionLog.updateCategoryById.end");
        return categoryRepository.save(category);
    }

    public void deleteCategoryById(Long categoryId) {
        log.info("ActionLog.deleteCategoryById.start");
        categoryRepository.deleteById(categoryId);
        log.info("ActionLog.deleteCategoryById.end");
    }
}
