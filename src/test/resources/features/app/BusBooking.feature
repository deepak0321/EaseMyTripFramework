@Android @Web
Feature: verify bus booking functionalities on EaseMyTrip

  Background:
    Given user opens application
    Then  verify home page is displayed

  Scenario: validate bus booking functionalities
    When user clicks on bus tab
    Then verify bus search page is displayed
    When user enters bus details "bus.from.city" and "bus.to.city" and "bus.departure.date"
    And  user clicks on search button
    Then verify bus listing page is displayed
    When the user clicks the Select Seats button for the first bus
    Then the first available seat should be selected
    And  user selects boarding point "bus.boarding.point"
    Then user selects dropping point "bus.dropping.point"
    When user clicks on continue button
    And  verify bus review and traveller details page is displayed
    Then the user selects trip insurance option as "insurance.option"
    And  user enters email id "email.id"
    Then user clicks on review continue button
    And  the user enters their personal details "traveller.title" , "traveller.first.name","traveller.last.name","traveller.age","traveller.mobile.number"
    Then user clicks on continue booking button
    And  verify that the payment options are displayed


