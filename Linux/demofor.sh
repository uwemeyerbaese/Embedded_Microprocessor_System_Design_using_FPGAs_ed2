#!/bin/bash
echo Example shell script by $USER \(UID: $UID\)
echo Shell $0 is of type: $SHELL
echo Running on $HOSTNAME using OS $OSTYPE
input=${1:-10}
declare -i counter=input
declare -i result=1
for ((k=1; k<=$counter; k++))
do
# echo k=$k   counter=$counter
  result=$result*$k
done
echo Result\($input\) =  $result

