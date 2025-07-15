def fact(n):
    if (n == 0):
        return 1;
    else: 
        return (n * fact(n-1));

### standard loop method
N = 5; f = 1;
for i in range(1, N + 1):
    f = f * i; # STD loop

### recursive function call method
r = fact(N); # Recursive calling function

### Compare the output results
str = "fact(%d) STD = %d   recursive = %d\n" % (N,f,r);
print(str)
