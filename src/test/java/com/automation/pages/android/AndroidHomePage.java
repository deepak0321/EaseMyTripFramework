package com.automation.pages.android;

import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(xpath = "//android.widget.TextView[@text='Activities']")
    WebElement activitiesTab;


    @FindBy(xpath = "//android.view.View[@content-desc='Toggle drawer']")
    WebElement toggleBar;

    @FindBy(xpath = "//android.widget.TextView[@text='Login or Signup']")
    WebElement loginBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/txtLoginInput']")
    WebElement inputTextBar;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.easemytrip.android:id/btn_login']")
    WebElement continueBtn;

    @FindBy(id = "com.easemytrip.android:id/btn_authenticate")
    WebElement otpLoginBtn;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.easemytrip.android:id/btn_authenticate']")
    WebElement passwordLoginBtn;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Hi')]")
    WebElement profile;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Cancel']")
    WebElement closeBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.gms:id/matched_sms']")
    WebElement otpText;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.google.android.gms:id/negative_button']")
    WebElement denyBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/txtAuthInput']")
    WebElement otpInputField;

    @FindBy(xpath = "//android.widget.TextView[@text='Sign Out']")
    WebElement signOutBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Logout']")
    WebElement logoutBtn;

    @FindBy(id = "shwlgnbx")
    WebElement passwordOptionBtn;

    @FindBy(xpath = "//input[@id='txtEmail2']")
    WebElement passwordInputTab;

    @FindBy(xpath = "//android.widget.TextView[@text='Explore Bharat']")
    WebElement exploreBharatTab;

    boolean pass = false;

    public void clickOnFlightTab() {
        flightsTab.click();
    }

    public void clickOnGiftCardTab(){
        giftCardsTab.click();
    }

    public void clickOnHolidaysTab() {}

    public void clickOnActivitiesTab() {
        activitiesTab.click();
    }

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


    public void clickOnLoginBtn() {
        toggleBar.click();
        loginBtn.click();
    }

    public boolean isPopupDisplayed() {
        googlePopupCloseBtn.click();
        return inputTextBar.isDisplayed();
    }

    public void enterMobile(String mobileNumber) {
        inputTextBar.sendKeys(ConfigReader.getConfigValue(mobileNumber));
    }

    public void clickOnContinueBtn() {
        continueBtn.click();
    }

    public boolean isOtpGenerated() {
        return otpLoginBtn.isDisplayed();
    }

    public void enterOtp() {
        String otp = otpText.getText().substring(0, 7);
        denyBtn.click();
        otpInputField.sendKeys(otp);
    }

    public void clickOnOtpOrPasswordLoginBtn() {
        if (pass) {
            passwordLoginBtn.click();
        } else {
            otpLoginBtn.click();
        }
    }

    public boolean isUserLoggedIn() {
        toggleBar.click();
        return profile.isDisplayed();
    }

    public void clickOnProfileTab() {
        closeBtn.click();
        toggleBar.click();
    }

    public void clickOnLogoutBtn() {
        scrollDown();
        signOutBtn.click();
        logoutBtn.click();
    }

    public boolean isUserLoggedOut() {
        toggleBar.click();
        return loginBtn.isDisplayed();
    }

    public boolean isPasswordOptionDisplayed() {
        return passwordOptionBtn.isDisplayed();
    }

    public void enterPassword(String password) {
        passwordOptionBtn.click();
        denyBtn.click();
        passwordInputTab.sendKeys(ConfigReader.getConfigValue(password));
        pass = true;
    }

    public void clickOnExploreBharatTab() {
        exploreBharatTab.click();
    }
}
