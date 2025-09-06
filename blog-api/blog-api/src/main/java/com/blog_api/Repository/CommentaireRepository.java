package com.blog_api.Repository;


import com.blog_api.Model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
}

