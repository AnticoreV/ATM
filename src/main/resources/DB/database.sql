--Database: atm

--CREATE DATABASE atm;
--
--CREATE TABLE users(
--    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
--    user_name VARCHAR(255) NOT NULL,
--    pasword VARCHAR(255) NOT NULL
--);
--CREATE TABLE roles(
--    user_id INT NOT NULL AUTO_INCREMENT,
--    role_name VARCHAR(127) NOT NULL,
--    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
--);
--CREATE TABLE accounts(
--    user_id INT NOT NULL AUTO_INCREMENT,
--    money_count INT,
--    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
--);