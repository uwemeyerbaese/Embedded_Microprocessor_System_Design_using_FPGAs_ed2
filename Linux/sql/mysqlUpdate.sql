# PART II of Exercise 12.197: mysqlUpdate.sql
# RUN inside mysql> source mysqlUpdate.sql
USE accounts;
# iv. Delete the row for user carol 
DELETE from users WHERE UserName = "carol";

# v. Delete the column for Group_
ALTER TABLE users DROP COLUMN Group_;

# vi. Add a FIRST column with id INT PRIMARY KEY AUTO_INCREMENT
ALTER TABLE users ADD COLUMN id INT PRIMARY KEY AUTO_INCREMENT FIRST;

# vii. UPDATE id 4->5 and 3->4. Add a row via INSERT with data:  3, chiara, Chiara4$, /bin/bash
UPDATE users SET id = 5 WHERE id = 4;
UPDATE users SET id = 4 WHERE id = 3;
INSERT INTO users VALUES (3, "chiara", "Chiara4$", "/bin/bash");

#  viii. Display the modified table using SELECT *
SELECT * FROM users;
# Expected results...
#+----+----------+---------------+-----------+
#| id | UserName | Password_     | Shell     |
#+----+----------+---------------+-----------+
#|  1 | alice    | Password      | /bin/bash |
#|  2 | bob      | 123456        | /bin/dash |
#|  3 | chiara   | Chiara4$      | /bin/bash |
#|  4 | dave     | DavE3#        | /bin/sh   |
#|  5 | eve      | xu9Kv@W&^fHhH | /bin/dash |
#+----+----------+---------------+-----------+
#5 rows in set (0.00 sec)

#  ix. Display UserName that do not use bash shell using SELECT * … FROM… WHERE
SELECT * FROM users WHERE Shell NOT LIKE "%bash";
# Expected results...
#+----+----------+---------------+-----------+
#| id | UserName | Password_     | Shell     |
#+----+----------+---------------+-----------+
#|  2 | bob      | 123456        | /bin/dash |
#|  4 | dave     | DavE3#        | /bin/sh   |
#|  5 | eve      | xu9Kv@W&^fHhH | /bin/dash |
#+----+----------+---------------+-----------+
#3 rows in set (0.00 sec)

#  x. Store the table in CSV format using SELECT/INTO/FIELDS/LINES.
#Use SHOW VARIABLES LIKE "secure_file_priv"; to identify writable deictory 
#Verify via office/EXCEL the correct file format.
SELECT * FROM users
INTO OUTFILE '/var/lib/mysql-files/usersTableExport.csv'
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\r\n';

#root@DE10-Standard:/var/lib/mysql-files# more usersTableExport.csv
#1,alice,Password,/bin/bash
#2,bob,123456,/bin/dash
#3,chris,Chris74$,/bin/bash
#4,dave,DavE3#,/bin/sh
#5,eve,xu9Kv@W&^fHhH,/bin/dash

#  xi. Delete the TABLE and DATABASE from the MySQL cache; verify via SHOW
SHOW TABLES;
#+---------------------+
#| Tables_in_accountDB |
#+---------------------+
#| users               |
#+---------------------+
#1 row in set (0.00 sec)

DROP TABLE users;
#Query OK, 0 rows affected (0.01 sec)

SHOW TABLES;
#Empty set (0.00 sec)

SHOW DATABASES;
#+--------------------+
#| Database           |
#+--------------------+
#| information_schema |
#| accounts           |
#| mysql              |
#| performance_schema |
#| sys                |
#+--------------------+
#5 rows in set (0.00 sec)

DROP DATABASE accountDB;
#Query OK, 0 rows affected (0.00 sec)

SHOW DATABASES;
#+--------------------+
#| Database           |
#+--------------------+
#| information_schema |
#| mysql              |
#| performance_schema |
#| sys                |
#+--------------------+
#4 rows in set (0.00 sec)

#  xii. Terminate (the script) using QUIT will issue a Bye
