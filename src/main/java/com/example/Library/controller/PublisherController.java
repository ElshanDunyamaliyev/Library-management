package com.example.Library.controller;

import com.example.Library.dto.AuthorDto;
import com.example.Library.dto.PublisherDto;
import com.example.Library.service.PublisherService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(
            summary = "Getting Publishers"
    )
    @GetMapping
    public List<PublisherDto> getAllPublisher() {
        return publisherService.getAllPublishers();
    }

    @Operation(
            summary = "Adding Publisher"
    )
    @PostMapping
    public ResponseEntity<String> savePublisher(@RequestBody PublisherDto publisherDto) {
        publisherService.savePublisher(publisherDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Publisher created successfully");
    }

    @Operation(
            summary = "Updating Publisher"
    )
    @PutMapping("/{publisherId}")
    public void updatePublisher(@PathVariable Long publisherId, @RequestBody PublisherDto publisherDto) {
        publisherService.updatePublisherById(publisherId,publisherDto);
    }

    @Operation(
            summary = "Deleting Publisher"
    )
    @DeleteMapping("/{publisherId}")
    public void deletePublisher(@PathVariable Long publisherId) {
        publisherService.deletePublisherById(publisherId);
    }
}
