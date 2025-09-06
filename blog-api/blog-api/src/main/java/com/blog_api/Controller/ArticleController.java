package com.blog_api.Controller;



import com.blog_api.Model.Article;
import com.blog_api.Service.ArticleService;
import org.springframework.transaction.annotation.Transactional;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/articles")
//@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    @Operation(summary = "Ajouter un article")
    public Article create(@RequestBody Article article) {
        return articleService.create(article);
    }

    @GetMapping
    @Operation(summary = "Liste de tous les articles")
    public List<Article> getAll() {
        return articleService.getAll();
    }


    @Operation(summary = "Voir un article")
    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public Article getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un article")
    public Article update(@PathVariable Long id, @RequestBody Article article) {
        return articleService.update(id, article);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un article")
    public void delete(@PathVariable Long id) {
        articleService.delete(id);
    }
}

