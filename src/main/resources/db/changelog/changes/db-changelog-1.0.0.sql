--liquibase formatted sql

--changeset arthur.juchem:1
CREATE TABLE users (
id INT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL
);