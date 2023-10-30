Feature: Order API Test
  Scenario: Test Order Save
    Given url 'https://reqres.in/api/users?page=2'
    When method GET
    Then status 200