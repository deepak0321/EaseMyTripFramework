package com.automation.pages.android;


import com.automation.pages.ui.FlightSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidFlightSearchPage extends AndroidBasePage implements FlightSearchPage {

    @FindBy(id = "com.easemytrip.android:id/search_flight_origin_title")
    WebElement fromCityElement;

    @FindBy(id = "com.easemytrip.android:id/edt_depart_airport")
    WebElement fromCityInput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/search_airport_list_item_name']")
    WebElement searchAirportResult;

    @FindBy(id = "com.easemytrip.android:id/search_flight_destination_title")
    WebElement toCityElement;

    @FindBy(id = "com.easemytrip.android:id/edt_arrival_airport")
    WebElement toCityInput;

    @FindBy(id = "com.easemytrip.android:id/depdateView")
    WebElement departureDateElement;

    @FindBy(id = "com.easemytrip.android:id/button_flight_Search")
    WebElement searchBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvMonthName']")
    WebElement monthAndYear;

    @FindBy(id = "com.easemytrip.android:id/search_flight_return_date")
    WebElement returnDateElement;

    @FindBy(id = "com.easemytrip.android:id/rdbRoundtrip")
    WebElement roundTripTab;

    String XPATH_DATE_VALUE = "//android.widget.TextView[@content-desc='Date is %s']";

    public boolean isFlightSearchPageDisplayed() {
        return fromCityElement.isDisplayed() && searchBtn.isDisplayed();
    }

    public void enterFromCity(String fromCity) {
        fromCityElement.click();
        fromCityInput.sendKeys(fromCity);
        pause(1000);
        waitForElementVisible(searchAirportResult);
        searchAirportResult.click();
    }

    public void enterToCity(String toCity) {
        toCityElement.click();
        toCityInput.sendKeys(toCity);
        pause(1000);
        waitForElementVisible(searchAirportResult);
        searchAirportResult.click();
    }

    public void enterDate(String date) {
        String expDate;
        if(!date.endsWith("-R")){
            departureDateElement.click();
            expDate = getFormattedDate("dd MMM yyyy", date, "dd/MM/yyyy");
        }
        else{
            expDate = getFormattedDate("dd MMM yyyy", date.substring(0,date.length()-2), "dd/MM/yyyy");
        }
        String expDateXpath = String.format(XPATH_DATE_VALUE, expDate);

        while (!isDisplayed(expDateXpath)) {
            scrollDown();
        }
        driver.findElement(By.xpath(expDateXpath)).click();
    }


    public void clickOnFlightSearchBtn() {
        searchBtn.click();
    }

    public void clickOnReturnDateElement() {
        returnDateElement.click();
    }

    public boolean isRoundTripTabActivated() {
        return roundTripTab.getAttribute("checked").contains("true");
    }
}
