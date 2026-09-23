package com.personalprojects.MyBookstore.controller;

import com.personalprojects.MyBookstore.dto.SerieDTO;
import com.personalprojects.MyBookstore.service.ISerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/series")
@RequiredArgsConstructor
public class SerieController {
    private final ISerieService serieService;

    @GetMapping
    public ResponseEntity<List<SerieDTO>> getSeries() {
        return ResponseEntity.ok(serieService.getSeries());
    }

    @PostMapping
    public ResponseEntity<SerieDTO> createSerie(@RequestBody SerieDTO serieDTO) {
        SerieDTO createdSerie = serieService.createSerie(serieDTO);
        return ResponseEntity.created(URI.create("/api/series/" + createdSerie.getId())).body(createdSerie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SerieDTO> updateSerie(@PathVariable Long id, @RequestBody SerieDTO serieDTO) {
        return ResponseEntity.ok(serieService.updateSerie(id, serieDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSerie(@PathVariable Long id) {
        serieService.deleteSerie(id);
        return ResponseEntity.noContent().build();
    }
}
