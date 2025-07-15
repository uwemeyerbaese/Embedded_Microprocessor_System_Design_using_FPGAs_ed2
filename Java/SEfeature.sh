echo #!/usr/bash
echo -------------------------------------------
echo -- SE language feature check script
echo -- Embedded uP System Design with FPGAs
echo -- Author-EMAIL: Uwe.Meyer-Baese@ieee.org
echo -------------------------------------------
echo -- 1: Run File I/O check
javac io.java; java io data.txt

echo -- 2: Run Thread check
javac Count2Ten.java; java Count2Ten

echo -- 3: Run OS command check
javac pingOS.java; java pingOS 

echo -- 4: Run Apache commons-math check
javac -classpath .:commons-math3-3.6.1.jar ApacheMath.java
java -classpath .:commons-math3-3.6.1.jar ApacheMath

echo -- 5: Run AWT URISC2 check
javac urisc2.java; java urisc2      

echo -- 6: Run Swing check
javac NoOpenCV.java; java NoOpenCV

echo -- 7: Run Clock FX check
javac ClockFX.java; java ClockFX

