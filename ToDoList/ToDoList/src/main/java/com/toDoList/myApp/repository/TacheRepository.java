package com.toDoList.myApp.repository;

import com.toDoList.myApp.enumeration.Statut;
import com.toDoList.myApp.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {

    List<Tache> findByStatut(Statut statut);
}
