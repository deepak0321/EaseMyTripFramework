package com.automation.steps;

import com.automation.pages.android.AndroidActivitiesListPage;
import com.automation.pages.ui.ActivitiesPage;
import com.automation.pages.web.WebActivitiesListPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ActivitiesListSteps {

    ActivitiesPage activitiesListPage;

    public ActivitiesListSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("Web")) {
            activitiesListPage = new WebActivitiesListPage();
        } else {
            activitiesListPage = new AndroidActivitiesListPage();
        }
    }

    @Then("verify activities related to the location where displayed")
    public void verifyActivitiesRelatedToTheLocationWhereDisplayed() {
        Assert.assertTrue(activitiesListPage.isActivitiesListPageDisplayed());
    }

    @And("apply filter {string} and {string}")
    public void applyFilterAnd(String duration, String special) {
        activitiesListPage.applyFilter(duration, special);
    }

    @And("sort the suggestions by {string}")
    public void sortTheSuggestionsBy(String sortOption) {
        activitiesListPage.sort(sortOption);
    }

    @Then("verify suggestions are sorted based on {string}")
    public void verifySuggestionsAreSortedBasedOn(String sortOder) {
        Assert.assertTrue(activitiesListPage.verifySort(sortOder));
    }

    @When("user clicks on book now button on a package that contains {string}")
    public void userClicksOnBookNowButtonOnAPackageThatContains(String keyword) {
        activitiesListPage.selectActivity(keyword);
    }
}
