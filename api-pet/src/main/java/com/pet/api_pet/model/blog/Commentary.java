package com.pet.api_pet.model.blog;

import com.pet.api_pet.model.auth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="commentaries")
public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;
    @Column(name = "comment_content")
    private String commentContent;
    @Column(name = "comment_date")
    private LocalDate commentDate;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false,foreignKey = @ForeignKey(name = "FK_USER_ID"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "article_id",nullable = false,foreignKey = @ForeignKey(name = "FK_ARTICLE_ID"))
    private Article article;

}
