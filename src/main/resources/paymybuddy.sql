CREATE DATABASE paymybuddy;
USE paymybuddy;

CREATE TABLE utilisateur(
id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
nom VARCHAR(100),
prenom VARCHAR(100),
email VARCHAR(255) NOT NULL UNIQUE,
motdepasse VARCHAR(255),
solde LONG
);

CREATE TABLE transactions(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
descriptions VARCHAR(255),
amount LONG,
senderid INTEGER , FOREIGN KEY (senderid) REFERENCES utilisateur(id),
recipientid INTEGER , FOREIGN KEY (recipientid) REFERENCES utilisateur(id)
);

CREATE TABLE `connection`(
senderid INTEGER , FOREIGN KEY (senderid) REFERENCES utilisateur(id) ON DELETE RESTRICT ON UPDATE CASCADE,
recipientid INTEGER , FOREIGN KEY (recipientid) REFERENCES utilisateur(id) ON DELETE RESTRICT ON UPDATE CASCADE,
PRIMARY KEY (senderid, recipientid)
);

insert into utilisateur(nom,prenom,email,motdepasse,solde) values("Faraday","Mickael","m.faraday@gmail.com","faraday",1000);

select * from utilisateur;