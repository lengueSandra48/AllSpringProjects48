package com.blog_api.Service;


import com.blog_api.Model.Article;
import com.blog_api.Repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article create(Article article) {
        article.setDatePublication(LocalDateTime.now());
        return articleRepository.save(article);
    }

    @Transactional(readOnly = true)
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Article non trouvé"));
    }


//    public Optional<Article> getById(Long id) {
//        return articleRepository.findById(id);
//    }

    public Article update(Long id, Article updatedArticle) {
        return articleRepository.findById(id)
            .map(article -> {
                article.setTitre(updatedArticle.getTitre());
                article.setContenu(updatedArticle.getContenu());
                return articleRepository.save(article);
            })
            .orElseThrow(() -> new RuntimeException("Article non trouvé"));
    }

    public String delete(Long id) {
        articleRepository.deleteById(id);
        return "Article supprimé avec success";
    }
}

