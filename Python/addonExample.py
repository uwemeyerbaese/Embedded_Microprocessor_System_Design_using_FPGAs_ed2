### Plot the numpy arrays using matplotlib
import numpy as np
import matplotlib.pyplot as plt 

# get 10K uniform distributed values in range 0...1
u = np.random.uniform(0, 1, 10000)
x = np.arange(200); yu = u[0:200]

# get 10K Gaussian distributed random values
n = np.random.randn(10000)
x = np.arange(200); yn = n[0:200]

# the series of the data 
plt.subplot(2,2,1); plt.plot(x, yu, 'b-');
plt.title('Uniform'); plt.axis([0, 200, 0, 1]);

# the histogram of the uniform data 
plt.subplot(2,2,2);
t, bins, patches = plt.hist(u, 20, facecolor='cyan') 
plt.title('Uniform Histogram');

# the series of the data 
plt.subplot(2,2,3); plt.plot(x, yn, 'b-')
plt.title('Normal'); plt.axis([0, 200, -2, 2]);

# the histogram of the Gaussian data 
plt.subplot(2,2,4)
t, bins, patches = plt.hist(n, 20, facecolor='magenta') 
plt.title('Normal Histogram');

plt.show()

