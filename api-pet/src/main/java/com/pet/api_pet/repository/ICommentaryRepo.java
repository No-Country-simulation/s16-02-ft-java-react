package com.pet.api_pet.repository;

import com.pet.api_pet.model.Commentary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICommentaryRepo extends IGenericRepo<Commentary,Long> {
    @Query(value = "SELECT c.commentary_id, c.commentary_content, c.commentary_date FROM commentaries c WHERE c.article_id=:id", nativeQuery = true)
    List<Commentary> findAllByArticleId(@PathVariable("id") Long id);
}
