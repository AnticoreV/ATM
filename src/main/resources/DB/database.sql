--Database: Bank

CREATE DATABASE Bank;

--Table: users

CREATE TABLE users(
    id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name   VARCHAR(255) NOT NULL,
    password    VARCHAR(255) NOT NULL
);

--Table: roles

CREATE TABLE roles(
    id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(127) NOT NULL
);

--Table: money_account

CREATE TABLE accounts(
    id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    value       VARCHAR(127) NOT NULL,
    money_count INT
);

--Table: mapping(users, roles, money_account)

CREATE TABLE map(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    account_id INT NOT NULL
);

ALTER TABLE map ADD FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE;
ALTER TABLE map ADD FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE;
ALTER TABLE map ADD FOREIGN KEY (account_id) REFERENCES accounts (id) ON DELETE CASCADE;