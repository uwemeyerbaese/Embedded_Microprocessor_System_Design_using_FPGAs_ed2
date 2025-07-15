import timeit
starttime = timeit.default_timer()
L = [n ** 2 for n in range (1000000)]
stoptime = timeit.default_timer() 
print("The start time was :",starttime)
print("The  stop time was :",stoptime)
str = "{:.3f}".format(stoptime - starttime)
print("Total run time was :", str, 'seconds')

