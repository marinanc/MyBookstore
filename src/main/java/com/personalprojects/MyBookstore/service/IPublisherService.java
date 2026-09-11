package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.PublisherDTO;

import java.util.List;

public interface IPublisherService {
    List<PublisherDTO> getPublishers();
    PublisherDTO createPublisher(PublisherDTO publisherDTO);
    PublisherDTO updatePublisher(Long id, PublisherDTO publisherDTO);
    void deletePublisher(Long id);
}
