package com.example.Library.mapper;

import com.example.Library.dto.AuthorDto;
import com.example.Library.dto.BookDto;
import com.example.Library.entity.Author;
import com.example.Library.entity.Book;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author mapToEntity(AuthorDto authorDto);
    AuthorDto mapToDto(Author author);
}
