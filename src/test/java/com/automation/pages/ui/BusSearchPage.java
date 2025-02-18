package com.automation.pages.ui;

public interface BusSearchPage {
    boolean isBusSearchPageDisplayed();

    void enterBusDetails(String from, String to, String date);

    void clickOnSearchBtn();
}
