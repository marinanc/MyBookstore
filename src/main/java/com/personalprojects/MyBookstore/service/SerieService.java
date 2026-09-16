package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.SerieDTO;
import com.personalprojects.MyBookstore.exception.NotFoundException;
import com.personalprojects.MyBookstore.mapper.SerieMapper;
import com.personalprojects.MyBookstore.model.Serie;
import com.personalprojects.MyBookstore.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SerieService implements ISerieService{
    @Autowired
    private SerieRepository repo;

    @Override
    public List<SerieDTO> getSeries() {
        return repo.findAll().stream().map(SerieMapper::toDTO).toList();
    }

    @Override
    public SerieDTO createSerie(SerieDTO serieDTO) {
        return SerieMapper.toDTO(repo.save(SerieMapper.toEntity(serieDTO)));
    }

    @Override
    public SerieDTO updateSerie(Long id, SerieDTO serieDTO) {
        Serie serie = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Serie no encontrada"));
        serie.setName(serieDTO.getName());
        return SerieMapper.toDTO(repo.save(serie));
    }

    @Override
    public void deleteSerie(Long id) {
        if(!repo.existsById(id)){
            throw new NotFoundException("Serie no encontrada");
        }
        repo.deleteById(id);
    }
}
