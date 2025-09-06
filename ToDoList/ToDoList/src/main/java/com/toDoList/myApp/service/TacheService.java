package com.toDoList.myApp.service;

import com.toDoList.myApp.enumeration.Statut;
import com.toDoList.myApp.model.Tache;
import com.toDoList.myApp.repository.TacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class TacheService {

    private final TacheRepository tacheRepository;

    public TacheService(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }

//    public TacheService(TacheRepository tacheRepository) {
//        this.tacheRepository = tacheRepository;
//    }

    public List<Tache> getAllTaches() {
        return tacheRepository.findAll();
    }

    public Optional<Tache> getTaskById(Long id) {
        return tacheRepository.findById(id);
    }

    public List<Tache> getTachesByStatus(Statut status) {
        return tacheRepository.findByStatut(status);
    }

    public Tache createTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    public Optional<Tache> updateTache(Long id, Tache tacheDetails) {
        return tacheRepository.findById(id).map(tache -> {
            tache.setTitre(tacheDetails.getTitre());
            tache.setDescription(tacheDetails.getDescription());
            tache.setStatut(tacheDetails.getStatut());
            return tacheRepository.save(tache);
        });
    }


    public void deleteTache(Long id) {
         tacheRepository.deleteById(id);
    }
}
