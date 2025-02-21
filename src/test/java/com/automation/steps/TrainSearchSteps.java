package com.automation.steps;

import com.automation.pages.android.AndroidTrainSearchPage;
import com.automation.pages.ui.TrainSearchPage;
import com.automation.pages.web.WebTrainSearchPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TrainSearchSteps {

    TrainSearchPage trainSearchPage;

    public TrainSearchSteps() {
        if (ConfigReader.getConfigValue("application.type").equalsIgnoreCase("Web")) {
            trainSearchPage = new WebTrainSearchPage();
        } else
            trainSearchPage = new AndroidTrainSearchPage();
    }


    @Then("verify the user is on the train search page")
    public void verifyTheUserIsOnTheTrainSearchPage() {
        Assert.assertTrue(trainSearchPage.isTrainSearchPageDisplayed());
    }

    @When("the user enters the departure city as {string}")
    public void theUserEntersTheDepartureCityAs(String departureCity) {
        trainSearchPage.enterDepartureCity(departureCity);
    }

    @And("the user enters the arrival city as {string}")
    public void theUserEntersTheArrivalCityAs(String arrivalCity) {
        trainSearchPage.enterArrivalCity(arrivalCity);
    }

    @Then("the user selects the departure date as {string}")
    public void theUserSelectsTheDepartureDateAs(String departureDate) {
        trainSearchPage.selectDepartureDate(departureDate);
    }


    @When("the user clicks on the show trains button")
    public void theUserClicksOnTheShowTrainsButton() {
        trainSearchPage.clickOnShowTrains();
    }


    @Then("the user selects the departure station {string}")
    public void theUserSelectsTheDepartureStation(String departureStation) {
        trainSearchPage.selectCity(departureStation);
    }

    @Then("the user selects the arrival station {string}")
    public void theUserSelectsTheArrivalStation(String arrivalStation) {
        trainSearchPage.selectCity(arrivalStation);
    }
}
