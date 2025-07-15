''' Program Name: netCheck.py
Author: Dr. Uwe Meyer-Baese
Tool: Python 3.5.0
Description: This program collect ping statistics for a 
domain then computes mean and medium delay and
plots the results in a bar graph
Usage: python netCheck.py DOMAIN_NAME'''
import sys ## Used to read command line parameters
import socket ## Domain names and IP address
import platform ## Check for Linux or Windows system
import os ## run the ping OS command
import statistics ## compute mean and medium
import matplotlib.pyplot as plt ## pie, bar, and line plots

### Get an IP address
name=sys.argv[1];
ipDomainName = "WWW." + name +".DE"
ipAddress = socket.gethostbyname(ipDomainName )
print(ipDomainName, "has IP address:", ipAddress)

### Check for Linux/Window system
if platform.system()=='Windows':
    command = "ping -n 5 "
    expected = "Received = 5"
else:
    command = "ping -c 5 "
    expected = "5 received"
command += ipAddress
response = os.popen(command).read()
# print(response) # Used for debug printing
if expected in response:
    print(ipDomainName, "is UP")
else:
    print(ipDomainName, "is DOWN")
    sys.exit() 

### Collect the timing data
spt=response.split(' '); i=0; y=[]; x=[];
for k in range(len(spt)):
    if spt[k].find('time=') >= 0:
        print(spt[k])  # Used for debug printing
        s=spt[k]
        s=s.replace('ms','')
        s=s.split('=')
        y.append(float(s[1]))
        x.append(i)
        i += 1
print(y)  # Used for debug printing
str = "Ping Time Delay mean = {:.2f}ms; median= {:.2f}ms" \
.format(statistics.mean(y),statistics.median(y));
print(str)

### plot the bar graph 
plt.bar(x, y, 1)
str="Ping Time Delay for %s" % (ipDomainName);
plt.title(str) 
plt.xlabel('Measurement')
plt.ylabel('Time in ms')
plt.savefig('netCheck.png')
