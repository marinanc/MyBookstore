package com.personalprojects.MyBookstore.mapper;

import com.personalprojects.MyBookstore.dto.SourceDTO;
import com.personalprojects.MyBookstore.model.Source;

public class SourceMapper {
    public static SourceDTO toDTO (Source source) {
        if(source == null) return null;

        return SourceDTO.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }

    public static Source toEntity(SourceDTO sourceDTO) {
        if(sourceDTO == null) return null;

        return Source.builder()
                .name(sourceDTO.getName())
                .build();
    }
}
