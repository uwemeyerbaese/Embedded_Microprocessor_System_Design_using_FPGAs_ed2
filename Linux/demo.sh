#!/bin/bash
echo Example shell script by $USER \(UID: $UID\)
echo Shell $0 is of type: $SHELL
echo Running on $HOSTNAME using OS $OSTYPE
input=${1:-10}
declare -i counter=input
declare -i result=1
#result=1
while [ $counter -gt 1 ]; do
  result=$result*$counter
  counter=$counter-1
done
echo Result\($input\) =  $result

