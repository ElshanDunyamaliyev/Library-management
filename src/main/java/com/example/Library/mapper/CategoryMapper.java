package com.example.Library.mapper;

import com.example.Library.dto.BookDto;
import com.example.Library.dto.CategoryDto;
import com.example.Library.entity.Book;
import com.example.Library.entity.Category;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category mapToEntity(CategoryDto categoryDto);
    CategoryDto mapToDto(Category category);
}
