#!/bin/bash
sed 10,12d $1 > t1
sed 5,7d t1 > t2
sed 's/20/Good Bye/g' t2 > $1
