#!/bin/bash
echo Example shell script by $USER \(UID: $UID\)
echo Shell $0 is of type: $SHELL

echo "Determine Files with extension *.ko"
cd /
find . -name "*.ko" > temp.txt
echo -n "I) Files with extension *.ko: "
wc -l < temp.txt 

echo "Determine Files larger in size than 10K Bytes"
cd /
find . -type f -size 10000c 2>/dev/null> temp.txt
echo -n "II) Files larger in size than 10,000 Bytes: "
wc -l < temp.txt 

echo "Determine Files edited in the last 3 days"
for ((k=3; k>0; k--))
do
  declare -i kk=1
  kk=$k+$kk
  declare date1=$(date +%F)
  declare date2=$(date -d "$date1 - $kk days" +%F)
  declare date3=$(date -d "$date1 - $k days" +%F)
  find . -type d -newermt $date3 ! -newermt $date2 > temp.txt
  #echo Number of directories last modified in $k: $count
  echo -n "III) #Files edited $date2...$date3: "
  wc -l < temp.txt 
done

echo Determine the number of directories modified per year
declare -i count
cd ~
for ((k=2024; k>2021; k--))
do
  find . -type d -newermt $k-01-01 ! -newermt $k-12-31 > temp.txt
  #echo Number of directories last modified in $k: $count
  echo -n "IV) Number of directories last modified in $k: "
  wc -l < temp.txt 
done

