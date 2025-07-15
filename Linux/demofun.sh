#!/bin/bash
func() {
declare -i counter="$1"
while [ $counter -gt 1 ]; do
  result=$result*$counter
  counter=$counter-1
done
}

echo Example shell script by $USER \(UID: $UID\)
echo Shell $0 is of type: $SHELL
echo Running on $HOSTNAME using OS $OSTYPE
echo This version uses a function call
input=${1:-10}
declare -i result=1
func $input     
echo Result\($input\) =  $result

