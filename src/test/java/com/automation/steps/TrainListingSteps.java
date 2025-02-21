package com.automation.steps;

import com.automation.pages.android.AndroidTrainListingPage;
import com.automation.pages.ui.TrainListingPage;
import com.automation.pages.web.WebTrainListingPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class TrainListingSteps {
    TrainListingPage trainListingPage;

    public TrainListingSteps() {
        if (ConfigReader.getConfigValue("application.type").equalsIgnoreCase("Web")) {
            trainListingPage = new WebTrainListingPage();
        } else
            trainListingPage = new AndroidTrainListingPage();
    }

    @Then("verify the train listing page is displayed")
    public void verifyTheTrainListingPageIsDisplayed() {
        Assert.assertTrue(trainListingPage.isTrainListingPageDisplayed());
    }
}
