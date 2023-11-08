Feature: MS orderBoutique Tests

  Background:
    * url 'http://localhost:8036/api/admin/orderBoutique/'
    * header Content-Type = 'application/json'

    * def postBody = read('../data/Save.json')
    * def uuid = function() { return '' + java.util.UUID.randomUUID(); }
    * postBody.reference = uuid()



  @duplicate
  Scenario Outline: POST Order Boutique Twice with same reference
    * postBody.reference = uniqueId
    * def payload = ("<method>" == "POST") ? postBody : {}
    * def res = { pass: true, message: null }

    * path <paths>
    * request payload
    * method <method>
    * status <responseCode>
    * eval if("<method>" == "GET" && <match> == "set") respLength = response.length
    * eval if("<method>" == "GET" && <match> != "set") responseLength = respLength
    * eval if("<method>" == "GET" && <match> != "set") karate.log(responseLength)
    * eval if("<method>" == "GET" && <match> != "set") res = karate.match(<match>)
    * match res == { pass: true, message: null }

    Examples:
      | responseCode | paths          | method | ref    | match                           |
      | 201          | 'process/save' | POST   | uuid   | ""                              |
      | 200          | ''             | GET    | uuid   | "set"                           |
      | 412          | 'process/save' | POST   | uuid   | ""                              |
      | 200          | ''             | GET    | uuid   | "responseLength == response.length" |



  Scenario: Fail - GetByID Not Found

    * path 'id', 99999999
    * method GET
    * status 404
    * match response.length == 0



  Scenario: Fail - POST Order Boutique without Body

    * path 'process/save'
    * method POST
    * status 400
    * match response.error == "Bad Request"



  Scenario Outline: Fail - Save Order with method <method>

    * path 'process/save'
    * method <method>
    * status 405
    * match response.error == "Method Not Allowed"

    Examples:
    | method |
    | GET    |
    | DELETE |
    | PUT    |
    | PATCH  |
