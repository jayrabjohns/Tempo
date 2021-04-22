--
-- File generated with SQLiteStudio v3.3.2 on Wed Apr 7 13:06:50 2021
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Exercise_Sessions
DROP TABLE IF EXISTS Exercise_Sessions;
CREATE TABLE Exercise_Sessions (exercise_session_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, user_id INTEGER NOT NULL REFERENCES User_Accounts (user_id), exercise_name VARCHAR NOT NULL, exercise_time DOUBLE NOT NULL, time_of_exercise DATETIME NOT NULL);

-- Table: Personal_Goals
DROP TABLE IF EXISTS Personal_Goals;
CREATE TABLE Personal_Goals (goal_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, user_id INTEGER REFERENCES User_Accounts (user_id) NOT NULL, goal_title VARCHAR NOT NULL, goal_description VARCHAR NOT NULL, goal_expiration_date DATE);

-- Table: Study_Sessions
DROP TABLE IF EXISTS Study_Sessions;
CREATE TABLE Study_Sessions (study_session_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, user_id INTEGER NOT NULL REFERENCES User_Accounts (user_id), study_name VARCHAR NOT NULL, study_time DOUBLE NOT NULL, time_of_study DATETIME);

-- Table: User_Accounts
DROP TABLE IF EXISTS User_Accounts;
CREATE TABLE User_Accounts (user_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, username VARCHAR NOT NULL, password VARCHAR NOT NULL, forename VARCHAR NOT NULL, surname VARCHAR NOT NULL, email VARCHAR NOT NULL);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
