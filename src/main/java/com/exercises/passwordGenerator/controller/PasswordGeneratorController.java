package com.exercises.passwordGenerator.controller;

import org.springframework.web.bind.annotation.*;

import com.exercises.passwordGenerator.model.PasswordRequest;
import com.exercises.passwordGenerator.service.PasswordGeneratorService;

@RestController
@RequestMapping("/api/password")
public class PasswordGeneratorController {
	
	private final PasswordGeneratorService passwordGeneratorService;

    public PasswordGeneratorController(PasswordGeneratorService passwordGeneratorService) {
        this.passwordGeneratorService = passwordGeneratorService;
    }

    @PostMapping("/generate")
    public String generatePassword(@RequestBody PasswordRequest request) {
        return passwordGeneratorService.generatePassword(request);
    }
}
