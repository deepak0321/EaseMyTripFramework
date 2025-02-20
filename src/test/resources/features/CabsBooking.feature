Feature: Validate Cabs Booking Feature on EaseMyTrip

  Background:
    Given user opens application
    Then  verify home page is displayed


  Scenario Outline: Booking a cab with different options
    When user clicks on cabs tab
    Then verify user is on the cab booking page
    When user selects booking type "<Booking Type>"
    And  user enters pick-up location as "<From City>"
    And  user enters drop location as "<To City>"
    And  user selects pick-up date "<Pick-up Date>" and time "<Pick-up time>"
    And  user selects return date "<Return Date>" and time "<Return Time>" if applicable
    And  user enters rental duration "<Rent Duration>" if applicable
    And  user enters age "<Age>" if applicable
    And  user enters country "<Country>" if applicable
    And  user clicks on cab search button
    Then verify user is on cab listing page

    Examples:
      | Booking Type   | From City     | To City            | Pick-up Date     | Pick-up time | Return Date   | Return Time | Rent Duration | Age | Country |
      | Airport Pickup | Delhi Airport | Greater Kailash II | 25 February 2025 | 11:35 AM     | -             | -           | -             | -   | -       |
      | Airport drop   | Delhi Airport | Greater Kailash II | 26 April 2025    | 08:35 AM     | -             | -           | -             | -   | -       |
      | Outstation     | Delhi         | Agra               | 27 May 2025      | 10:35 AM     | 29 May 2025   | 10:35 AM    | -             | -   | -       |
      | Hourly         | Delhi         | Delhi              | 28 June 2025     | 12:35 PM     | -             | -           | 6 Hr          | -   | -       |
      | Self-Drive     | Delhi         | Delhi              | 21 March 2025    | 03:35 PM     | 28 March 2025 | 03:35 PM    | 12 Hr         | 22  | India   |
