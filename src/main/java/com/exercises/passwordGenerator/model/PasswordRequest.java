package com.exercises.passwordGenerator.model;

import lombok.Data;

@Data
public class PasswordRequest {
    private int length;
    private boolean includeNumbers;
    private boolean includeSpecialChars;

    // Getters et setters avec @Data
}
