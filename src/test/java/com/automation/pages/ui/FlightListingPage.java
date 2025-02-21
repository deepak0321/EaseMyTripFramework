package com.automation.pages.ui;

public interface FlightListingPage {
    boolean isFlightListingPageDisplayed();

    void selectFilterOption(String filterOption);

    boolean isFlightListingDisplayedWithFilter(String filterOption);
}
