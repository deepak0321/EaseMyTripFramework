package com.automation.pages.android;

import com.automation.pages.ui.ActivitiesPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidActivitiesPage extends AndroidBasePage implements ActivitiesPage {

    @FindBy(xpath = "//android.view.View[@resource-id='mainDiv']/android.view.View[4]")
    WebElement title;

    @FindBy(xpath = "//android.view.View[@resource-id='mainDiv']/android.view.View[4]//android.widget.TextView[2]")
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
