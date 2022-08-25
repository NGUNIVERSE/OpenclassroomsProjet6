CREATE DATABASE paymybuddy;
USE paymybyddy;

CREATE TABLE utilisateur(
id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
nom VARCHAR(100),
prenom VARCHAR(100),
email VARCHAR(255) NOT NULL UNIQUE,
motdepasse VARCHAR(255),
connections VARCHAR(255),
solde LONG
#FOREIGN KEY (id)
#REFERENCES transactions(id) 
);

CREATE TABLE transactions(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
descriptions VARCHAR(255),
amount LONG
);