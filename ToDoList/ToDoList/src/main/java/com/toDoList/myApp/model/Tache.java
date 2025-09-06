package com.toDoList.myApp.model;

import com.toDoList.myApp.enumeration.Statut;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tache")
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description")
    private String description;

    @Column(name = "statut")
    private Statut statut;


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Statut getStatut() {
        return statut;
    }
    public void setStatut(Statut statut) {
        this.statut = statut;
    }

}
