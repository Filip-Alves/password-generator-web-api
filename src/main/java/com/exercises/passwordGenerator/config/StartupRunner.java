package com.exercises.passwordGenerator.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started! You can access at the api: http://localhost:8081/api/password/generate");
        System.out.println("Application started! You can access at the website: http://localhost:8081/password/generate");
    }
}
