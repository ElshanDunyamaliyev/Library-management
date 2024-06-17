package com.example.Library.controller;

import com.example.Library.dto.CategoryDto;
import com.example.Library.service.impl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @Operation(
            summary = "Getting all Categories",
            description = "REST API to Getting all Categories"
    )
    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @Operation(
            summary = "Adding Category",
            description = "REST API to Adding Category"
    )
    @PostMapping
    public void addCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.saveCategory(categoryDto);
    }

    @Operation(
            summary = "Deleting Category",
            description = "REST API to Deleting Category"
    )
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
    }
}
