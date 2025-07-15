#!/bin/bash
cd /
du --max-depth=1 2>/dev/null | sort -rn | head -n 6 > ~/t1 
sed 1d  ~/t1 >  ~/top5.txt 
more ~/top5.txt
