package com.automation.steps;

import com.automation.pages.ui.CabListingPage;
import com.automation.pages.web.WebCabListingPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CabListingSteps {

    CabListingPage cabListingPage = new WebCabListingPage();


    @Then("verify user is on cab listing page")
    public void verifyUserIsOnCabListingPage() {
        Assert.assertTrue(cabListingPage.isCabListingPageDisplayed());
    }
}
