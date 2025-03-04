package com.automation.steps;


import com.automation.pages.ui.CabSearchPage;
import com.automation.pages.web.WebCabSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CabSearchSteps {

    CabSearchPage cabSearchPage = new WebCabSearchPage();

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
        if (!toCity.equals("-"))
            cabSearchPage.enterDropLocation(toCity);
    }


    @And("user selects pick-up date {string} and time {string}")
    public void userSelectsPickUpDateAndTime(String date, String time) {
        cabSearchPage.selectPickupDateAndTime(date, time);
    }

    @And("user selects return date {string} and time {string} if applicable")
    public void userSelectsReturnDateAndTimeIfApplicable(String date, String time) {
        if (!date.equals("-"))
            cabSearchPage.selectReturnDateAndTime(date, time);
    }

    @And("user enters rental duration {string} if applicable")
    public void userEntersRentalDurationIfApplicable(String duration) {
        if (!duration.equals("-"))
            cabSearchPage.selectRentalHours(duration);

    }

    @And("user enters age {string} if applicable")
    public void userEntersAgeIfApplicable(String age) {
        if (!age.equals("-"))
            cabSearchPage.selectAge(age);
    }

    @And("user clicks on cab search button")
    public void userClicksOnCabSearchButton() {
        cabSearchPage.clickOnSearchBtn();
    }


    @And("user enters country {string} if applicable")
    public void userEntersCountryIfApplicable(String country) {
        if (!country.equals("-"))
            cabSearchPage.selectCountry(country);
    }
}
