package com.example.Library.mapper;

import com.example.Library.dto.BookDto;
import com.example.Library.entity.Book;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BookMapper {

    Book mapToEntity(BookDto bookDto);
    BookDto mapToDto(Book book);
}
