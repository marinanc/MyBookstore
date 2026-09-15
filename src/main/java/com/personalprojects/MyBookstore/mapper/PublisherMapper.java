package com.personalprojects.MyBookstore.mapper;

import com.personalprojects.MyBookstore.dto.PublisherDTO;
import com.personalprojects.MyBookstore.model.Publisher;

public class PublisherMapper {
    public static PublisherDTO toDTO(Publisher publisher) {
        if(publisher == null) return null;

        return PublisherDTO.builder()
                .id(publisher.getId())
                .name(publisher.getName())
                .build();
    }

    public static Publisher toEntity(PublisherDTO publisherDTO) {
        if(publisherDTO == null) return null;

        return Publisher.builder()
                .name(publisherDTO.getName())
                .build();
    }
}
