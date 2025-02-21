package com.automation.pages.web;

import com.automation.pages.ui.CabListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebCabListingPage extends WebBasePage implements CabListingPage {


    @FindBy(xpath = "//div[contains(text(),'Car Type')]")
    WebElement carTypeText;

    @FindBy(xpath = "//div[contains(text(),'Fuel Type')]")
    WebElement fuelTypeText;

    @FindBy(xpath = "//div[@class='ttl_sec']//span[contains(text(),'Your Transfer')]")
    WebElement yourTransferText;

    public boolean isCabListingPageDisplayed() {
        if (isDisplayed(yourTransferText))
            return true;
        return carTypeText.isDisplayed() && fuelTypeText.isDisplayed();
    }
}
