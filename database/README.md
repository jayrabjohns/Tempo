# Database Overview

There are three tables:

1. User_Account
2. Study_Sessions
3. Exercise_Sessions

Each table has a primary key of **'user_id'** which can be used for JOIN commands when querying the table.
Each attribute has been defined as **NOT NULL**.

## Attributes in User_Account

The 6 columns and their respective datatypes are as follows:

1. **user_id** --- [INTEGER]
2. **username** --- [VARCHAR]
3. **password** --- [VARCHAR]
4. **forename** --- [VARCHAR]
5. **surname** --- [VARCHAR]
6. **email** --- [VARCHAR]

The user_id attribute **auto** increments so you do _not_ need to specify it when inserting a new row into the User_Account table

## Attributes in Study_Sessions

The 3 columns and their respective datatypes are as follows:

1. **user_id** --- [INTEGER]
2. **study_name** --- [VARCHAR]
3. **study_time** --- [DOUBLE]

Where **'study_name'** is the user's choice of name for the session (i.e. "Maths revision")

## Attributes in Exercise_Sessions

The 3 columns and their respective datatypes are as follows

1. **user_id** --- [INTEGER]
2. **exercise_name** --- [VARCHAR]
3. **exercise_time** --- [DOUBLE]

Where **'exercise_name'** is the user's choice of name for the session (i.e. "Running")
