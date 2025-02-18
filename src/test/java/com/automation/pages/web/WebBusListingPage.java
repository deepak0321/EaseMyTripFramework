package com.automation.pages.web;

import com.automation.pages.ui.BusListingPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WebBusListingPage extends WebBasePage implements BusListingPage {

    @FindBy(xpath = "//input[@id='chkGps']")
    WebElement gpsEnabledBuses;

    @FindBy(xpath = "//div[contains(@class,'mn-title_new')]")
    WebElement busSearchResult;

    @FindBy(xpath = "(//a[text()='Select Seats'])[1]")
    WebElement selectSeatsBtn;

    @FindBy(xpath = "(//a[contains(@class,'sl_available') or contains(@class,'se_available')])[1]")
    WebElement firstAvailableSeat;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;

    String BOARDING_POINT_XPATH = "//div[@class='boarding-pnt']/label/span[contains(text(),\"%s\")]";

    public void selectPoint(String point) {
        driver.findElement(By.xpath(String.format(BOARDING_POINT_XPATH, ConfigReader.getConfigValue(point)))).click();
    }

    public void clickOnContinue(){
        continueBtn.click();
    }

    public void selectFirstAvailableSeat() {
        firstAvailableSeat.click();
    }

    public void clickOnSelectSeats() {
        selectSeatsBtn.click();
    }

    public boolean isBusListingPageDisplayed() {
        return busSearchResult.isDisplayed();
    }


}
