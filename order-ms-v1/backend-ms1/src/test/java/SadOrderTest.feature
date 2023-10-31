Feature: MS orderBoutique Tests

  Background:
    * url 'http://localhost:8036/api/admin/orderBoutique/'



  Scenario: POST Order Boutique and GET it by ID
    # TODO generate reference with UID
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


    # Try to save same order -> 412 Precondition Failed
    Given path 'process/save'
    And request postBody
    When method POST
    Then status 412
