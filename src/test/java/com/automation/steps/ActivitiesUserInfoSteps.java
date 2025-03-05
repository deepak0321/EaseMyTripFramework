package com.automation.steps;

import com.automation.pages.android.AndroidActivitiesUserInfoPage;
import com.automation.pages.ui.ActivitiesPage;
import com.automation.pages.web.WebActivitiesUserInfoPage;
import com.automation.utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ActivitiesUserInfoSteps {

    ActivitiesPage activitiesUserInfoPage;

    public ActivitiesUserInfoSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("Web")) {
            activitiesUserInfoPage = new WebActivitiesUserInfoPage();
        } else {
            activitiesUserInfoPage = new AndroidActivitiesUserInfoPage();
        }
    }

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
