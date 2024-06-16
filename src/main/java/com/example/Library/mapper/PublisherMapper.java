package com.example.Library.mapper;

import com.example.Library.dto.AuthorDto;
import com.example.Library.dto.PublisherDto;
import com.example.Library.entity.Author;
import com.example.Library.entity.Publisher;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PublisherMapper {

    Publisher mapToEntity(PublisherDto publisherDto);
    PublisherDto mapToDto(Publisher publisher);
}
