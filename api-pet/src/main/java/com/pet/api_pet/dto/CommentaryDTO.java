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

public class CommentaryDTO {

    private Long commentId;
    private LocalDate commentDate;


    private String commentContent;

    // agrego una linea extra porque el comentario pertenece a un articulo

    private ArticleDTO articleDTO;
    private UserDTO user;
}
