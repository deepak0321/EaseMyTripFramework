package com.automation.steps;

import com.automation.pages.web.WebActivitiesListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ActivitiesListSteps {

    WebActivitiesListPage activitiesListPage = new WebActivitiesListPage();

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
