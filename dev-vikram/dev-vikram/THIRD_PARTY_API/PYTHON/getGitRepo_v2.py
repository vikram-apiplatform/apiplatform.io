import http.client
import mimetypes
conn = http.client.HTTPSConnection("")
payload = ''
headers = {}
conn.request("GET", "https://api.github.com/user/repos", payload, headers)
res = conn.getresponse()
data = res.read()
print(data.decode("utf-8"))
