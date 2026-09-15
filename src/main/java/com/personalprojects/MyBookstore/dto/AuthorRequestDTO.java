package com.personalprojects.MyBookstore.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorRequestDTO {
    private String name;
    private String bio;
    private Long countryId;
}
