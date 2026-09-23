package com.personalprojects.MyBookstore.controller;

import com.personalprojects.MyBookstore.dto.SourceDTO;
import com.personalprojects.MyBookstore.service.ISourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/sources")
@RequiredArgsConstructor
public class SourceController {
    private final ISourceService sourceService;

    @GetMapping
    public ResponseEntity<List<SourceDTO>> getSources() {
        return ResponseEntity.ok(sourceService.getSources());
    }

    @PostMapping
    public ResponseEntity<SourceDTO> createSource(@RequestBody SourceDTO sourceDTO) {
        SourceDTO createdSource = sourceService.createSource(sourceDTO);
        return ResponseEntity.created(URI.create("/api/sources" + createdSource.getId())).body(createdSource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SourceDTO> updateSource(@PathVariable Long id, @RequestBody SourceDTO sourceDTO) {
        return ResponseEntity.ok(sourceService.updateSource(id, sourceDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSource(@PathVariable Long id) {
        sourceService.deleteSource(id);
        return ResponseEntity.noContent().build();
    }

}
