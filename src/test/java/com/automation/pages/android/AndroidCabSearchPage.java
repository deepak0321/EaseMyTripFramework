package com.automation.pages.android;

import com.automation.pages.ui.CabSearchPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidCabSearchPage extends AndroidBasePage implements CabSearchPage {

    @FindBy(id = "com.easemytrip.android:id/rbAirportTransfer")
    WebElement cabAirport;

    @FindBy(id = "com.easemytrip.android:id/rbHourly")
    WebElement cabHourly;


    public boolean isCabSearchPageDisplayed(){
        return cabAirport.isDisplayed() && cabHourly.isDisplayed();
    }


    public void clickOnSearchBtn() {

    }

    public void selectCabBookingType(String cabBookingType) {

    }

    public void enterPickupLocation(String pickUpLocation) {

    }

    public void enterDropLocation(String dropLocation) {

    }

    public void selectPickupDateAndTime(String date, String time) {

    }

    public void selectReturnDateAndTime(String date, String time) {

    }

    public void selectRentalHours(String hours) {

    }

    public void selectCountry(String country) {

    }

    public void selectAge(String age) {

    }

}
