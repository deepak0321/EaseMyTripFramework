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

    public void clickOnBusTab(){
        busTab.click();
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
}
