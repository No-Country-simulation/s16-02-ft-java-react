package com.pet.api_pet.repository;

import com.pet.api_pet.model.MultimediaBlog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface IMultimediaBlogRepo extends IGenericRepo<MultimediaBlog, UUID> {
    @Query(value = "SELECT mb.blog_id, mb.blog_url, mb.blog_front_page, mb.blog_position FROM multimedias_blog mb WHERE mb.article_id=:id", nativeQuery = true)
    List<MultimediaBlog> findAllByArticleId(@PathVariable("id") UUID id);

}
