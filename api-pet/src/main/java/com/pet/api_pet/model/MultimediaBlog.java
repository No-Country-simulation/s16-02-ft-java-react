package com.pet.api_pet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "multimedias_blog")
public class MultimediaBlog {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column(name = "m_blog_id")
    private UUID mBlogId = UUID.randomUUID();
    private String mBlogUrl;
    private Boolean mBlogFrontPage;
    private Integer mBlogPosition;
    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false, foreignKey = @ForeignKey(name = "FK_MULTIMEDIABLOG_ARTICLE"))
    private Article article;
}
