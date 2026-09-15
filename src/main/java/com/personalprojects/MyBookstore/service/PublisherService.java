package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.PublisherDTO;
import com.personalprojects.MyBookstore.exception.NotFoundException;
import com.personalprojects.MyBookstore.mapper.PublisherMapper;
import com.personalprojects.MyBookstore.model.Publisher;
import com.personalprojects.MyBookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PublisherService implements IPublisherService {
    @Autowired
    private PublisherRepository repo;

    @Override
    public List<PublisherDTO> getPublishers() {
        return repo.findAll().stream().map(PublisherMapper::toDTO).toList();
    }

    @Override
    public PublisherDTO createPublisher(PublisherDTO publisherDTO) {
        return PublisherMapper.toDTO(repo.save(PublisherMapper.toEntity(publisherDTO)));
    }

    @Override
    public PublisherDTO updatePublisher(Long id, PublisherDTO publisherDTO) {
        Publisher publisher = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Editorial no encontrada"));
        publisher.setName(publisherDTO.getName());
        return PublisherMapper.toDTO(publisher);
    }

    @Override
    public void deletePublisher(Long id) {
        if(!repo.existsById(id)) {
            throw new NotFoundException("No se encontró la editorial");
        }
        repo.deleteById(id);
    }
}
