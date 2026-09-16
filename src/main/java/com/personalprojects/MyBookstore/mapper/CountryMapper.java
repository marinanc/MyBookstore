package com.personalprojects.MyBookstore.mapper;

import com.personalprojects.MyBookstore.dto.CountryDTO;
import com.personalprojects.MyBookstore.model.Country;

public class CountryMapper {
    public static CountryDTO toDTO(Country country) {
        if(country == null) return null;

        return CountryDTO.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }

    public static Country toEntity(CountryDTO countryDTO) {
        if(countryDTO == null) return null;

        return Country.builder()
                .name(countryDTO.getName())
                .build();
    }
}
