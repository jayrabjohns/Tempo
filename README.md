# -Monopoly Creating Name Here-

## Explanation for the Database Handler

As it stands, the Databse Handler is being uploaded with Archie's login GUI. The DB Handler exists as its own class, and is a drop-in class that can be implemented across anything. If a new feature is required, don't hesitate to contact me, and I'll try and get a subroutine uploaded that can do what you want it to do.

Right now, the handler has the current functions:
-Inserting a user
-Retrieving user info
-Getting active user ID (redundant now, but still within the code)
-Getting the study time from the user id and study id
-Getting the exercise time from the user id and exercise id

If any other functions are needed, please state so and message me about them.

## Explanation for the Password Encryption

The password encryption uses SHA-256 encoding. Currently, their needs to be a global 'salt' variable added to the register/login forms for ease of use, but this should be fine. Each user could have a salt attached to the database to make comparisons a bit easier, but it's not a necessity

## Java Version

This project uses version 11 (Same version as POP Coursework).

## Folder Structure

- `src`: the folder to maintain sources
- `tests`: contains unit tests
- `database`: contains database config
- `lib`: the folder to maintain dependencies



## Git Ignore

The gitignore has been setup to ignore:

- Generic Java Stuff
- Ecclipse IDE data
- Intelij data
- VSCode data
- SQLite Databases
