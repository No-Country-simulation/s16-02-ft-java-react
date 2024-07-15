package com.pet.api_pet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
    private LocalDate articleDate;
    private String articleContent;
    private String articleTitle;
    private String articleAuthor;
    private String articleAbstract;

    @ManyToOne
    @JoinColumn(name = "user_Id",nullable = false,foreignKey = @ForeignKey(name = "FK_USER_ID"))
    private User user;

    @OneToMany (mappedBy = "article", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Commentary>commentaries;

    @OneToMany (mappedBy = "article", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<MultimediaBlog>multimediaBlogs;
}
