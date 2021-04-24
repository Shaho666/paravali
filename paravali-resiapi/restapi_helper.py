import json
from urllib import request
 
def restapi_sender(url, params):
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko',
        'Content-Type': 'application/json'}
    req = request.Request(url=url, data=json.dumps(params).encode(encoding='utf-8'), headers=headers, method='POST')
    res = request.urlopen(req)
    ret = res.read()
    return ret.decode(encoding='utf-8')


if __name__ == '__main__':
    _params = {'id': 'id1000', 'value1': 1000}
    _url = 'http://localhost:8001/paravali/validation'
    _result = restapi_sender(_url, _params)
    print(_result)