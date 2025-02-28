package com.automation.steps;

import com.automation.pages.web.WebActivitiesUserInfoPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ActivitiesUserInfoSteps {

    WebActivitiesUserInfoPage activitiesUserInfoPage = new WebActivitiesUserInfoPage();

    @Then("verify user is on user information page")
    public void verifyUserIsOnUserInformationPage() {
        Assert.assertTrue(activitiesUserInfoPage.isUserInfoPageDisplayed());
    }

    @When("user fills the details:")
    public void userFillsTheLastNameAsAndFirstNameAs(DataTable dataTable) {
        activitiesUserInfoPage.fillUserDetails(dataTable);
    }

    @And("other details {string}, {string}, {string} and {string}")
    public void otherDetailsAnd(String mobile, String email, String panName, String panNumber) {
        activitiesUserInfoPage.fillContactDetails(mobile, email, panName, panNumber);
    }

    @Then("print the price details")
    public void printThePriceDetails() {
        activitiesUserInfoPage.printDetails();
    }
}
