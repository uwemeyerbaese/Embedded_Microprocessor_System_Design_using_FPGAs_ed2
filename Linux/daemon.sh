#!/bin/bash

echo Example $0 script by $USER \(UID: $UID\)
echo Determine the number of \(non-\)daemon processes
ps -eo tty,pid,ppid,comm > procs.txt
echo -n "The total number of processes are: "
wc -l <procs.txt
echo -n "The number of daemon processes are: "
grep ^? procs.txt | wc -l 
echo -n "The number of non-daemon processes are: "
grep ^[^?] procs.txt | wc -l 
echo Done with process calculations
