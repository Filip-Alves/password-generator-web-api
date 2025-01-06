package com.exercises.passwordGenerator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PasswordGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordGeneratorApplication.class, args);
		
		String alphabetMin = "abcdefghijklmnopqrstuvwxyz";
		String alphabetMaj = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String number = "0123456789";
		String specialChars = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
		StringBuilder password = new StringBuilder(); // optimale pour la concaténation de string
		int secureRandomInt;
		SecureRandom secureRandom = new SecureRandom(); 
		int randomInt;
		
		System.out.println("Hello ! Welcome to password generator !");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Quelle longueur de mot de passe vous voulez ? (entre 6 et 30 pour un password efficace)");
		
		int passLength = -1;
		while (true) {
			if (scanner.hasNextInt()) {
				passLength = scanner.nextInt();
				if (passLength >= 6 && passLength < 31) {
					break;
				}
			} else {
				scanner.nextLine();
			}
			System.out.println("vous devez écrire un nombre entre 6 et 30, veuillez réessayé");
		}

		System.out.println("Voulez vous des chiffres (true pour oui/false pour non) ?");
		
		boolean containsNumber;
		while (true) {
			try {
				containsNumber = scanner.nextBoolean();
				break;
			} catch (Exception e) {
				System.out.println("Veuillez réessayé, voulez vous des chiffres (true pour oui/false pour non) ?");
				scanner.nextLine();
			}
		}
		
		System.out.println("Voulez vous des caractère spéciaux (true/false) ?");
		
		boolean containsSpecialChars;
		
		while (true) {
			try {
				containsSpecialChars = scanner.nextBoolean();
				break;
			} catch (Exception e) {
				System.out.println("Veuillez réessayé, voulez vous des caractère spéciaux (true pour oui/false pour non) ?");
				scanner.nextLine();
			}
		}
		
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
		
		System.out.println(password);
	}
}
