#!/bin/bash
echo Example shell script by $USER \(UID: $UID\)
echo Shell $0 is of type: $SHELL
echo Running on $HOSTNAME using OS $OSTYPE
input=${1:-10}
declare -i counter=input
case "$counter" in
1) echo 'Result(1) = 1';;
2) echo 'Result(2) = 2';;
3) echo 'Result(3) = 6';;
4) echo 'Result(4) = 24';;
5) echo 'Result(5) = 120';;
*) echo 'Input too big !';;
esac 

