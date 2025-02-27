package com.automation.pages.ui;

public interface HomePage {

    default void clickOnMetroTab(){}

    void openApplication();

    boolean isHomePageDisplayed();

    void ClickOnTrainsTab();

    void clickOnBusTab();

    void clickOnCabsTab();

    void clickOnFlightTab();

    void clickOnGiftCardTab();

    void clickOnHolidaysTab();
}
