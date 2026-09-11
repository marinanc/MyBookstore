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
}
