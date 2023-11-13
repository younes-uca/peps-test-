Feature: APP Test

  Background:
    * url actuatorUri
    * header Content-Type = 'application/json'


  @CheckAppUp
  Scenario: Check DB, DiscSpace and Ping UP
    * path 'health'
    * method GET
    * status 200


  @CheckInfo
  Scenario: Check DB, DiscSpace and Ping UP
    * path 'info'
    * method GET
    * status 200
    * match response.app.name == "ORDER APP"

