package com.automation.steps;


import com.automation.pages.web.WebTrainSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TrainSearchSteps {
    WebTrainSearchPage trainSearchPage = new WebTrainSearchPage();

    @Then("verify train search page is displayed")
    public void verifyTrainSearchPageIsDisplayed() {
        Assert.assertTrue(trainSearchPage.isTrainSearchPageDisplayed());
    }

    @When("user clicks on from station tab")
    public void userClicksOnFromStationTab() {
        trainSearchPage.clickOnFromStation();
    }

    @Then("user selects station {string}")
    public void userSelectsStation(String cityStation) {
        trainSearchPage.selectStation(cityStation);
    }

    @When("user clicks on to station tab")
    public void userClicksOnToStationTab() {
        trainSearchPage.clickOnToStation();
    }

    @Then("user enters city {string}")
    public void userEntersCity(String city) {
        trainSearchPage.enterStationCity(city);
    }

    @When("user selects departure date {string}")
    public void userSelectsDepartureDate(String date) {
        trainSearchPage.selectDate(date);
    }

    @When("user clicks on departure date")
    public void userClicksOnDepartureDate() {
        trainSearchPage.clickOnDepartureDate();

    }

    @And("user selects class {string}")
    public void userSelectsClass(String trainClass) {
        trainSearchPage.selectTrainClass(trainClass);
    }

    @Then("user clicks on show trains button")
    public void userClicksOnShowTrainsButton() {
        trainSearchPage.clickOnShowTrains();
    }
}
