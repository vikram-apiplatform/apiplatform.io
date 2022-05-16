import requests


def business_logic_api():

  THIRDPARTY_getRepo_v1 = requests.get(url = 'https://api.github.com/user/repos',
    headers = {},
    params = {})
