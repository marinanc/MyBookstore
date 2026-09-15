package com.personalprojects.MyBookstore.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorResponseDTO {
    private Long id;
    private String name;
    private String bio;
    private String countryName;
    private List<String> bookTitles;
}
