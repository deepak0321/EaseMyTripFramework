package com.automation.steps;

import com.automation.pages.web.WebHolidaysPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HolidaysSteps {

    WebHolidaysPage holidayPage = new WebHolidaysPage();

    @Then("verify holidays page is displayed")
    public void verifyHolidaysPageIsDisplayed() {
        Assert.assertTrue(holidayPage.isHolidayPageDisplayed());
    }

    @When("user enters {string} and clicks on search button")
    public void user_enters_and_clicks_on_search_button(String destination) {
        holidayPage.searchCity(destination);
    }
}
