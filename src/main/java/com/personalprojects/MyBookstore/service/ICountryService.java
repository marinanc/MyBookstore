package com.personalprojects.MyBookstore.service;

import com.personalprojects.MyBookstore.dto.CountryDTO;

import java.util.List;

public interface ICountryService {
    List<CountryDTO> getCountries();
    CountryDTO createCountry(CountryDTO countryDTO);
    CountryDTO updateCountry(Long id, CountryDTO countryDTO);
    void deleteCountry(Long id);
}
