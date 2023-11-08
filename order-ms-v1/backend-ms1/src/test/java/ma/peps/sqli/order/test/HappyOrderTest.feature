Feature: MS orderBoutique

  Background:
    * url 'http://localhost:8036/api/admin/orderBoutique/'
    * header Content-Type = 'application/json'
    * def FindAllSchema = read('../schema/FindAll.json')

    * def postBody = read('../data/Save.json')
    * def uuid = function() { return '' + java.util.UUID.randomUUID(); }
    * postBody.reference = uuid()



  @FindAll
  Scenario Outline: Find All - in case DB is empty (204) * in case DB filled (200)

    * def payload = ("<method>" == "POST") ? postBody : {}
    # * def res = { pass: true, message: null }

    * path <paths>
    * request payload
    * method <method>
    * status <responseCode>
    * def res = karate.match(<match>[0])
    * match res == { pass: true, message: null }
    * def res = karate.match(<match>[1])
    * match res == { pass: true, message: null }


    Examples:
      | responseCode | paths         | method | match                                                                                    |
      | 204          | ''            | GET    | ["response.length == 0", "payload != ''"]                                                |
      | 201          | 'process/save'| POST   | ["payload != ''", "payload != ''"]                                                       |
      | 200          | ''            | GET    | ["each response contains FindAllSchema "," response[0].reference == postBody.reference"] |



  @Save
  Scenario: POST Order Boutique * GET it by ID
    # TODO DB Clean Up before & after test
    * path 'process/save'
    * request postBody
    * method POST
    * status 201
    * print "ERROR: " + response.errors.length
    * match response.errors == '#[]'
    * match response.status == "CREATED"
    * match response.output.reference == postBody.reference
    * match response.output.orderLines[0] contains postBody.orderLines[0]
    * match response.output.orderLines[1] contains postBody.orderLines[1]



    * def order = response.output
    * def orderLines = response.output.orderLines
    * path 'id', order.id
    * method GET
    * status 200
    * match orderLines == response.orderLines


  @Delete
  Scenario: DELETE Order Boutique * GET all

    * path 'process/delete/reference', postBody.reference
    * method DELETE
    * def responseCode = (response.errors == '' ? 200 : 412)
    * print "responseCode: " + responseCode + " || responseStatus: " + responseStatus
    * assert responseStatus == responseCode
    * def respValidation = (responseCode == 200 ? ( response.errors == '' && response.status == "OK" && response.output.reference == postBody.reference) : false)
    * assert respValidation == true


    * path ''
    * method GET
    * def responseCode = (response == '' ? 204 : 200)
    * print "responseCode: " + responseCode + "|| responseStatus: " + responseStatus
    * assert responseStatus == responseCode
    * print "responseHeaders: " + responseHeaders + " || responseCookies: " + responseCookies
