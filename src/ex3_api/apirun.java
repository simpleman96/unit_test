package ex3_api;

public class apirun {
/*
1. API Login
url api: https://afe9033d4a27.ngrok.io/api/loginUser
json format input: 
{"email":"m@2", "password" : "2"}
json format output:
{
    "rep": {
        "result": "0",
        "message": {
            "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6Ik...",
            "rule": 0,
            "id": "m@2",
            "card": [
                {
                    "type": "1",
                    "lic": "a",
                    "exp": "2020-07-29"
                },
            ...
            ],
            "cardset": "a#b#c#e#",
            "scanner": ""
        }
    }
}

2. API Update Card
url api: https://afe9033d4a27.ngrok.io/api/setcard
json format input: 
{
    "token":"eyJhbGciOiJIUzI1N...", 
    "email":"m@2",
    "key":"a#c#e#"
}
json format output:
{
  "rep": {
    "result": "0",
    "message": {
      "trans": "txtid: 0dd4eaff501e...",
      "msg": "Transaction..."
    }
  }
}
 */

}
