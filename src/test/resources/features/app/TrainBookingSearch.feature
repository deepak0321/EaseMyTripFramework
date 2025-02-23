@Android @Web
Feature: verify train booking search functionalities on EaseMyTrip

  Background:
    Given user opens application
    Then  verify home page is displayed

  Scenario: validate train booking search functionalities
    When user clicks on trains tab
    Then verify the user is on the train search page
    When the user enters the departure city as "train.departure.city"
    Then the user selects the departure station "train.departure.station"
    And  the user enters the arrival city as "train.arrival.city"
    Then the user selects the arrival station "train.arrival.station"
    Then the user selects the departure date as "train.departure.date"
    When the user clicks on the show trains button
    Then verify the train listing page is displayed

