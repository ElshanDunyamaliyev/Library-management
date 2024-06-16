package com.example.Library.service;

import com.example.Library.dto.AuthorDto;
import com.example.Library.dto.PublisherDto;

import java.util.List;

public interface PublisherService {

    List<PublisherDto> getAllPublishers();
    PublisherDto getPublisherById(Long id);
    void savePublisher(PublisherDto publisherDto);
    void updatePublisherById(Long publisherId,PublisherDto publisherDto);
    void deletePublisherById(Long publisherId);
}
