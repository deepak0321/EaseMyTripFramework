package com.automation.pages.ui;

public interface BusTravellersDetailsPage {
    void selectTripInsurance(String value);

    void enterEmail(String email);

    void clickOnContinue();

    boolean isPaymentOptionsDisplayed();

    void enterUserDetails(String title, String firstName, String lastName, String age, String mobileNumber);

    void clickOnContinueBooking();

    boolean isBusTravellersDetailsPageDisplayed();
}


