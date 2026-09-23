package com.personalprojects.MyBookstore.controller;

import com.personalprojects.MyBookstore.dto.PublisherDTO;
import com.personalprojects.MyBookstore.service.IPublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {
    private final IPublisherService publisherService;

    @GetMapping
    public ResponseEntity<List<PublisherDTO>> getPublishers() {
        return ResponseEntity.ok(publisherService.getPublishers());
    }

    @PostMapping
    public ResponseEntity<PublisherDTO> createPublisher(@RequestBody PublisherDTO publisherDTO) {
        PublisherDTO createdPublisher = publisherService.createPublisher(publisherDTO);
        return ResponseEntity.created(URI.create("/api/publishers/" + createdPublisher.getId())).body(createdPublisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherDTO> updatePublisher(@PathVariable Long id, @RequestBody PublisherDTO publisherDTO) {
        return ResponseEntity.ok(publisherService.updatePublisher(id, publisherDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return ResponseEntity.noContent().build();
    }
}
