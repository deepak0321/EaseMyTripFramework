package com.automation.pages.android;

import com.automation.pages.ui.TrainSearchPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AndroidTrainSearchPage extends AndroidBasePage implements TrainSearchPage {

    @FindBy(id = "com.easemytrip.android:id/button_train_search")
    WebElement showTrainsBtn;

    @FindBy(id = "com.easemytrip.android:id/tvOrigin_code")
    WebElement fromCityElement;

    @FindBy(id = "com.easemytrip.android:id/search")
    WebElement citySearchInput;

    @FindBy(id = "com.easemytrip.android:id/tvDestination_code")
    WebElement toCityElement;

    @FindBy(id = "com.easemytrip.android:id/tvDepartureDate")
    WebElement datePicker;


    String SELECT_CITY_XPATH = "//android.widget.TextView[@resource-id=\"com.easemytrip.android:id/tv_station\" and @text=\"%s\"]";

    String DATE_XPATH = "//android.widget.TextView[@content-desc=\"Date is %s\"]";


    public void enterDepartureCity(String departureCity) {
        fromCityElement.click();
        citySearchInput.sendKeys(ConfigReader.getConfigValue(departureCity));
    }

    public void selectCity(String cityStation) {
        driver.findElement(By.xpath(String.format(SELECT_CITY_XPATH, ConfigReader.getConfigValue(cityStation)))).click();
    }

    public void enterArrivalCity(String arrivalCity) {
        toCityElement.click();
        citySearchInput.sendKeys(ConfigReader.getConfigValue(arrivalCity));
    }


    public boolean isTrainSearchPageDisplayed() {
        return showTrainsBtn.isDisplayed();
    }

    public void clickOnShowTrains() {
        showTrainsBtn.click();
    }

    public void selectDepartureDate(String departureDate) {
        datePicker.click();
        String dateToSelect = String.format(DATE_XPATH, ConfigReader.getConfigValue(departureDate));
        while (!isElementDisplayed(dateToSelect)) {
            scrollDown();
        }
        driver.findElement(By.xpath(dateToSelect)).click();
    }


}
