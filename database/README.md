# Database Overview

There are four tables:

1. User_Accounts
2. Study_Sessions
3. Exercise_Sessions
4. Personal_Goals

Each attribute has been defined as **NOT NULL** in User_Accounts, Study_Sessions, and Exercise_Sessions.

## Attributes in User_Accounts

The 6 columns and their respective datatypes are as follows:

1. **user_id** --- [INTEGER]
2. **username** --- [VARCHAR]
3. **password** --- [VARCHAR]
4. **forename** --- [VARCHAR]
5. **surname** --- [VARCHAR]
6. **email** --- [VARCHAR]

The primary key for the table is **'user_id'**.
The user_id attribute **auto** increments so you do _not_ need to specify it when inserting a new row into the User_Account table.

## Attributes in Study_Sessions

The 5 columns and their respective datatypes are as follows:

1. **study_session_id** --- [INTEGER]
2. **user_id** --- [INTEGER]
3. **study_name** --- [VARCHAR]
4. **study_time** --- [DOUBLE]
5. **time_of_session** --- [DATETIME]

Where **'study_name'** is the user's choice of name for the session (i.e. "Maths revision")

The primary key for the table is **'study_session_id'**.
The study_session_id attribute **auto** increments so you do _not_ need to specify it when inserting a new row into the Study_Sessions table.

The table has a foreign key **'user_id'** which refers to the primary key in the User_Accounts table.

## Attributes in Exercise_Sessions

The 5 columns and their respective datatypes are as follows

1. **exercise_session_id** --- [INTEGER]
2. **user_id** --- [INTEGER]
3. **exercise_name** --- [VARCHAR]
4. **exercise_time** --- [DOUBLE]
5. **time_of_session** --- [DATETIME]

Where **'exercise_name'** is the user's choice of name for the session (i.e. "Running")

The primary key for the table is **'exercise_session_id'**.
The exercise_session_id attribute **auto** increments so you do _not_ need to specify it when inserting a new row into the Exercise_Sessions table.

The table has a foreign key **'user_id'** which refers to the primary key in the User_Accounts table.

## Attributes in Personal_Goals

The 5 columns and their respective datatypes are as follows:

1. **goal_id** --- [INTEGER]
2. **user_id** --- [INTEGER]
3. **goal_title** --- [VARCHAR]
4. **goal_description** --- [VARCHAR]
5. **goal_expiration_date** --- [DATE]

The only attribute which is allowed to be _NULL_ in this table is **'goal_expiration_date'** as we are unsure as to whether we are going to use it.

The primary key for the table is **'goal_id'**.
The goal_id attribute **auto** increments so you do _not_ need to specify it when inserting a new row into the Personal_Goals table.

The table has a foreign key **'user_id'** which refers to the primary key in the User_Accounts table.