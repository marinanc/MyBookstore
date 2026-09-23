package com.personalprojects.MyBookstore.controller;

import com.personalprojects.MyBookstore.dto.AuthorRequestDTO;
import com.personalprojects.MyBookstore.dto.AuthorResponseDTO;
import com.personalprojects.MyBookstore.service.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final IAuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorResponseDTO>> getAuthors() {
        return ResponseEntity.ok(authorService.getAuthors());
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDTO> createAuthor(@RequestBody AuthorRequestDTO authorRequestDTO) {
        AuthorResponseDTO createdAuthor = authorService.createAuthor(authorRequestDTO);
        return ResponseEntity.created(URI.create("/api/authors/" + createdAuthor.getId())).body(createdAuthor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> updateAuthor(@PathVariable Long id, @RequestBody AuthorRequestDTO authorRequestDTO) {
        return ResponseEntity.ok(authorService.updateAuthor(id, authorRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
