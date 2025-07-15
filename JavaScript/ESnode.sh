echo #!/usr/bash
#---------------------------------------------
echo -- ES language support check script
echo -- Embedded uP System Design with FPGAs
echo -- Author-EMAIL: Uwe.Meyer-Baese@ieee.org
#---------------------------------------------
echo -- Run ES3 check
node ES3.js

echo -- Run ES5 check
node ES5.js

echo -- Run ES6 check
node ES6.js

echo -- Run reminder of ES check
node ESrest.js
