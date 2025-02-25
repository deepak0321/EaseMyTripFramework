@Android @Web
Feature: Verify Gift Card Functionality on EaseMyTrip

  Background:
    Given user opens application
    Then verify home page is displayed


  Scenario: Validate Gift Card Options on EaseMyTrip
    When user clicks on gift card
    Then verify gift card page is displayed
    When user selects gift card category "gift.card.category"
    Then user clicks on gift card type "gift.card.type"
    And user enters gift card details "gift.card.denomination", "gift.card.quantity", "gift.card.delivery.date"
    Then user enters delivery date details "delivery.date" ,"delivery.month","delivery.year" if applicable
    Then user enters sender's details "sender.name", "sender.email", "sender.mobile.number"
    And  user selects either sender and receiver details are same checkbox "sender.receiver.details.same"
    Then if not, user enters receiver's details "receiver.name", "receiver.email", "receiver.mobile.number"
    Then user clicks accept terms and conditions
    When user clicks on pay now button
    Then user enters otp
    When user clicks on verify now button
    Then verify payment options page is displayed



