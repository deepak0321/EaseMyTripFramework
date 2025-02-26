package com.automation.steps;

import com.automation.pages.web.WebChatbotPage;
import com.automation.pages.web.WebHomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChatbotSteps {

    WebHomePage homePage = new WebHomePage();
    WebChatbotPage WebChatbotPage = new WebChatbotPage();


    @When("user clicks on the chatbot icon")
    public void userClicksOnTheChatbotIcon() {
        homePage.clickOnChatbotIcon();
    }

    @Then("verify chatbot pop-up is displayed")
    public void verifyChatbotPopUpIsDisplayed() {
        Assert.assertTrue(WebChatbotPage.isChatbotDisplayed());
    }

    @When("user selects {string} from the available options")
    public void userSelectsFromTheAvailableOptions(String option) {
        WebChatbotPage.selectOption(option);
    }

    @And("selects {string} for query number available option")
    public void selectsForQueryNumberAvailableOption(String option) {
        WebChatbotPage.enterQueryNumber(option);
    }

    @Then("verify the chatbot asks for the details to book a holiday plan")
    public void verifyTheChatbotAsksForTheDetailsToBookAHolidayPlan() {
        Assert.assertTrue(WebChatbotPage.isChatbotAsksDetails());
    }

    @When("the user provides the details needed for booking a holiday plan")
    public void theUserProvidesTheDetailsNeededForBookingAHolidayPlan(DataTable dataTable) {
        WebChatbotPage.enterDetails(dataTable);
    }

    @Then("verify chatbot displays a confirmation message")
    public void verifyChatbotDisplaysAConfirmationMessage() {
        Assert.assertTrue(WebChatbotPage.isConfirmationDisplayed());
    }
}
