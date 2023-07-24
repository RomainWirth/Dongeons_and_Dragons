# utiliser mysql en ligne de commande
# si DB D_D n'existe pas
CREATE DATABASE D_D;
# voir les DB existantes
SHOW DATABASES;
# utiliser la DB
USE D_D;
# ajout table hero pour sauvegarder le personnage
DROP TABLE IF EXISTS hero;
CREATE TABLE hero (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    hero_class VARCHAR(100) NOT NULL,
    name VARCHAR(100) UNIQUE NOT NULL,
    health_points INT NOT NULL,
    strength INT NOT NULL,
    offensive_type VARCHAR(250),
    offensive_equipment VARCHAR(250),
    defensive_type VARCHAR(250),
    defensive_equipment VARCHAR(250),
    board_id INT REFERENCES board (id)
);

# Table plateau
DROP TABLE IF EXISTS board;
CREATE TABLE board (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,

);