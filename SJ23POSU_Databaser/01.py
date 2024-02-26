from requests_html import HTML, HTMLSession
import mysql.connector
import requests
import json
import urllib3
import csv

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="password",
  database="Topswe"
)


mycursor = mydb.cursor()

def main():
    print("Start scrping")

    session = HTMLSession()
    
    csv_file = open('toplist3.csv', 'a', newline='',encoding="utf-8")   
    csv_write = csv.writer(csv_file,delimiter=';')
    csv_write.writerow(['Veckor','Placering','Title','Artis'])
        
    for v in range(1,53):
        print(v)
        response = session.get('https://sverigetopplistan.se/chart/41/?dspy=2023&dspp=' + str(v))

        response.html.render(sleep=1,keep_page=True,scrolldown=1)
        chartsList = response.html.find('ol.charts-list', first=True);
        rlists = chartsList.find('li.charts-list__item')

        
        i = 1
        for rlist in rlists:
            title = rlist.find('h2.title',first=True)
            artist = rlist.find('p.artist',first=True)
            
            csv_write.writerow([str(v),str(i),title.text,artist.text])
            print('V' + str(v) + ' -- Placering: ' + str(i) + ' -- ' + title.text + ' -- ' + artist.text )
            
            
            sql = "INSERT INTO topimport (weeks, placement, title, artist) VALUES (%s, %s, %s, %s)"
            val = ( str(v), str(i),title.text,artist.text)
            mycursor.execute(sql, val)
            
            i += 1
            mydb.commit()
            
        csv_file.close
        
        
        
        
if __name__=='__main__':
    main()