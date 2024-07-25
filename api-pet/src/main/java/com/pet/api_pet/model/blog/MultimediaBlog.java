package com.pet.api_pet.model.blog;

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
    @Column(name = "blog_id")
    private UUID mBlogId = UUID.randomUUID();
    @Column(name = "blog_url")
    private String mBlogUrl;
    @Column(name = "blog_front_page")
    private Boolean mBlogFrontPage;
    @Column(name = "blog_position")
    private Integer mBlogPosition;
    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false, foreignKey = @ForeignKey(name = "FK_MULTIMEDIABLOG_ARTICLE"))
    private Article article;
}
