Feature: MS orderBoutique Tests

  Background:
    * url 'http://localhost:8036/api/admin/orderBoutique/'


  Scenario: POST Order Boutique and GET it by ID
    * def postBody =
    """
{
    "reference": "order-5",
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
    Then status 200

    * def order = response.output
    * def ref = response.reference

    Given path 'order', order.id
    When method GET
    Then status 200


  Scenario: DELETE Order Boutique and GET all
    * def postBody =
    """
{
    "reference": "order-5",
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

    Given path 'process/delete'
    And request postBody
    When method POST
    Then status 200

    * def order = response.output
    * def ref = response.reference

    Given path 'order', order.id
    When method GET
    Then status 200
