package com.automation.steps;

import com.automation.pages.android.AndroidGiftCardPage;
import com.automation.pages.ui.GiftCardPage;
import com.automation.pages.web.WebGiftCardPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GiftCardSteps {

    GiftCardPage giftCardPage;

    public GiftCardSteps() {
        if (ConfigReader.getConfigValue("application.type").equalsIgnoreCase("Web")) {
            giftCardPage = new WebGiftCardPage();
        } else
            giftCardPage = new AndroidGiftCardPage();
    }


    @Then("verify gift card page is displayed")
    public void verifyGiftCardPageIsDisplayed() {
        Assert.assertTrue(giftCardPage.isGiftCardPageDisplayed());
    }

    @When("user selects gift card category {string}")
    public void userSelectsGiftCardCategory(String category) {
        giftCardPage.selectGiftCardCategory(category);
    }

    @Then("user clicks on gift card type {string}")
    public void userClicksOnGiftCardType(String type) {
        giftCardPage.selectGiftCardType(type);
    }

    @And("user enters gift card details {string}, {string}, {string}")
    public void userEntersGiftCardDetails(String denomination, String quantity, String deliveryDate) {
        giftCardPage.enterGiftCardDetails(denomination,quantity,deliveryDate);
    }

    @Then("user enters sender's details {string}, {string}, {string}")
    public void userEntersSenderDetails(String name, String email, String mobileNumber) {
        giftCardPage.enterSenderDetails(name,email,mobileNumber);
    }

    @And("user selects either sender and receiver details are same checkbox {string}")
    public void userSelectsEitherSenderAndReceiverDetailsAreSameCheckbox(String isSame) {
        giftCardPage.selectIfSenderAndReceiverDetailsAreSame(isSame);
    }

    @Then("if not, user enters receiver's details {string}, {string}, {string}")
    public void ifNotUserEntersReceiverSDetails(String name, String email, String mobileNumber) {
        giftCardPage.enterReceiverDetails(name,email,mobileNumber);
    }

    @Then("user clicks accept terms and conditions")
    public void userClicksAcceptTermsAndConditions() {
        giftCardPage.acceptTC();
    }

    @When("user clicks on pay now button")
    public void userClicksOnPayNowButton() {
        giftCardPage.clickOnPayNow();
    }

    @Then("user enters otp")
    public void userEntersOtp() {
        giftCardPage.enterOTP();
    }

    @When("user clicks on verify now button")
    public void userClicksOnVerifyNowButton() {
        giftCardPage.clickOnVerifyNow();
    }

    @Then("verify payment options page is displayed")
    public void verifyPaymentOptionsPageIsDisplayed() {
        Assert.assertTrue(giftCardPage.isPaymentModesDisplayed());
    }


    @Then("user enters delivery date details {string} ,{string},{string} if applicable")
    public void userEntersDeliveryDateDetailsIfApplicable(String date, String month, String year) {
        giftCardPage.enterDeliveryDateDetails(date,month,year);
    }
}
