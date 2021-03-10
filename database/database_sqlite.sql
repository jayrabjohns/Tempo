--
-- File generated with SQLiteStudio v3.3.2 on Wed Mar 10 17:30:51 2021
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Exercise_Sessions
CREATE TABLE Exercise_Sessions (user_id INTEGER NOT NULL PRIMARY KEY, exercise_name VARCHAR NOT NULL, exercise_time DOUBLE NOT NULL);

-- Table: Study_Sessions
CREATE TABLE Study_Sessions (user_id INTEGER PRIMARY KEY NOT NULL, study_name VARCHAR NOT NULL, study_time DOUBLE NOT NULL);

-- Table: User_Account
CREATE TABLE User_Account (user_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, username VARCHAR NOT NULL, password VARCHAR NOT NULL, forename VARCHAR NOT NULL, surname VARCHAR NOT NULL, email VARCHAR NOT NULL);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
