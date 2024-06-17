package com.example.Library.service.impl;

import com.example.Library.dto.PublisherDto;
import com.example.Library.entity.Publisher;
import com.example.Library.exception.ResourceNotFoundException;
import com.example.Library.mapper.PublisherMapper;
import com.example.Library.repository.PublisherRepository;
import com.example.Library.service.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Override
    public List<PublisherDto> getAllPublishers() {
        log.info("ActionLog.getAllPublishers.start");
        var publishers = publisherRepository.findAll().stream().map(publisherMapper::mapToDto).collect(Collectors.toList());
        log.info("ActionLog.getAllPublishers.end");
        return publishers;
    }

    @Override
    public PublisherDto getPublisherById(Long id) {
        log.info("ActionLog.getPublisherById.start");
        var publisher =  publisherMapper.mapToDto(publisherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Publisher Not Found")));
        log.info("ActionLog.getPublisherById.end");
        return publisher;
    }

    @Override
    public void savePublisher(PublisherDto publisherDto) {
        log.info("ActionLog.savePublisher.start");
        publisherRepository.save(publisherMapper.mapToEntity(publisherDto));
        log.info("ActionLog.savePublisher.end");
    }

    @Override
    public void updatePublisherById(Long publisherId, PublisherDto publisherDto) {
        log.info("ActionLog.updatePublisherById.start");
        Publisher publisher = publisherRepository.findById(publisherId).orElseThrow(() -> new ResourceNotFoundException("Publisher Not Found"));
        publisher.setPublisherName(publisherDto.getPublisherName());
        publisherRepository.save(publisher);
        log.info("ActionLog.updatePublisherById.end");
    }

    @Override
    public void deletePublisherById(Long publisherId) {
        log.info("ActionLog.deletePublisherById.start");
        publisherRepository.deleteById(publisherId);
        log.info("ActionLog.deletePublisherById.end");
    }
}
