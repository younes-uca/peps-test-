Feature: MS orderBoutique

  Background:
    * url 'http://localhost:8036/api/admin/orderBoutique/'



  Scenario: POST Order Boutique and GET it by ID
    # TODO generate reference with UID
    # TODO validation for response data
    # TODO DB Clean Up before & after test
    * def postBody =
    """
{
    "reference": "order-9",
    "orderLines": [
        {
            "price": 10,
            "quantity": 2,
            "quantityReceived": 7,
            "product": {
                "id": 1
            }
        },
        {
            "price": 5,
            "quantity": 3,
            "product": {
                "id": 2
            }
        }
    ]
}
    """
    Given path 'process/save'
    And request postBody
    When method POST
    Then status 201


    * def order = response.output
    Given path 'id', order.id
    When method GET
    Then status 200



  Scenario: DELETE Order Boutique and GET all
    # TODO test case for 200, 204, 412 & all others...

    Given path 'process/delete/reference/order-5'
    When method DELETE
    * def responseCode = (response == '' ? 204 : (response.errors[0] == '' ? 200 : 412))
    And print "responseCode: " + responseCode + "|| responseStatus: " + responseStatus
    Then assert responseStatus == responseCode
    And print "responseHeaders: " + responseHeaders + " || responseCookies: " + responseCookies


    Given path ''
    When method GET
    * def responseCode = (response == '' ? 204 : 200)
    And print "responseCode: " + responseCode + "|| responseStatus: " + responseStatus
    Then assert responseStatus == responseCode
    And print "responseHeaders: " + responseHeaders + " || responseCookies: " + responseCookies
