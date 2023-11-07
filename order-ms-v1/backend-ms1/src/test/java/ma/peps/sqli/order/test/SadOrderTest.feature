Feature: MS orderBoutique Tests

  Background:
    * url 'http://localhost:8036/api/admin/orderBoutique/'
    * header Content-Type = 'application/json'



  Scenario: POST Order Boutique Twice with same reference
    # * def uniqueRef = Java.type('Helper.utilities').generateUniqueId()

    * def postBody = read('../data/Save.json')
    * path 'process/save'
    * request postBody
    * method POST
    # * print "reference: " + uniqueRef
    * status 201



    # Find All orders * store length
    * def order = response.output
    * path ''
    * method GET
    * status 200
    * def respLength = response.length


    # Try to save same order -> 412 Precondition Failed
    * path 'process/save'
    * request postBody
    * method POST
    * status 412


    # Find All orders, length should stay same
    * def order = response.output
    * path ''
    * method GET
    * status 200
    * match respLength == response.length
