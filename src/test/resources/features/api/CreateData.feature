@api
Feature: Testing POST method to verify data creation

  Scenario: Create a resource and verify it by validating the data field
    Given user calls the endpoint "/api/capstone"
    When  user sets header "Content-Type" to "application/json"
    And   set request body from file "createData.json"
    Then  user performs post method
    Then  verify status code is 201
    Then  verify response body has a field "id"

