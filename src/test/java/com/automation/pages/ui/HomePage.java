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

    void clickOnActivitiesTab();

    void clickOnLoginBtn();

    boolean isPopupDisplayed();

    void enterMobile(String mobileNumber);

    void clickOnContinueBtn();

    boolean isOtpGenerated();

    void enterOtp();

    void clickOnOtpOrPasswordLoginBtn();

    boolean isUserLoggedIn();

    void clickOnProfileTab();

    void clickOnLogoutBtn();

    boolean isUserLoggedOut();

    boolean isPasswordOptionDisplayed();

    void enterPassword(String password);

    void clickOnExploreBharatTab();
}
