package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.CountryDTO;
import com.personalprojects.MyBookstore.exception.NotFoundException;
import com.personalprojects.MyBookstore.mapper.CountryMapper;
import com.personalprojects.MyBookstore.model.Country;
import com.personalprojects.MyBookstore.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CountryService implements ICountryService{
    @Autowired
    private CountryRepository repo;

    @Override
    public List<CountryDTO> getCountries() {
        return repo.findAll().stream().map(CountryMapper::toDTO).toList();
    }

    @Override
    public CountryDTO createCountry(CountryDTO countryDTO) {
        return CountryMapper.toDTO(repo.save(CountryMapper.toEntity(countryDTO)));
    }

    @Override
    public CountryDTO updateCountry(Long id, CountryDTO countryDTO) {
        Country country = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Pais no encontrado"));
        country.setName(country.getName());

        return CountryMapper.toDTO(repo.save(country));
    }

    @Override
    public void deleteCountry(Long id) {
        if(!repo.existsById(id)){
            throw new NotFoundException("Pais no encontrado");
        }
        repo.deleteById(id);
    }
}
