package com.automation.steps;

import com.automation.pages.android.AndroidActivityDetailPage;
import com.automation.pages.ui.ActivitiesPage;
import com.automation.pages.web.WebActivityDetailPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ActivityDetailSteps {

    ActivitiesPage activityDetailPage;

    public ActivityDetailSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("Web")) {
            activityDetailPage = new WebActivityDetailPage();
        } else {
            activityDetailPage = new AndroidActivityDetailPage();
        }
    }

    @Then("verify activity details page is displayed")
    public void verifyActivityDetailsPageIsDisplayed() {
        Assert.assertTrue(activityDetailPage.isActivityDetailPageDisplayed());
    }

    @When("user selects the {string}, {string} and click on book now button")
    public void userSelectsTheAndClickOnBookNowButton(String date, String peopleCount) {
        activityDetailPage.selectDate(date);
        activityDetailPage.selectTime();
        activityDetailPage.addPeople(peopleCount);
        activityDetailPage.clickOnBookNowBtn();
    }
}
