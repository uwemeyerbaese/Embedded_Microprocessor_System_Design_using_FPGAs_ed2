# Scraping the CS faculty listing
import requests # Python http for humans

url = 'http://www.cs.fsu.edu/department/faculty/'
f = requests.get(url)
contents = f.text

nr=i=0
while True:
    nr += 1
    i = contents.find('<strong>', i)
    if i == -1:
        break
    # Find the 'Name' pre mark
    start = contents.find('<strong>', i) 
    # Find the 'Name' post mark
    end = contents.find('</strong>', i)
    name = contents[start+8:end]
    # Find the 'Title' pre mark
    start = contents.find('<br />', i) 
    # Find the 'Title' post mark
    end = contents.find('</td>', i)
    title = contents[start+7:end]
    title=title.replace('&amp; ','')
    # Found name + title ? => display
    if len(name)>0 and len(title)>0: 
        string = "%d) %s, %s" % (nr,name,title);
        print(string)
        print('*' * len(string))
    i += 1
