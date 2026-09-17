package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.PublisherDTO;
import com.personalprojects.MyBookstore.exception.NotFoundException;
import com.personalprojects.MyBookstore.mapper.PublisherMapper;
import com.personalprojects.MyBookstore.model.Publisher;
import com.personalprojects.MyBookstore.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PublisherService implements IPublisherService {

    private final PublisherRepository repo;

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
        return PublisherMapper.toDTO(repo.save(publisher));
    }

    @Override
    public void deletePublisher(Long id) {
        if(!repo.existsById(id)) {
            throw new NotFoundException("No se encontró la editorial");
        }
        repo.deleteById(id);
    }
}
