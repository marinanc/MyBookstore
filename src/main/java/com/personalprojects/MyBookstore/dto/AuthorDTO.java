package com.personalprojects.MyBookstore.dto;

import lombok.*;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDTO {
    private Long id;
    private String name;
    private String bio;
    private CountryDTO country;
    private Set<BookDTO> books;
}
