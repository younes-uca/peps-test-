Feature: MS orderBoutique

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
    Then status 201

    * def order = response.output

    Given path 'id', order.id
    When method GET
    Then status 200


  Scenario: DELETE Order Boutique and GET all

    Given path 'process/delete/reference/order-5'
    When method DELETE
    Then status 200

    * def order = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB
