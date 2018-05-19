## Simple implementation of RESTful API for transfers between accounts

### Uses
* java 8
* maven
* jersey
* embedded jetty
* junit


### To build
`mvn clean install`

### To run
`java -jar .\target\rest-test-1.0-SNAPSHOT.jar`

### To test
Service is starting on port 8080.\
For test REST services you could use:\
* curl (https://curl.haxx.se/),
* Postman (https://www.getpostman.com/),
* SoapUI (https://www.soapui.org/downloads/soapui.html)
* or any other REST tools

#### Available operations
##### Accounts
* `GET http://localhost:8080/accounts/` to get list of accounts
* `GET http://localhost:8080/accounts/{id}` to get account by {id}
* `POST http://localhost:8080/accounts/` to create account with body for example:
    ```json
    {
      "client": "Test",
      "balance": "10000",
      "currency": "RUR"
    }
    ```
* `PUT http://localhost:8080/accounts/{id}` to update account by {id} with body for example:
    ```json
    { "id": "{id}",
      "client": "Test2",
      "balance": "100",
      "currency": "USD"
    }
    ```
* `DELETE http://localhost:8080/accounts/{id}` to delete account by {id}

##### Transfers
* `GET http://localhost:8080/transfers/` to get list of transfers
* `GET http://localhost:8080/transfers/{id}` to get transfer by {id}
* `POST http://localhost:8080/transfers/` to create transfer between accounts with body for example:
```json
{
  "srcAccountId": "0",
  "destAccountId": "1",
  "amount": "1000",
  "currency": "RUR"
}
```
* `PUT http://localhost:8080/transfers/{id}` to update transfer by {id} with body for example:
```json
{
  "id": "{id}",
  "srcAccountId": "0",
  "destAccountId": "1",
  "amount": "10",
  "currency": "EUR"
}
```
* `DELETE http://localhost:8080/transfers/{id}` to delete transfer by {id}


