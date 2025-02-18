package com.automation.steps;


import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.ui.HomePage;
import com.automation.pages.web.WebHomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {
    HomePage homePage ;

    public HomeSteps(){
        if(ConfigReader.getConfigValue("application.type").equalsIgnoreCase("Web")){
            homePage = new WebHomePage();
        }else
            homePage = new AndroidHomePage();
    }


    @Given("user opens application")
    public void userOpensApplication() {
        homePage.openApplication();
    }

    @Then("verify home page is displayed")
    public void verifyHomePageIsDisplayed() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user clicks on trains tab")
    public void userClicksOnTrainsTab() {
        homePage.ClickOnTrainsTab();
    }


    @When("user clicks on bus tab")
    public void userClicksOnBusTab() {
        homePage.clickOnBusTab();
    }


}
