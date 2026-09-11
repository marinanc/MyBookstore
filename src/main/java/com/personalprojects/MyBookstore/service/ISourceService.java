package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.SourceDTO;

import java.util.List;

public interface ISourceService {
    List<SourceDTO> getSources();
    SourceDTO createSource(SourceDTO sourceDTO);
    SourceDTO updateSource(Long id, SourceDTO sourceDTO);
    void deleteSource(Long id);
}
