package com.automation.pages.android;

import com.automation.pages.ui.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePage extends AndroidBasePage implements HomePage {

    @FindBy(id = "com.google.android.gms:id/cancel")
    WebElement googlePopupCloseBtn;

    @FindBy(id = "com.easemytrip.android:id/iv_close")
    WebElement loginPopupClosBtn;

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    WebElement dontAllowBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Metro']")
    WebElement metroTab;

    @FindBy(xpath = "//android.widget.TextView[@text='Trains']")
    WebElement trainsTab;

    @FindBy(xpath = "//android.widget.TextView[@text='Gift Card']")
    WebElement giftCardsTab;

    @FindBy(xpath = "//android.widget.TextView[@text='Bus']")
    WebElement busTab;

    @FindBy(xpath = "//android.widget.TextView[@text='Cabs']")
    WebElement cabsTab;

    @FindBy(xpath = "//android.widget.TextView[@text='Flights']")
    WebElement flightsTab;


    public void clickOnFlightTab() {
        flightsTab.click();
    }

    public void clickOnGiftCardTab(){
        giftCardsTab.click();
    }

    public void clickOnHolidaysTab() {}

    public void clickOnCabsTab() {
        cabsTab.click();
    }


    public void openApplication() {

        googlePopupCloseBtn.click();
        dontAllowBtn.click();
        loginPopupClosBtn.click();
    }

    public void clickOnBusTab() {
        busTab.click();
    }


    public boolean isHomePageDisplayed() {
        return trainsTab.isDisplayed() && busTab.isDisplayed();
    }

    public void ClickOnTrainsTab() {
        trainsTab.click();
    }

    public void clickOnMetroTab(){
        metroTab.click();
    }


}
