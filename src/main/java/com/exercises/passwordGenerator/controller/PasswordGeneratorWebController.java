package com.exercises.passwordGenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exercises.passwordGenerator.model.PasswordRequest;
import com.exercises.passwordGenerator.service.PasswordGeneratorService;

@Controller
@RequestMapping("/password")
public class PasswordGeneratorWebController {

    private final PasswordGeneratorService passwordGeneratorService;

    public PasswordGeneratorWebController(PasswordGeneratorService passwordGeneratorService) {
        this.passwordGeneratorService = passwordGeneratorService;
    }

    @GetMapping("/generate")
    public String showPasswordForm(Model model) {
        // Ajouter un objet 'PasswordRequest' vide, sans valeurs par défaut
        model.addAttribute("request", new PasswordRequest());
        return "passwordForm";
    }

    @PostMapping("/generate")
    public String generatePassword(@ModelAttribute PasswordRequest request, Model model) {

        // Génère le mot de passe
        String password = passwordGeneratorService.generatePassword(request);

        // Ajoute le mot de passe au modèle
        model.addAttribute("password", password);

        // Ajoute de nouveau l'objet request au modèle après génération du mot de passe
        model.addAttribute("request", request);

        return "passwordForm";  // Retourne à la vue du formulaire
    }
}

