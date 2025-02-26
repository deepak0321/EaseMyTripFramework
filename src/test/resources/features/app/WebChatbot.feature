@Web
Feature: Validate chatbot functionalities

  Scenario: Verify chatbot with book holiday function

    Given user opens application
    Then verify home page is displayed
    When user clicks on the chatbot icon
    Then verify chatbot pop-up is displayed
    When user selects "Book Holiday" from the available options
    And  selects "No" for query number available option
    Then verify the chatbot asks for the details to book a holiday plan
    When the user provides the details needed for booking a holiday plan
      | Detail         | Value                   |
      | Holiday type   | International Holiday   |
      | Destination    | Europe                  |
      | Travel time    | Next Month              |
      | Staying Period | 5 to 8 nights           |
      | Traveling with | Friends                 |
      | No of rooms    | Two Rooms               |
      | Budget         | Rs 1,00,000 to 2,50,000 |
      | Mobile         | 6382190286              |

    Then verify chatbot displays a confirmation message


