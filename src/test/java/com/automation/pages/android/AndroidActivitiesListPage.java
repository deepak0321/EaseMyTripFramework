package com.automation.pages.android;

import com.automation.pages.ui.ActivitiesPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidActivitiesListPage extends AndroidBasePage implements ActivitiesPage {

    @FindBy(xpath = "//android.view.View[@resource-id='flterLst']")
    WebElement filterBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Duration']/following-sibling::android.view.View//android.widget.TextView")
    List<WebElement> durationOptions;

    @FindBy(xpath = "//android.widget.TextView[@text='Specials']/following-sibling::android.view.View//android.widget.TextView")
    List<WebElement> specialOptions;

    @FindBy(xpath = "//android.widget.TextView[@text='Apply Filters']")
    WebElement applyFilterBtn;

    String XPATH_TO_LOCATION = "//android.widget.TextView[@text='%s']";

    public void applyFilter(String durationVal, String specialVal) {
        filterBtn.click();

        for (WebElement duration : durationOptions) {
            if (duration.getText().equalsIgnoreCase(ConfigReader.getConfigValue(durationVal))) {
                duration.click();
                break;
            }
        }

        for (WebElement special : specialOptions) {
            if (special.getText().contains(ConfigReader.getConfigValue(specialVal))) {
                special.click();
                break;
            }
        }
        scrollDown();
        applyFilterBtn.click();
    }

    public void selectActivity(String location) {

        String elementToClickXpath = String.format(XPATH_TO_LOCATION,ConfigReader.getConfigValue(location));
        while (!isDisplayed(elementToClickXpath)) {
            scrollDown();
        }
        driver.findElement(By.xpath(elementToClickXpath)).click();
    }

    public boolean isActivitiesListPageDisplayed() {
        return filterBtn.isDisplayed();
    }
}
