Feature: APP Test

  Background:
    * url 'http://localhost:8036/actuator/health'
    * header Content-Type = 'application/json'


  @CheckAppUp
  Scenario: Check DB, DiscSpace and Ping UP
    * path ''
    * method GET
    * status 200
    * print "response :: db =" + response.components.db.status + ", :: diskSpace =" +response.components.diskSpace.status + ", :: ping =" +response.components.ping.status
    * match response.status == "UP"
    * match response.components.db.status == "UP"
    * match response.components.diskSpace.status == "UP"
    * match response.components.ping.status == "UP"

