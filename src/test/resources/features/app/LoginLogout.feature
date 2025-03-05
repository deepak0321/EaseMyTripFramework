@Android @Web
Feature: Validate Login Ang Logout Functionalities

  Background:

    Given user opens application
    Then verify home page is displayed
    When user clicks on login button and selects customer login
    Then verify a popup is displayed asking for mobile number or email for login
    When user enters a valid mobile number or email "validMobile"
    And user clicks on the continue button

  Scenario: Verify user can login with otp

    Then verify the system sends an OTP to the provided mobile number or email
    When user enters the OTP
    And clicks on login button
    Then verify user is logged in

  Scenario: Verify user can login with password

    Then verify the system ask password for logging in
    When user selects the password option and enters the "loginPassword"
    And clicks on login button
    Then verify user is logged in

  Scenario: Verify user can logout

    Then verify the system sends an OTP to the provided mobile number or email
    When user enters the OTP
    And clicks on login button
    Then verify user is logged in
    When user clicks profile tab
    And clicks on log out button
    Then verify user is logged out
