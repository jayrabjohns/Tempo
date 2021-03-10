--
-- File generated with SQLiteStudio v3.3.2 on Wed Mar 10 18:07:45 2021
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Exercise_Sessions
CREATE TABLE Exercise_Sessions (exercise_session_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, user_id INTEGER NOT NULL REFERENCES User_Accounts (user_id), exercise_name VARCHAR NOT NULL, exercise_time DOUBLE NOT NULL);

-- Table: Study_Sessions
CREATE TABLE Study_Sessions (study_session_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, user_id INTEGER NOT NULL REFERENCES User_Accounts (user_id), study_name VARCHAR NOT NULL, study_time DOUBLE NOT NULL);

-- Table: User_Accounts
CREATE TABLE User_Accounts (user_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, username VARCHAR NOT NULL, password VARCHAR NOT NULL, forename VARCHAR NOT NULL, surname VARCHAR NOT NULL, email VARCHAR NOT NULL);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
