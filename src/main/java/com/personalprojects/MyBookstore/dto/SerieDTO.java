package com.personalprojects.MyBookstore.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SerieDTO {
    private Long id;
    private String name;
}
