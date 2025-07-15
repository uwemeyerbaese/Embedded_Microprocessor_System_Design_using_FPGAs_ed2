echo -------------------------------------------
echo -- SE Program 15.XX check script
echo -- Embedded uP System Design with FPGAs
echo -- Author-EMAIL: Uwe.Meyer-Baese@ieee.org
echo -------------------------------------------
echo -- Program 15.1: Hello World
javac HelloWorldApp.java
java HelloWorldApp

echo -- Program 15.2: I/O via CLI
javac io.java
java io.java data.txt

echo -- Program 15.3: Collection type arrays 
javac TypeReference.java
java TypeReference

echo -- Program 15.4: see Program 15.2

echo -- Program 15.5: String method demonstration 
javac StringDemo.java
java StringDemo

echo -- Program 15.6: Type overload demo 
javac Add2Overload.java
java Add2Overload

echo -- Program 15.7: Default parameter demo 
javac DefaultOverload.java
java DefaultOverload

echo -- Program 15.8: Package path names 
javac PathNames.java
java PathNames

echo -- Program 15.9: User Package demonstration
javac -d . Utils.java Tb.java
java mypack.Tb

javac -d . Util1.java Util2.java Util3.java Tb3.java
jar cvf util.jar pack
java -classpath .;util.jar mypack.Tb3

echo -- Program 15.10: Measure execution time 
javac SortTime.java
java SortTime

echo -- Program 15.11: Modification of a XLSX format EXCEL file
javac -cp .;poi-3.8.jar;commons-codec-1.5.jar;poi-ooxml-3.8.jar;poi-ooxml-schemas-3.8.jar;xmlbeans-2.3.0.jar;stax-api-1.0.1.jar;dom4j-1.6.1.jar;xml-apis-1.0.b2.jar ApacheXLSXreader.java
java  -cp .;poi-3.8.jar;commons-codec-1.5.jar;poi-ooxml-3.8.jar;poi-ooxml-schemas-3.8.jar;xmlbeans-2.3.0.jar;stax-api-1.0.1.jar;dom4j-1.6.1.jar;xml-apis-1.0.b2.jar ApacheXLSXreader

echo -- Program 15.12: Add-on package demonstrations 
echo -- requires the OpenCV library
echo javac OpenCVface.java
echo java OpenCVface

echo -- Program 15.13: Loop with debug print elements
javac ForEver.java
java ForEver

echo -- Program 15.14-6: User Class definition 
javac Quadrilateral.java Rectangle.java Main.java
java Main

echo -- Program 15.17: Quadrilateral with extension 
javac Quadrilateral17.java Main17.java
java Main17

echo -- Program 15.18-9: Quadrilateral using record (need SE16)
javac Quadrilateral18.java Main19.java
java Main19

echo -- Program 15.20: AWT ClockDesign 
javac ClockDesign.java
java ClockDesign

echo -- Program 15.21: Run AWT URISC2 check
javac urisc2.java
java urisc2      

echo -- Program 15.22: Run Swing check
javac NoOpenCV.java
java NoOpenCV

echo -- Program 15.23: class asynchronous thread demo one-at-a-time
javac CountDown.java
java CountDown

echo -- Program 15.24: class asynchronous thread demo all-at-onces
javac Count2Ten.java
java Count2Ten