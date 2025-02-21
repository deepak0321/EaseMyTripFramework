package com.automation.pages.android;

import com.automation.pages.ui.BusSearchPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidBusSearchPage extends AndroidBasePage implements BusSearchPage {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Same Buses, Cheapest Price, Guaranteed!\"]")
    WebElement busPromoText;

    @FindBy(id = "com.easemytrip.android:id/search_bus_origin_container")
    WebElement startFrom;

    @FindBy(id = "com.easemytrip.android:id/layout_onward_DateTV")
    WebElement datePicker;

    @FindBy(id = "com.easemytrip.android:id/search")
    WebElement searchBar;

    String CITY_XPATH = "//android.widget.TextView[@resource-id=\"com.easemytrip.android:id/search_airport_list_item_name\" and @text=\"%s\"]";

    String DATE_XPATH = "//android.widget.TextView[@content-desc=\"Date is %s\"]";


    @FindBy(id = "com.easemytrip.android:id/btn_bus_search")
    WebElement busSearchBtn;


    public boolean isBusSearchPageDisplayed() {
        return busPromoText.isDisplayed();
    }

    public void enterBusDetails(String from, String to, String date) {

        startFrom.click();
        searchBar.sendKeys(ConfigReader.getConfigValue(from));
        driver.findElement(By.xpath(String.format(CITY_XPATH, ConfigReader.getConfigValue(from)))).click();

        searchBar.sendKeys(ConfigReader.getConfigValue(to));
        driver.findElement(By.xpath(String.format(CITY_XPATH, ConfigReader.getConfigValue(to)))).click();

        datePicker.click();
        String dateToSelect = dateFormat(ConfigReader.getConfigValue(date));
        while (!isElementDisplayed(String.format(DATE_XPATH, dateToSelect))) {
            scrollDown();
        }
        driver.findElement(By.xpath(String.format(DATE_XPATH, dateToSelect))).click();

    }

    public void clickOnSearchBtn() {

        busSearchBtn.click();

    }
}
