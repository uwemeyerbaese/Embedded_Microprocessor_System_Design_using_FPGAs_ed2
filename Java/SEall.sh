echo #!/usr/bash
#---------------------------------------------
echo -- SE language support check script
echo -- Embedded uP System Design with FPGAs
echo -- Author-EMAIL: Uwe.Meyer-Baese@ieee.org
#---------------------------------------------

echo -- Run SE3 check
javac SE2.java; java SE2

echo -- Run SE6 check
javac SE6.java; java SE6

echo -- Run SE8 check
javac SE8.java; java SE8

echo -- Run SE17 check
javac SE17.java; java SE17
