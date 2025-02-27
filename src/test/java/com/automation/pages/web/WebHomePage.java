package com.automation.pages.web;

import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


}
