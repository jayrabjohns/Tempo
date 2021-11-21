# Tempo
## Overview
This was our submission for the group coursework of 'CM10313 - Software Processes & Modelling' in our first year at the University of Bath.

The original specification and our final report can be found in `.\_coursework_report\`

Briefly, the task was to work as a small team of 8, following an Agile process to research, design, develop, and test a Personal Informatics software system. 

Our system times and tracks study & excersise sessions, following the pomodoro technique to help you be more productive.

More details, along with comprehensive documentation of our process can be found in the final report.

# Technical Details
## Database Handler

As it stands, the Databse Handler allows for:
* Inserting a user
* Retrieving user info
* Getting active user ID (redundant now, but still within the code)
* Getting the study time from the user id and study id
* Getting the exercise time from the user id and exercise id
* Current functions to be added:
* Inserting new exercise and study session
* Creating goals
* Updating goals

## Password Encryption
The password encryption uses SHA-256. Currently, one salt is used globally for user logins. Each user could have a salt attached to the database to make comparisons a bit easier, but it's not a necessity.

## Java Version
This project uses Java 11

## External Packages
We've used Maven for dependency management, but just in case here is an exaustive list of dependencies:

* FastXML/Jackson v2.12.2.
* MySQL Java Connector v8.0.23
* Commons validator v1.7
* JUnit v5.7.1

## Folder Structure

- `src/main`: the folder to contain the source code
- `src/test`: contains unit tests 
- `database`: contains database config
- `lib`: the folder to maintain dependencies

## Namespace Structure

- `main.*` - contains the main source code
- `test.*` - contains the unit tests

## Git Ignore

The gitignore has been setup to ignore:

- Generic Java Stuff
- Ecclipse IDE data
- Intelij data
- VSCode data
- SQLite Databases
