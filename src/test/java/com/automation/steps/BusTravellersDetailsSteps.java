package com.automation.steps;

import com.automation.pages.android.AndroidBusTravellersDetailsPage;
import com.automation.pages.ui.BusTravellersDetailsPage;
import com.automation.pages.web.WebBusTravellersDetailsPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class BusTravellersDetailsSteps {
    BusTravellersDetailsPage busTravellersDetailsPage ;

    public BusTravellersDetailsSteps(){
        if(ConfigReader.getConfigValue("application.type").equalsIgnoreCase("Web")){
            busTravellersDetailsPage = new WebBusTravellersDetailsPage();
        }else
            busTravellersDetailsPage = new AndroidBusTravellersDetailsPage();
    }

    @And("the user enters their personal details {string} , {string},{string},{string},{string}")
    public void theUserEntersTheirPersonalDetails(String title, String firstName, String lastName, String age, String mobileNumber) {
        busTravellersDetailsPage.enterUserDetails(title, firstName, lastName, age, mobileNumber);
    }

    @Then("user clicks on continue booking button")
    public void userClicksOnContinueBookingButton() {
        busTravellersDetailsPage.clickOnContinueBooking();
    }
    @Then("the user selects trip insurance option as {string}")
    public void theUserSelectsTripInsuranceOptionAs(String value) {
        busTravellersDetailsPage.selectTripInsurance(value);
    }

    @And("user enters email id {string}")
    public void userEntersEmailId(String email) {
        busTravellersDetailsPage.enterEmail(email);
    }

    @Then("user clicks on review continue button")
    public void userClicksOnReviewContinueButton() {
        busTravellersDetailsPage.clickOnContinue();
    }

    @And("verify that the payment options are displayed")
    public void verifyThatThePaymentOptionsAreDisplayed() {
        Assert.assertTrue(busTravellersDetailsPage.isPaymentOptionsDisplayed());
    }

    @And("verify bus review and traveller details page is displayed")
    public void verifyBusReviewAndTravellerDetailsPageIsDisplayed() {
        Assert.assertTrue(busTravellersDetailsPage.isBusTravellersDetailsPageDisplayed());
    }
}
