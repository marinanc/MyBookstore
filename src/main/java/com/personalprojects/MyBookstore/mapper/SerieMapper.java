package com.personalprojects.MyBookstore.mapper;

import com.personalprojects.MyBookstore.dto.SerieDTO;
import com.personalprojects.MyBookstore.model.Serie;

public class SerieMapper {
    public static SerieDTO toDTO(Serie serie){
        if(serie == null) return null;

        return SerieDTO.builder()
                .id(serie.getId())
                .name(serie.getName())
                .build();
    }

    public static Serie toEntity(SerieDTO serieDTO) {
        if(serieDTO == null) return null;

        return Serie.builder()
                .name(serieDTO.getName())
                .build();
    }
}
