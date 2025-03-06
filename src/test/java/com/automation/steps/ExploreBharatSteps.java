package com.automation.steps;

import com.automation.pages.android.AndroidExploreBharatPage;
import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.ui.ExploreBharatPage;
import com.automation.pages.ui.HomePage;
import com.automation.pages.web.WebExploreBharatPage;
import com.automation.pages.web.WebHomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ExploreBharatSteps {

    HomePage homePage;
    ExploreBharatPage exploreBharatPage;

    public ExploreBharatSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            homePage = new WebHomePage();
            exploreBharatPage = new WebExploreBharatPage();
        }
        else {
            homePage = new AndroidHomePage();
            exploreBharatPage = new AndroidExploreBharatPage();
        }
    }

    @When("user clicks on the Explore Bharat tab")
    public void userClicksOnTheExploreBharatTab() {
        homePage.clickOnExploreBharatTab();
    }

    @Then("verify user is on the explore Bharat page")
    public void verifyUserIsOnTheExploreBharatPage() {
        Assert.assertTrue(exploreBharatPage.isExploreBharatPageDisplayed());
    }

    @When("user select {string} activity from the india unveiled")
    public void userSelectActivityFromTheIndiaUnveiled(String input) {
        exploreBharatPage.selectActivity(input);
    }

    @Then("verify user is on the activity detail page")
    public void verifyUserIsOnTheActivityDetailPage() {
        Assert.assertTrue(exploreBharatPage.isActivityDetailsDisplayed());
    }

    @And("print the details of the activity")
    public void printTheDetailsOfTheActivity() {
        exploreBharatPage.printDetails();
    }
}
