package com.exercises.passwordGenerator.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.exercises.passwordGenerator.model.PasswordRequest;

@Service
public class PasswordGeneratorService {

    public String generatePassword(PasswordRequest request) {
    	
    	String alphabetMin = "abcdefghijklmnopqrstuvwxyz";
		String alphabetMaj = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String number = "0123456789";
		String specialChars = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
		StringBuilder password = new StringBuilder(); // optimale pour la concaténation de string
		int secureRandomInt;
		SecureRandom secureRandom = new SecureRandom();
		int randomInt;
		
		System.out.println("Hello ! Welcome to password generator !");
		
		int passLength = request.getLength();
		boolean containsNumber = request.isIncludeNumbers();
		boolean containsSpecialChars = request.isIncludeSpecialChars();
		
		ArrayList<String> arrtype = new ArrayList<String>();
		arrtype.add("min");
		arrtype.add("maj");
		if (containsNumber) arrtype.add("number");
		if (containsSpecialChars) arrtype.add("special");
		
		for (int i = 0; i < passLength; i++) {
			randomInt = secureRandom.nextInt(arrtype.size());
			if (arrtype.get(randomInt).equals("min")) {
				secureRandomInt = secureRandom.nextInt(alphabetMin.length());
				password.append(alphabetMin.charAt(secureRandomInt));
			} else if(arrtype.get(randomInt).equals("maj")) {
				secureRandomInt = secureRandom.nextInt(alphabetMaj.length());
				password.append(alphabetMaj.charAt(secureRandomInt));
			} else if(arrtype.get(randomInt).equals("number")) {
				secureRandomInt = secureRandom.nextInt(number.length());
				password.append(number.charAt(secureRandomInt));
			} else if(arrtype.get(randomInt).equals("special")) {
				secureRandomInt = secureRandom.nextInt(specialChars.length());
				password.append(specialChars.charAt(secureRandomInt));
			}
		}
		
        return password.toString();
    }
}
