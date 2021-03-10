# Database Overview

There are three tables:

1. User_Account
2. Study_Sessions
3. Exercise_Sessions

Each table has a primary key of **'user_id'** which can be used for JOIN commands when querying the table.
Each attribute has been defined as **NOT NULL**.

## Attributes in User_Account

The 6 columns and their respective datatypes are as follows:

1. **user_id** --- [int]
2. **username** --- [varchar(50)]
3. **password** --- [varchar(50)]
4. **forename** --- [varchar(50)]
5. **surname** --- [varchar(50)]
6. **email** --- [varchar(50)]

The user_id attribute **auto** increments so you do _not_ need to specify it when inserting a new row into the User_Account table

## Attributes in Study_Sessions

The 3 columns and their respective datatypes are as follows:

1. **user_id** --- [int]
2. **study_name** --- [varchar(50)]
3. **study_time** --- [float]

Where **'study_name'** is the user's choice of name for the session (i.e. "Maths revision")

## Attributes in Exercise_Sessions

The 3 columns and their respective datatypes are as follows

1. **user_id** --- [int]
2. **exercise_name** --- [varchar(50)]
3. **exercise_time** --- [float]

Where **'exercise_name'** is the user's choice of name for the session (i.e. "Running")
