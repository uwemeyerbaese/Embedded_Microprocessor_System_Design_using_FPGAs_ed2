#!/bin/bash
echo === get the current lib info and dev tools
apt-get update
apt-get install -y python3.5-dev
echo === if tkinter is missing:
apt-get install -y tk

echo === get some popular embedded system libs
apt-get install -y python3-numpy
apt-get install -y python3-matplotlib
apt-get install -y python3-scipy
apt-get install -y python3-sklearn
apt-get install -y python3-pandas
apt-get install -y python3-pil

#apt-get install python3-opencv
#pip3 install opencv-python

