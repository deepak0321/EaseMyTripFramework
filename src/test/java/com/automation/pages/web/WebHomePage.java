package com.automation.pages.web;

import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class WebHomePage extends WebBasePage implements HomePage {

    @FindBy(xpath = "//span[text()='Join EMTPro']")
    WebElement emtProText;

    @FindBy(xpath = "//a//span[text()='Trains']")
    WebElement trainsTab;

    @FindBy(xpath = "//a//span[text()='Bus']")
    WebElement busTab;

    @FindBy(xpath = "//a//span[text()='Cabs']")
    WebElement cabsTab;

    @FindBy(xpath = "//a/span[text()='Flights']")
    WebElement flightTab;

    @FindBy(xpath = "//a//span[text()='Gift Card']")
    WebElement giftCardOption;

    @FindBy(xpath = "//a//span[text()='More']")
    WebElement moreTab;

    @FindBy(xpath = "//img[@class='_rohChatAI']")
    WebElement chatbotIcon;

    @FindBy(xpath = "//span[text()='Holidays']")
    WebElement holidaysTab;

    @FindBy(xpath = "//span[text()='Activities']")
    WebElement activitiesTab;

    @FindBy(id = "divSignInPnl")
    WebElement loginBtn;

    @FindBy(id = "shwlogn")
    WebElement customerLoginBtn;

    @FindBy(id = "txtEmail")
    WebElement mobileOrEmailInputBar;

    @FindBy(id = "shwotp")
    WebElement continueBtn;

    @FindBy(xpath = "(//input[@value='Login'])[1]")
    WebElement otpLoginBtn;

    @FindBy(xpath = "(//input[@value='Login'])[2]")
    WebElement passwordLoginBtn;

    @FindBy(xpath = "//div[@class='_crosslog _crosslogsuccess']")
    WebElement closeBtn;

    @FindBy(xpath = "//span[@id='welcome-det-User']")
    WebElement profileTab;

    @FindBy(xpath = "//a[@class='_drpdubro LogOut']")
    WebElement logoutBtn;

    @FindBy(id = "shwlgnbx")
    WebElement passwordOptionBtn;

    @FindBy(xpath = "//input[@id='txtEmail2']")
    WebElement passwordInputTab;

    @FindBy(xpath = "//span[text()='Explore Bharat']")
    WebElement exploreBharatTab;

    boolean pass = false;


    public void clickOnFlightTab() {
        flightTab.click();
    }

    public void clickOnGiftCardTab() {
        clickOnMoreTab();
        clickOnGiftCard();
    }

    public void clickOnBusTab() {
        busTab.click();
    }

    public void clickOnCabsTab() {
        cabsTab.click();
    }

    public void openApplication() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    public boolean isHomePageDisplayed() {
        return emtProText.isDisplayed();
    }

    public void ClickOnTrainsTab() {
        trainsTab.click();
    }

    public void clickOnMoreTab() {
        moreTab.click();
    }

    public void clickOnGiftCard() {
        giftCardOption.click();
    }

    public void clickOnChatbotIcon() {
        chatbotIcon.click();
    }

    public void clickOnHolidaysTab() {
        holidaysTab.click();
    }

    public void clickOnActivitiesTab() {
        activitiesTab.click();
    }

    public void clickOnLoginBtn() {
        loginBtn.click();
        customerLoginBtn.click();
    }

    public boolean isPopupDisplayed() {
        return mobileOrEmailInputBar.isDisplayed();
    }

    public void enterMobile(String mobile) {
        mobileOrEmailInputBar.sendKeys(ConfigReader.getConfigValue(mobile));
    }

    public void clickOnContinueBtn() {
        continueBtn.click();
    }

    public boolean isOtpGenerated() {
        wait.until(ExpectedConditions.visibilityOf(otpLoginBtn));
        return otpLoginBtn.isDisplayed();
    }

    public void enterOtp() {
        pause(20000);
    }

    public void clickOnOtpOrPasswordLoginBtn() {
        if (pass) {
            passwordLoginBtn.click();
        } else {
            otpLoginBtn.click();
        }
        closeBtn.click();
    }

    public boolean isUserLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(profileTab));
        return profileTab.isDisplayed();
    }

    public void clickOnProfileTab() {
        profileTab.click();
    }

    public void clickOnLogoutBtn() {
        logoutBtn.click();
    }

    public boolean isUserLoggedOut() {
        return loginBtn.isDisplayed();
    }

    public boolean isPasswordOptionDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(passwordOptionBtn));
        return passwordOptionBtn.isDisplayed();
    }

    public void enterPassword(String password) {
        passwordOptionBtn.click();
        passwordInputTab.sendKeys(ConfigReader.getConfigValue(password));
        pass = true;
    }

    public void clickOnExploreBharatTab() {
        String originalWindow = driver.getWindowHandle();

        exploreBharatTab.click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
