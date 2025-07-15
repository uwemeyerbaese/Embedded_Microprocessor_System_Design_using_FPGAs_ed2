echo #!/usr/bash
#---------------------------------------------
echo === Node Language support check script
echo === Embedded uP System Design with FPGAs
echo === Author-EMAIL: Uwe.Meyer-Baese@ieee.org
#---------------------------------------------
echo === Run procDemo check
node procDemo.js

echo === Run File I/O Example check
node ioExample.js

echo === Run child process Demo check
node cpDemo.js

echo === Run Math Library check
node OpsCmath.js

echo === Run user library check
node module_tb.js

echo === Run OS gpio check Zynq
node cpGpio.js
echo === Run OS gpio check AUP 
node cpAUP.js
