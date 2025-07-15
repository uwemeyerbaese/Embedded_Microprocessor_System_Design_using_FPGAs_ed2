#!/bin/bash
#---------------------------------------------
echo -- Ch. 13 Python 3 compile all script
echo -- Embedded uP System Design with FPGAs
echo -- Author-EMAIL: Uwe.Meyer-Baese@ieee.org
#---------------------------------------------
echo -- Script 13.1: install libraries
echo -- Run libpy.sh
echo -- Run pip3 install opencv-python

echo -- Program 13.2: Domain server demo
python3 netCheck.py SPRINGER

echo -- Program 13.3: File I/O
python3 ioExample.py

echo -- Program 13.4: swapExample
python3 swapExample.py

echo -- Program 13.5: 
python3 factExample.py

echo -- Program 13.6: 
python3 my_module.py
python3 my_module_tb.py

echo -- Program 13.7: TimeIt
python3 timeItExample.py

echo -- Program 13.8: add-on Library
python3 addonExample.py

echo -- Program 13.9: class definition
python3 geometry.py

echo -- Program 13.10: class instantiation
python3 xgeometry.py

echo -- Program 13.11: Tkinter clock
python3 clock24.py

echo -- Program 13.12: Tkinter ISS
python3 URISC2.py

echo -- Program 13.13: Traffic camera data retrieval
python3 clock24.py

echo -- Program 13.14: Net scraping
python3 cs_scraping.py

