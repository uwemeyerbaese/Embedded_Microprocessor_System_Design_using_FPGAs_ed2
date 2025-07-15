fname = "d_ff.v" # file to be scanned
try:
    ### Open the file for reading ###
    file = open(fname, "r")
    for nr, line in enumerate(file):
        str = "Line %d: %s" % (nr+1, line);
        print(str, end='')
    else:
        print("Total Lines =", nr+1)
    file.close()   # Close opened file 
except IOError:
    print("Error: can\'t find file:", fname)
