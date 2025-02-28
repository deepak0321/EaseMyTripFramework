package com.automation.steps;

import com.automation.pages.web.WebActivityDetailPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ActivityDetailSteps {

    WebActivityDetailPage detailPage = new WebActivityDetailPage();

    @Then("verify activity details page is displayed")
    public void verifyActivityDetailsPageIsDisplayed() {
        Assert.assertTrue(detailPage.isActivityDetailPageDisplayed());
    }

    @When("user selects the {string}, {string} and click on book now button")
    public void userSelectsTheAndClickOnBookNowButton(String date, String peopleCount) {
        detailPage.selectDate(date);
        detailPage.selectTime();
        detailPage.addPeople(peopleCount);
        detailPage.clickOnBookNowBtn();
    }
}
