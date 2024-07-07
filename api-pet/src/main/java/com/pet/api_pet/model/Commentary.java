package com.pet.api_pet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Commentaries")
public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String commentContent;
    private Instant commentDate;

    @ManyToOne
    @JoinColumn(name = "user_Id",nullable = false,foreignKey = @ForeignKey(name = "FK_USER_ID"))
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "article_id",nullable = false,foreignKey = @ForeignKey(name = "FK_ARTICLE_ID"))
    @JsonIgnore
    private Article article;

}
