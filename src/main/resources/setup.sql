CREATE DATABASE `aviabooking`;

USE `aviabooking`;

CREATE TABLE `person`
(
  `id`   BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `first_name` VARCHAR(128) NOT NULL,
  `last_name` VARCHAR(128) NOT NULL,
  `age` INT NOT NULL,
  `passport` VARCHAR(32) NOT NULL,
  `email` VARCHAR(64) NOT NULL
);

INSERT INTO person (first_name, last_name, age, passport, email) VALUES ("Artem", "Uskov", 35, "AA1234BB", "mama@deneg.net");
INSERT INTO person (first_name, last_name, age, passport, email) VALUES ("Roman", "Kurilko", 30, "AN5555BB", "roman@deneg.net");
INSERT INTO person (first_name, last_name, age, passport, email) VALUES ("Sergey", "Nastaj", 32, "AGA1478BB", "sergey@deneg.net");
INSERT INTO person (first_name, last_name, age, passport, email) VALUES ("Rita", "Rovnaya", 25, "AR4409BB", "rita@deneg.net");

