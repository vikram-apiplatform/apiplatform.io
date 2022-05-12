import requests


def business_logic_api():

  API_getbooks_v1 = requests.get(url = 'https://dev-vikram.gateway.apiplatform.io/v1/books',
    headers = {'pkey' : '3fbbb8bc5a969f503fdb66e7d90509d6', 'apikey' : '7xR2sYhqRAdfhhyu6jMo9E9hi4fRazuw'},
    params = {'query' : ''})
