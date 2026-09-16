package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.SourceDTO;
import com.personalprojects.MyBookstore.exception.NotFoundException;
import com.personalprojects.MyBookstore.mapper.SourceMapper;
import com.personalprojects.MyBookstore.model.Source;
import com.personalprojects.MyBookstore.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SourceService implements ISourceService{
    @Autowired
    private SourceRepository repo;

    @Override
    public List<SourceDTO> getSources() {
        return repo.findAll().stream().map(SourceMapper::toDTO).toList();
    }

    @Override
    public SourceDTO createSource(SourceDTO sourceDTO) {
        return SourceMapper.toDTO(repo.save(SourceMapper.toEntity(sourceDTO)));
    }

    @Override
    public SourceDTO updateSource(Long id, SourceDTO sourceDTO) {
        Source source = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Fuente no encontrada"));
        source.setName(sourceDTO.getName());

        return SourceMapper.toDTO(repo.save(source));
    }

    @Override
    public void deleteSource(Long id) {
        if(!repo.existsById(id)){
            throw new NotFoundException("Fuente no encontrada");
        }
        repo.deleteById(id);
    }
}
