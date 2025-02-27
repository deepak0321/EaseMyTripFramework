package com.automation.steps;

import com.automation.pages.web.WebQueryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class QuerySteps {

    WebQueryPage queryPage = new WebQueryPage();

    @Then("verify user is on query page")
    public void verifyUserIsOnQueryPage() {
        Assert.assertTrue(queryPage.isQueryPageDisplayed());
    }

    @Then("verify query number is generated")
    public void verifyQueryNumberIsGenerated() {
        Assert.assertTrue(queryPage.isQueryNumberGenerated());
    }

    @When("user clicks on goto homepage btn")
    public void userClicksOnGotoHomepageBtn() {
        queryPage.clickOnGotoHomeBtn();
    }
}
