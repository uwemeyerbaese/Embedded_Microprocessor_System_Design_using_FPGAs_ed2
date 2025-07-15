def swap(a,b):  # A typical ANSI C style swap
    t = a; a = b; b = t;

def swap_ok(a,b): # Python multiple return recommended
    return b, a;

def exchange(a,i,j): # Use of call by reference for arrays 
    t = a[i]; a[i] = a[j]; a[j] = t;

a, b = 10, 20;
print("Initial values:   a =", a, "b =", b)
swap(a,b)
print("After STD swap(): a =", a, "b =", b)

a, b= swap_ok(a, b)
print("Using swap_ok():  a =", a, "b =", b)

v = [10, 20, 30, 40];
print("Initial v values: ", v)
exchange(v, 0, 2)
print("After call   v  : ", v)



