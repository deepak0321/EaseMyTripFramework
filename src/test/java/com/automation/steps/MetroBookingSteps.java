package com.automation.steps;

import com.automation.pages.android.AndroidMetroSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MetroBookingSteps {

    AndroidMetroSearchPage androidMetroSearchPage = new AndroidMetroSearchPage();


    @Then("verify metro booking page is displayed")
    public void verifyMetroBookingPageIsDisplayed() {
        Assert.assertTrue(androidMetroSearchPage.isMetroSearchPageDisplayed());
    }

    @When("user selects metro location {string}")
    public void userSelectsMetroLocation(String location) {
        androidMetroSearchPage.selectMetro(location);
    }

    @And("user selects metro line {string} if applicable")
    public void userSelectsMetroLineIfApplicable(String line) {
        androidMetroSearchPage.selectMetroLine(line);
    }

    @Then("user provides travel details {string} and {string}")
    public void userProvidesTravelDetailsAnd(String from, String to) {
        androidMetroSearchPage.enterMetroDetails(from,to);
    }

    @And("user selects number of passengers {string}")
    public void userSelectsNumberOfPassengers(String number) {
        androidMetroSearchPage.selectPassengers(number);
    }

    @Then("user accepts the terms and conditions")
    public void userAcceptsTheTermsAndConditions() {
        androidMetroSearchPage.acceptTC();
    }

    @When("user clicks proceed to pay button")
    public void userClicksProceedToPayButton() {
        androidMetroSearchPage.clickOnProceedToPayButton();
    }

    @Then("user provides the contact details {string} and {string}")
    public void userProvidesTheContactDetailsAnd(String email, String mobileNumber) {
        androidMetroSearchPage.enterTravellerDetails(email, mobileNumber);
    }

    @When("user clicks on metro continue button")
    public void userClicksOnMetroContinueButton() {
        androidMetroSearchPage.clickOnContinue();
    }

    @Then("verify payment sections page is displayed")
    public void verifyPaymentSectionsPageIsDisplayed() {
        Assert.assertTrue(androidMetroSearchPage.isPaymentSectionsDisplayed());
    }
}
