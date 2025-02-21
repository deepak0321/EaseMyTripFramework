package com.automation.steps;

import com.automation.pages.android.AndroidBusListingPage;
import com.automation.pages.ui.BusListingPage;
import com.automation.pages.web.WebBusListingPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BusListingSteps {

    BusListingPage busListingPage;


    public BusListingSteps() {
        if (ConfigReader.getConfigValue("application.type").equalsIgnoreCase("Web")) {
            busListingPage = new WebBusListingPage();
        } else
            busListingPage = new AndroidBusListingPage();
    }

    @Then("verify bus listing page is displayed")
    public void verifyBusListingPageIsDisplayed() {
        Assert.assertTrue(busListingPage.isBusListingPageDisplayed());
    }

    @When("the user clicks the Select Seats button for the first bus")
    public void theUserClicksTheSelectSeatsButtonForTheFirstBus() {
        busListingPage.clickOnSelectSeats();
    }

    @Then("the first available seat should be selected")
    public void theFirstAvailableSeatShouldBeSelected() {
        busListingPage.selectFirstAvailableSeat();
    }

    @And("user selects boarding point {string}")
    public void userSelectsBoardingPoint(String boardingPoint) {
        busListingPage.selectPoint(boardingPoint);
    }

    @Then("user selects dropping point {string}")
    public void userSelectsDroppingPoint(String droppingPoint) {
        busListingPage.selectPoint(droppingPoint);
    }

    @When("user clicks on continue button")
    public void userClicksOnContinueButton() {
        busListingPage.clickOnContinue();
    }
}
