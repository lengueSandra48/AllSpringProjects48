package com.userManagment.controller;


import com.userManagment.model.User;
import com.userManagment.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "API DE GESTION DES UTILISATEURS")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Liste de tous les utilisateurs")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Affiche un utilisateur par son ID")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Met à jour un utilisateur")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        //return userService.updateUser(id, user);
        userService.updateUser(id, user);
        return ("Utilisateur modifié avec succès !");
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Supprimer un utilisateur")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        System.out.println("Utilisateur supprimé avec succès");
        //return ResponseEntity.noContent().build();
        return ("Utilisateur supprimé avec succès !");
    }



}
