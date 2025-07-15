#!/bin/bash
#---------------------------------------------
echo -- System Info compile script
echo -- Embedded uP System Design with FPGAs
echo -- Author-EMAIL: Uwe.Meyer-Baese@ieee.org
#---------------------------------------------
echo -- Run uname to get info on Kernel, node, machine, and OS
uname --all

echo -- Run lsb_release to get info on distribution
lsb_release --all

echo -- Run free to get info on available and used RAM memory
free --human

echo -- Run df [human readable] for free DISK space
df --human

echo -- Run du [human readable; one level display] for DISK usage
#du  --human --max-depth=1

echo -- Run get info on network interfaces
ifconfig

echo -- Run get info on wireless adapters
iwconfig 

echo -- Run get info on mounted devices
lsblk

echo -- Run get info on USB devices
lsusb

echo -- Run get info on loaded kernel modules
lsmod


