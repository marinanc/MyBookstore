package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.AuthorRequestDTO;
import com.personalprojects.MyBookstore.dto.AuthorResponseDTO;
import com.personalprojects.MyBookstore.exception.NotFoundException;
import com.personalprojects.MyBookstore.mapper.AuthorMapper;
import com.personalprojects.MyBookstore.model.Author;
import com.personalprojects.MyBookstore.model.Country;
import com.personalprojects.MyBookstore.repository.AuthorRepository;
import com.personalprojects.MyBookstore.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService{

    private final AuthorRepository repo;
    private final CountryRepository countryRepo;

    @Override
    public List<AuthorResponseDTO> getAuthors() {
        return repo.findAll().stream().map(AuthorMapper::toResponseDTO).toList();
    }

    @Override
    public AuthorResponseDTO createAuthor(AuthorRequestDTO authorReqDTO) {
        Country authorCountry = countryRepo.findById(authorReqDTO.getCountryId())
                .orElseThrow(() -> new NotFoundException("Pais no encontrado"));
        return AuthorMapper.toResponseDTO(repo.save(AuthorMapper.toEntity(authorReqDTO, authorCountry)));
    }

    @Override
    public AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO authorReqDTO) {
        Author author = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Autor no encontrado"));
        Country authorCountry = countryRepo.findById(authorReqDTO.getCountryId())
                        .orElse(null);
        author.setName(authorReqDTO.getName());
        author.setBio(authorReqDTO.getBio());
        author.setCountry(authorCountry);
        return AuthorMapper.toResponseDTO(repo.save(author));
    }

    @Override
    public void deleteAuthor(Long id) {
        if(!repo.existsById(id)) {
            throw new NotFoundException("Autor no encontrado");
        }
        repo.deleteById(id);
    }
}
