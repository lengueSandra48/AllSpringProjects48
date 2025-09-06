package com.blog_api.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "auteur")
    private String auteur;

    @Column(columnDefinition = "TEXT", name = "contenu")
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "article_id")
    @JsonIgnore
    private Article article;
}

