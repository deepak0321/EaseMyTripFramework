package com.automation.pages.ui;

public interface CabSearchPage {

    boolean isCabSearchPageDisplayed();

    void clickOnSearchBtn();

    void selectCabBookingType(String cabBookingType);

    void enterPickupLocation(String pickUpLocation);

    void enterDropLocation(String dropLocation);

    void selectPickupDateAndTime(String date,String time);

    void selectReturnDateAndTime(String date,String time);

    void selectRentalHours(String hours);

    void selectCountry(String country);

    void selectAge(String age);
}
