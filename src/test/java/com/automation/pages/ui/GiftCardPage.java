package com.automation.pages.ui;

public interface GiftCardPage {

    void selectGiftCardCategory(String category);

    boolean isGiftCardPageDisplayed ();

    void selectGiftCardType(String type);

    void enterGiftCardDetails(String denomination, String quantity, String deliveryDate);

    void enterSenderDetails(String name, String email, String mobileNumber);

    void selectIfSenderAndReceiverDetailsAreSame(String isSame);

    void enterReceiverDetails(String name, String email, String mobileNumber);

    void acceptTC();

    void clickOnPayNow();

    void enterDeliveryDateDetails(String date, String month, String year);

    void enterOTP();

    void clickOnVerifyNow();

    boolean isPaymentModesDisplayed();
}
