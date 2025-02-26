@Android
Feature: Verify Metro Booking Functionalities on EaseMyTrip

  Background:
    Given user opens application
    Then  verify home page is displayed

  Scenario: validate metro booking functionalities
    When user clicks on metro tab
    Then verify metro booking page is displayed
    When user selects metro location "metro.location"
    And  user selects metro line "metro.line" if applicable
    Then user provides travel details "metro.depart.from" and "metro.destination"
    And  user selects number of passengers "metro.passengers"
    Then user accepts the terms and conditions
    When user clicks proceed to pay button
    Then user provides the contact details "metro.email" and "metro.mobile"
    When user clicks on metro continue button
    Then verify payment sections page is displayed
