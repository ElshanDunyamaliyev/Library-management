package com.example.Library.controller;

import com.example.Library.dto.AuthorDto;
import com.example.Library.dto.PublisherDto;
import com.example.Library.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping
    public List<PublisherDto> getAllPublisher() {
        return publisherService.getAllPublishers();
    }

    @PostMapping
    public ResponseEntity<String> saveAuthor(@RequestBody PublisherDto publisherDto) {
        publisherService.savePublisher(publisherDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Publisher created successfully");
    }

    @PutMapping("/{publisherId}")
    public void updatePublisher(@PathVariable Long publisherId, @RequestBody PublisherDto publisherDto) {
        publisherService.updatePublisherById(publisherId,publisherDto);
    }

    @DeleteMapping("/{publisherId}")
    public void deletePublisher(@PathVariable Long publisherId) {
        publisherService.deletePublisherById(publisherId);
    }
}
