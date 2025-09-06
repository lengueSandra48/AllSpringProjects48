package com.blog_api.Controller;


import com.blog_api.Model.Commentaire;
import com.blog_api.Service.CommentaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/articles/{articleId}/commentaires")
//@RequiredArgsConstructor
public class CommentaireController {

    private final CommentaireService commentaireService;

    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }

    @PostMapping
    @Operation(summary = "Ajouter un commentaire")
    public Commentaire ajouterCommentaire(@PathVariable Long articleId, @RequestBody Commentaire commentaire) {
        return commentaireService.ajouterCommentaire(articleId, commentaire);
    }
}

