import http.client
import mimetypes
conn = http.client.HTTPSConnection("")
payload = ''
headers = {'pkey' : '3fbbb8bc5a969f503fdb66e7d90509d6'
'apikey' : '7xR2sYhqRAdfhhyu6jMo9E9hi4fRazuw'
}
conn.request("GET", "https://dev-vikram.gateway.apiplatform.io/v1/shop", payload, headers)
res = conn.getresponse()
data = res.read()
print(data.decode("utf-8"))
