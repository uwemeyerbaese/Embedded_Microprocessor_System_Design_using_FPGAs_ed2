### Reading traffic image, store, and display
import urllib.request ## URL request and retrieve
import matplotlib.pyplot as plt ## display images
import time ## local time stamp

### Download traffic image and store to file
server = 'https://talgovsvcp.talgov.net/'
src = server + 'TallahasseeAtmsWeb/cctvimages/video059.jpg'
dst = './video059.jpg'
ret = urllib.request.urlretrieve(src, dst)

now = time.strftime("%b %d,  %r")
### read the image and display 
img = plt.imread(dst)
plt.imshow(img); 
plt.title("Original:\n" + now); 
plt.axis('off')
plt.show()
print('Done with Download ... Bye Bye')
