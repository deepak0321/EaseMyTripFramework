package com.automation.pages.web;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

public class WebActivitiesListPage extends WebBasePage {

    @FindBy(id = "citynamesec")
    WebElement title;

    @FindBy(xpath = "//div[@id='duration']/label")
    List<WebElement> durationOptions;

    @FindBy(xpath = "//div[@id='vspecial']//span[@class='tllfttp']")
    List<WebElement> specialOptions;

    @FindBy(xpath = "//div[@id='srt_slct']//li")
    List<WebElement> sortOptions;

    @FindBy(xpath = "//div[@class='pos-rel']/div[@class='_P_Price']")
    List<WebElement> suggestedActivitiesPrices;

    @FindBy(xpath = "//div[@class='_cityname']")
    List<WebElement> cityNames;

    public boolean isActivitiesListPageDisplayed() {
        return title.isDisplayed();
    }

    public void applyFilter(String durationVal, String specialVal) {

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
    }

    public void sort(String value) {

        for (WebElement element : sortOptions) {
            if (element.getText().contains(value)) {
                element.click();
                break;
            }
        }
    }

    public boolean verifySort(String sortOrder) {

        if (sortOrder.equalsIgnoreCase("low to high")) {

            for (int i = 1; i < 10; ++i) {
                double prev = stringPriceValueToDouble(suggestedActivitiesPrices.get(i - 1).getText());
                double curr = stringPriceValueToDouble(suggestedActivitiesPrices.get(i).getText());

                if (curr < prev) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < 10; ++i) {
                double prev = stringPriceValueToDouble(suggestedActivitiesPrices.get(i - 1).getText());
                double curr = stringPriceValueToDouble(suggestedActivitiesPrices.get(i).getText());

                if (curr > prev) {
                    return false;
                }
            }
        }
        return true;
    }

    public void selectActivity(String location) {

        String originalWindow = driver.getWindowHandle();

        for (WebElement name : cityNames) {
            if (name.getText().contains(ConfigReader.getConfigValue(location))) {
                name.findElement(By.xpath("./../following-sibling::div/div[@class='_bookhBtn']")).click();
                break;
            }
        }

        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
