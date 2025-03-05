package com.automation.steps;

import com.automation.pages.android.AndroidActivitiesListPage;
import com.automation.pages.android.AndroidActivitiesPage;
import com.automation.pages.ui.ActivitiesPage;
import com.automation.pages.web.WebActivitiesListPage;
import com.automation.pages.web.WebActivitiesPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ActivitiesSteps {

    ActivitiesPage activitiesPage;

    public ActivitiesSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("Web")) {
            activitiesPage = new WebActivitiesPage();
        } else {
            activitiesPage = new AndroidActivitiesPage();
        }
    }


    @Then("activities page is displayed")
    public void activitiesPageIsDisplayed() {
        Assert.assertTrue(activitiesPage.isActivitiesPageDisplayed());
    }

    @When("user selects the {string}")
    public void userSelectsThe(String location) {
        activitiesPage.selectPlace(location);
    }

}
