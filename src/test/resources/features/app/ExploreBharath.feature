@Android @Web

Feature: Validate Explore Bharat functionalities

  Scenario: Verify user can book an activity from explore bharat

    Given user opens application
    Then verify home page is displayed
    When user clicks on the Explore Bharat tab
    Then verify user is on the explore Bharat page
    When user select "activity.input" activity from the india unveiled
    Then verify user is on the activity detail page
    And print the details of the activity
