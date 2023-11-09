Feature: MS orderBoutique Tests

  Background:
    * url baseUrl
    * header Content-Type = 'application/json'

    * def postBody = read('../data/Save.json')
    * def uuid = function() { return '' + java.util.UUID.randomUUID(); }
    * postBody.reference = uuid()



  @duplicate
  Scenario Outline: POST Order Boutique Twice with same reference
    * postBody.reference = uniqueId
    * def payload = ("<method>" == "POST") ? postBody : {}
    * def res = { pass: true, message: null }
    * def order_boutique_count = db.readValue('select count(*) FROM `peps-order`.order_boutique')
    * def order_line_count = db.readValue('select count(*) FROM `peps-order`.order_line')

    * path <paths>
    * request payload
    * method <method>
    * status <responseCode>
    * eval if(<index>==2 && order_boutique_count != db.readValue('select count(*) FROM `peps-order`.order_boutique')) karate.fail("order_boutique count values are different")
    * eval if(<index>==2 && order_line_count != db.readValue('select count(*) FROM `peps-order`.order_line')) karate.fail("order_line count values are different")

    Examples:
      | index | responseCode | paths          | method |
      | 1     | 201          | 'process/save' | POST   |
      | 2     | 412          | 'process/save' | POST   |


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
