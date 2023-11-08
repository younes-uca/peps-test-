Feature: common routine that does not update reference

  Background:
    * def uuid = function() { return '' + java.util.UUID.randomUUID(); }

  Scenario:
    * def uniqueId = uuid()
    * def respLength = 0
