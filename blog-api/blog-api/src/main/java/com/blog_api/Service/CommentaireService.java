package com.blog_api.Service;


import com.blog_api.Model.Article;
import com.blog_api.Model.Commentaire;
import com.blog_api.Repository.ArticleRepository;
import com.blog_api.Repository.CommentaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentaireService {

    private final CommentaireRepository commentaireRepository;
    private final ArticleRepository articleRepository;

    public Commentaire ajouterCommentaire(Long articleId, Commentaire commentaire) {
        Article article = articleRepository.findById(articleId)
            .orElseThrow(() -> new RuntimeException("Article non trouvé"));
        commentaire.setArticle(article);
        return commentaireRepository.save(commentaire);
    }
}

