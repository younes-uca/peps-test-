Feature: common routine that does not update reference

  Background:
    * def uuid = function() { return '' + java.util.UUID.randomUUID(); }
    * def DbUtils = Java.type('ma.peps.sqli.karate.util.DbUtils')

  Scenario:
    * def uniqueId = uuid()
    * def db = new DbUtils(datasource)
