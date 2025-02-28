package com.automation.steps;

import com.automation.pages.web.WebActivitiesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ActivitiesSteps {

    WebActivitiesPage webActivitiesPage = new WebActivitiesPage();

    @Then("activities page is displayed")
    public void activitiesPageIsDisplayed() {
        Assert.assertTrue(webActivitiesPage.isActivitiesPageDisplayed());
    }

    @When("user selects the {string}")
    public void userSelectsThe(String location) {
        webActivitiesPage.selectPlace(location);
    }

}
