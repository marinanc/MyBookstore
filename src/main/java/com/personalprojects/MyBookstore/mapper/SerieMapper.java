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
}
