# Password Generator

Générateur de mot de passe sécurisé avec une API REST et une interface web.

## Fonctionnalités

- **API REST** : Génération de mots de passe via POST avec JSON.
- **Interface Web** : Formulaire pour générer un mot de passe en fonction des préférences de l'utilisateur.

## Prérequis

- **Java 17+**
- **Maven**
- **Git**

## Installation

1. Clonez le projet :

   ```bash
   git clone https://github.com/Filip-Alves/password-generator-web-api.git
   cd password-generator-web-api

2. Installez les dépendances Maven :
   ```bash
   mvn install

## Lancer l'application
   ```bash
   mvn spring-boot:run

## API REST
- ** URL : POST /api/password/generate **

- ** Body (JSON) : **

   ```json
   {
     "length": 12,
     "includeNumbers": true,
     "includeSpecialChars": true
   }

Réponse : Mot de passe généré, ex. : "ABc$1234dE"
