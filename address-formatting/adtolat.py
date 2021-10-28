from dotenv import load_dotenv
from opencage.geocoder import OpenCageGeocode
import os


load_dotenv()
API_KEY=os.getenv("API_KEY")


geocoder = OpenCageGeocode(API_KEY)

query = u'1A2B Minto Road, Allahabad'
results = geocoder.geocode(query)

print(u'%f;%f;%s;%s' % (results[0]['geometry']['lat'], 
                        results[0]['geometry']['lng'],
                        results[0]['components']['country_code'],
                        results[0]['annotations']['timezone']['name']))

results2 = geocoder.reverse_geocode(25.448940,81.833290)
print(results2)



