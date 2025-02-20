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
      | Booking Type   | From City                                 | To City                                   | Pick-up Date     | Pick-up time | Return Date      | Return Time | Rent Duration | Age      | Country   |
      | Airport Pickup | Chennai International Airport, Terminal 1 | chennai central station                   | 25 February 2025 | 11:35 am     | -                | -           | -             | -        | -         |
      | Airport Drop   | chennai central station                   | Chennai International Airport, Terminal 1 | 5 March 2025     | 08:35 pm     | -                | -           | -             | -        | -         |
      | Outstation     | delhi                                     | agra                                      | 22 February 2025 | 10:00 am     | 25 March 2025    | 10:35 pm    | -             | -        | -         |
      | Hourly         | delhi                                     | -                                         | 28 May 2030      | 12:35 pm     | -                | -           | 6 Hr          | -        | -         |
      | Self Drive     | Paris Roissy CDG-SD              | Paris Roissy CDG-SD              | 21 March 2025-SD | 03:35 pm-SD  | 28 March 2025-SD | 11:35 pm-SD | -             | 25 Years | MAURITIUS |
