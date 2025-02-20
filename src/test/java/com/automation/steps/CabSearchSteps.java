package com.automation.steps;

import com.automation.pages.android.AndroidCabSearchPage;
import com.automation.pages.ui.CabSearchPage;
import com.automation.pages.web.WebCabSearchPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CabSearchSteps {

    CabSearchPage cabSearchPage;

    public CabSearchSteps(){
        if(ConfigReader.getConfigValue("application.type").equalsIgnoreCase("Web")){
            cabSearchPage = new AndroidCabSearchPage();
        }else
            cabSearchPage = new WebCabSearchPage();
    }


    @Then("verify user is on the cab booking page")
    public void verifyUserIsOnTheCabBookingPage() {
        Assert.assertTrue(cabSearchPage.isCabSearchPageDisplayed());
    }

    @When("user selects booking type {string}")
    public void userSelectsBookingType(String bookingType) {
        cabSearchPage.selectCabBookingType(bookingType);
    }

    @And("user enters pick-up location as {string}")
    public void userEntersPickUpLocationAs(String fromCity) {
        cabSearchPage.enterPickupLocation(fromCity);
    }

    @And("user enters drop location as {string}")
    public void userEntersDropLocationAs(String toCity) {
        cabSearchPage.enterDropLocation(toCity);
    }


    @And("user selects pick-up date {string} and time {string}")
    public void userSelectsPickUpDateAndTime(String date, String time) {
        cabSearchPage.selectPickupDateAndTime(date,time);
    }

    @And("user selects return date {string} and time {string} if applicable")
    public void userSelectsReturnDateAndTimeIfApplicable(String date, String time) {
        cabSearchPage.selectReturnDateAndTime(date, time);
    }

    @And("user enters rental duration {string} if applicable")
    public void userEntersRentalDurationIfApplicable(String duration) {
    }

    @And("user enters age {string} if applicable")
    public void userEntersAgeIfApplicable(String age) {

    }

    @And("user clicks on cab search button")
    public void userClicksOnCabSearchButton() {
    }

    @Then("verify user is on cab listing page")
    public void verifyUserIsOnCabListingPage() {
    }


    @And("user enters country {string} if applicable")
    public void userEntersCountryIfApplicable(String country) {
    }
}
