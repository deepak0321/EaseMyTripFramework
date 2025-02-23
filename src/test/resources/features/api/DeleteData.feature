@api
Feature: Testing Delete method to delete created data

  Scenario: Create a resource data and delete the data and verify it

    Given user calls the endpoint "/api/capstone"
    When  user sets header "Content-Type" to "application/json"
    And   set request body from file "createData.json"
    Then  user performs post method
    Then  verify status code is 201
    Then  store the id "id" in variable "createdID"

    Given user calls the endpoint "/api/capstone/"
    And   retrieve the created data with id "createdID"
    When  user sets header "Content-Type" to "application/json"
    Then  user performs delete method
    Then  verify status code is 200