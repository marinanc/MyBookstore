package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.SerieDTO;

import java.util.List;

public interface ISerieService {
    List<SerieDTO> getSeries();
    SerieDTO createSerie(SerieDTO serieDTO);
    SerieDTO updateSerie(Long id, SerieDTO serieDTO);
    void deleteSerie(Long id);
}
