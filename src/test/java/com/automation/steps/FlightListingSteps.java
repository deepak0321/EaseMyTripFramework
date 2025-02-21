package com.automation.steps;


import com.automation.pages.android.AndroidFlightListingPage;
import com.automation.pages.ui.FlightListingPage;
import com.automation.pages.web.WebFlightListingPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FlightListingSteps {

    FlightListingPage flightListingPage;

    public FlightListingSteps() {
        if (ConfigReader.getConfigValue("application.type").equalsIgnoreCase("web")) {
            flightListingPage = new WebFlightListingPage();
        } else {
            flightListingPage = new AndroidFlightListingPage();
        }
    }

    @Then("verify user is on flight listing page")
    public void verifyUserIsOnFlightListingPage() {
        Assert.assertTrue(flightListingPage.isFlightListingPageDisplayed());
    }

    @When("user select filter option {string}")
    public void userSelectFilterOption(String filterOption) {
        flightListingPage.selectFilterOption(ConfigReader.getConfigValue(filterOption));
    }

    @Then("verify only {string} flights are displayed on the page")
    public void verifyOnlyFlightsAreDisplayedOnThePage(String filterValue) {
        Assert.assertTrue(flightListingPage.isFlightListingDisplayedWithFilter(ConfigReader.getConfigValue(filterValue)));
    }
}
