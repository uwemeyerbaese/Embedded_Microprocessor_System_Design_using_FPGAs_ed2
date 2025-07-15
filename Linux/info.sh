#---------------------------------------------
echo -- System Info compile script
echo -- Embedded uP System Design with FPGAs
echo -- Author-EMAIL: Uwe.Meyer-Baese@ieee.org
#---------------------------------------------
echo -- Run uname to get info on Kernel, node, machine and OS
uname --all

echo -- Run lsb_release to get info on distribution
lsb_release --all

echo -- Run free to get info on available and used memory
free
