# PART I of Exercise 12.197: 
# RUN inside mysql> source mysqlCreate.sql
# i. Start the interactive client mysql -u root -p

# ii. CREATE a DATABASE named accounts that has a TABLE named users with 
# headline UserName, Group_, Password_, and Shell
DROP DATABASE IF EXISTS accountDB;
CREATE DATABASE IF NOT EXISTS accountDB;
USE accountDB;
DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (UserName VARCHAR(8), Group_ VARCHAR(8), Password_ VARCHAR(32), Shell VARCHAR(32)); 

# iii. Use LOAD DATA to read the 5-user data, specify via USE, and display all data via SELECT * (alternative use INSERT to create the table)
INSERT INTO users VALUES ("alice", "students", "Password", "/bin/bash");
INSERT INTO users VALUES ("bob", "students", "123456", "/bin/dash");
INSERT INTO users VALUES ("carol",  "students", "carol1", "/bin/bash");
INSERT INTO users VALUES ("dave", "students", "DavE3#", "/bin/sh");
INSERT INTO users VALUES ("eve",  "students", "xu9Kv@W&^fHhH", "/bin/dash");
SELECT * FROM users;
# Expected results...
