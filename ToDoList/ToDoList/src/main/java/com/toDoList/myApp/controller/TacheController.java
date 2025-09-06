package com.toDoList.myApp.controller;


import com.toDoList.myApp.enumeration.Statut;
import com.toDoList.myApp.model.Tache;
import com.toDoList.myApp.service.TacheService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;


@RestController
@RequestMapping("/api/taches")
//@RequiredArgsConstructor
@Tag(name = "API DE GESTION DE TACHES")
public class TacheController {


    //@Autowired
    private final TacheService tacheService;

    public TacheController(TacheService tacheService) {
        this.tacheService = tacheService;
    }


    @GetMapping
    @Operation(summary = "Liste toutes les tâches")
    public List<Tache> getTaches(@RequestParam(required = false) Statut statut) {
        return (statut != null) ? tacheService.getTachesByStatus(statut) : tacheService.getAllTaches();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupère une tâche par ID")
    public ResponseEntity<Tache> getTaskById(@PathVariable Long id) {
        return ResponseEntity.of(tacheService.getTaskById(id));
    }

    @PostMapping
    @Operation(summary = "Crée une nouvelle tâche")
    public Tache addTache(@RequestBody Tache tache) {
        return tacheService.createTache(tache);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Met à jour une tâche")
    public ResponseEntity<Tache> updateTache(@PathVariable Long id, @RequestBody Tache tache) {
        return ResponseEntity.of(tacheService.updateTache(id, tache));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime une tâche")
    public ResponseEntity<Object> deleteTache(@PathVariable Long id) {
        tacheService.deleteTache(id);
        return ResponseEntity.noContent().build();
    }

}
