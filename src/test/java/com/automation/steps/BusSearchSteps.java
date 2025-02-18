package com.automation.steps;

import com.automation.pages.android.AndroidBusSearchPage;
import com.automation.pages.ui.BusSearchPage;
import com.automation.pages.web.WebBusSearchPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BusSearchSteps {

    BusSearchPage busSearchPage;

    public BusSearchSteps() {
        if (ConfigReader.getConfigValue("application.type").equalsIgnoreCase("Web")) {
            busSearchPage = new WebBusSearchPage();
        } else
            busSearchPage = new AndroidBusSearchPage();
    }


    @Then("verify bus search page is displayed")
    public void verifyBusSearchPageIsDisplayed() {
        Assert.assertTrue(busSearchPage.isBusSearchPageDisplayed());
    }

    @When("user enters bus details {string} and {string} and {string}")
    public void userEntersBusDetailsAndAnd(String from, String to, String date) {
        busSearchPage.enterBusDetails(from, to, date);
    }

    @And("user clicks on search button")
    public void userClicksOnSearchButton() {
        busSearchPage.clickOnSearchBtn();
    }


}
