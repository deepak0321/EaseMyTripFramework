package com.automation.pages.android;


import com.automation.pages.ui.FlightListingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidFlightListingPage extends AndroidBasePage implements FlightListingPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_flight_name']")
    List<WebElement> listOfFlightNames;

    @FindBy(id = "com.easemytrip.android:id/rl_more_filters")
    WebElement moreFilterBtn;

    @FindBy(id = "com.easemytrip.android:id/btn_ApplyFilter")
    WebElement applyBtn;

    String XPATH_FLIGHT_NAME_FILTER_OPTION = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.easemytrip.android:id/airlinesRecycler']//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_name_Airline' and @text='Air India']";


    public boolean isFlightListingPageDisplayed() {
        return !listOfFlightNames.isEmpty();
    }

    public void selectFilterOption(String filterOption) {
        moreFilterBtn.click();
        String filterOptionFlightName = String.format(XPATH_FLIGHT_NAME_FILTER_OPTION, filterOption);
        while (!isDisplayed(filterOptionFlightName)) {
            scrollDown();
        }
        driver.findElement(By.xpath(filterOptionFlightName)).click();
        applyBtn.click();
    }

    public boolean isFlightListingDisplayedWithFilter(String filterOption) {
        for (WebElement flight : listOfFlightNames) {
            System.out.println("==> " + flight.getText());
            if (!flight.getText().contains(filterOption)) {
                return false;
            }
        }
        return true;
    }
}
