@Web
Feature: Validate End To End Functionalities Of Holiday Booking

  Background:

    Given user opens application
    Then verify home page is displayed
    When user clicks on the holidays tab
    Then verify holidays page is displayed


  Scenario Outline: Verify user can book a holiday trip with flights

    When user enters "<destination>" and clicks on search button
    Then verify tour packages page is displayed
    When user clicks on from city and enters the "<fromCity>"
    And user clicks on more filters button and add a theme as "<theme>"
    And apply filters as sort to "<sortOption>" and package type as "with flights"
    Then verify list of packages are displayed
    When user selects the package
    Then verify package page is displayed and print the details
    When user customizes the hotels and rooms as "hotels.sort.order"
    Then print the price after changing the hotels and rooms
    When user clicks on enquiry button and fill the "details.first.name", "details.mobile.number" and "details.email.id"
    And clicks enquiry button
    Then verify user is on query page
    And verify query number is generated
    When user clicks on goto homepage btn
    Then verify holidays page is displayed

    Examples:
      | destination | fromCity  | theme     | sortOption  |
      | Europe      | Bangalore | Adventure | High to Low |
      | Bali        | New Delhi | Adventure | Low to High |


  Scenario Outline: Verify user can book a holiday trip without flights

    When user enters "<destination>" and clicks on search button
    Then verify tour packages page is displayed
    And user clicks on more filters button and add a theme as "<theme>"
    And apply filters as sort to "<sortOption>" and package type as "without flights"
    Then verify list of packages are displayed
    When user select the package with recommended tag
    Then verify package page is displayed and print the details
    When user clicks on enquiry button and fill the "details.first.name", "details.mobile.number" and "details.email.id"
    And clicks enquiry button
    Then verify query number is generated
    When user clicks on goto homepage btn
    Then verify holidays page is displayed

    Examples:
      | destination | theme      | sortOption  |
      | Kerala      | Group Tour | Low to High |
      | Kashmir     | Winter     | High to Low |