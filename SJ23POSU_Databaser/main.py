from requests_html import HTML, HTMLSession
import requests
import json
import urllib3

def main():
    print("Start scrping")

    session = HTMLSession()
    response = session.get('https://sverigetopplistan.se/chart/41/?dspy=2023&dspp=1')
    
    
    response.html.render(sleep=1,keep_page=True,scrolldown=1)
    # numList = response.html.find('div.uk-width-1-1')
    
    
    # chartsList = numList[1].find('ol.charts-list', first=True);
    chartsList = response.html.find('ol.charts-list', first=True);
    rlists = chartsList.find('li.charts-list__item')

    i = 1
    for rlist in rlists:
        title = rlist.find('h2.title',first=True)
        artist = rlist.find('p.artist',first=True)
        
        print('Placering: ' + str(i) + ' -- ' + title.text + ' -- ' + artist.text )
        i += 1

    #print(type(numList))
    
if __name__=='__main__':
    main()