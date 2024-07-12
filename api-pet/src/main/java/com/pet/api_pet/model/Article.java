package com.pet.api_pet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    private Instant articleDate;
    private String articleContent;
    private String articleTitle;
    private String articleAuthor;
    private String articleAbstract;

    @ManyToOne
    @JoinColumn(name = "user_Id",nullable = false,foreignKey = @ForeignKey(name = "FK_USER_ID"))

    private User user;
}
