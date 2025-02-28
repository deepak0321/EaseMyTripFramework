package com.automation.pages.web;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebActivitiesPage extends WebBasePage {

    @FindBy(id = "citynamesec")
    WebElement title;

    @FindBy(xpath = "//div[@class='owl-item active']//a/div[@class='citynm']")
    List<WebElement> availablePlaces;

    public boolean isActivitiesPageDisplayed() {
        return title.isDisplayed();
    }

    public void selectPlace(String inputPlace) {

        for (WebElement place : availablePlaces) {
            if (place.getText().equalsIgnoreCase(ConfigReader.getConfigValue(inputPlace))) {
                place.click();
                break;
            }
        }
    }

}
