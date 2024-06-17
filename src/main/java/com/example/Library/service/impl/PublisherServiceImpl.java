package com.example.Library.service.impl;

import com.example.Library.dto.PublisherDto;
import com.example.Library.entity.Publisher;
import com.example.Library.mapper.PublisherMapper;
import com.example.Library.repository.PublisherRepository;
import com.example.Library.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Override
    public List<PublisherDto> getAllPublishers() {
        return publisherRepository.findAll().stream().map(publisherMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public PublisherDto getPublisherById(Long id) {
        return publisherMapper.mapToDto(publisherRepository.findById(id).orElseThrow());
    }

    @Override
    public void savePublisher(PublisherDto publisherDto) {
        publisherRepository.save(publisherMapper.mapToEntity(publisherDto));
    }

    @Override
    public void updatePublisherById(Long publisherId, PublisherDto publisherDto) {
        Publisher publisher = publisherRepository.findById(publisherId).orElseThrow();
        publisher.setPublisherName(publisherDto.getPublisherName());
        publisherRepository.save(publisher);
    }

    @Override
    public void deletePublisherById(Long publisherId) {
        publisherRepository.deleteById(publisherId);
    }
}
