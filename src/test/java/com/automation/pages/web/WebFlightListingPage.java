package com.automation.pages.web;


import com.automation.pages.ui.FlightListingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebFlightListingPage extends WebBasePage implements FlightListingPage {

    @FindBy(xpath = "//div[@deptm and not(@style='display: none;')]//span[contains(@ng-bind,'GetAirLineName')]")
    List<WebElement> listOfFlightNames;

    @FindBy(xpath = "//div[@class='prc_val airl1-sec']//label")
    List<WebElement> filterOptionValues;


    public boolean isFlightListingPageDisplayed() {
        return !listOfFlightNames.isEmpty();
    }

    public void selectFilterOption(String filterOption) {
        for (WebElement filter : filterOptionValues) {
            if (!filter.getText().trim().equalsIgnoreCase(filterOption)) {
                if (filter.findElement(By.xpath("./input")).isSelected()) {
                    filter.click();
                }
            } else {
                if (!filter.findElement(By.xpath("./input")).isSelected()) {
                    filter.click();
                }
            }
        }
    }

    public boolean isFlightListingDisplayedWithFilter(String filterOption) {
        for (WebElement flight : listOfFlightNames) {
            System.out.println("==> " + flight.getText());
            if (!flight.getText().equalsIgnoreCase(filterOption)) {
                return false;
            }
        }
        return true;
    }
}
