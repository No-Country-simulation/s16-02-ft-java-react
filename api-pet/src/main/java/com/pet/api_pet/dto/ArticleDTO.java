package com.pet.api_pet.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ArticleDTO {
    private Long articleId;
    private LocalDate articleDate;
    private String articleContent;
    private String articleTitle;
    private String articleAuthor;
    private String articleAbstract;

    // Agrego esta linea extra correspondiente a la FK, para llamar al DTO del usuario
    private UserDTO user;
}
