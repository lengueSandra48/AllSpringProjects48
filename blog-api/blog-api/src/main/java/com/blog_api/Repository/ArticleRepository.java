package com.blog_api.Repository;



import com.blog_api.Model.Article;
import jakarta.validation.constraints.Digits;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @EntityGraph(attributePaths = "commentaires")
    List<Article> findAll();

    @EntityGraph(attributePaths = "commentaires")
    Optional<Article> findById(Long id);

}
