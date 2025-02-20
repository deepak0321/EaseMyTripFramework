package com.automation.steps;

import com.automation.pages.android.AndroidCabListingPage;
import com.automation.pages.ui.CabListingPage;
import com.automation.pages.web.WebCabListingPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CabListingSteps {

    CabListingPage cabListingPage ;

    public CabListingSteps(){
        if(ConfigReader.getConfigValue("application.type").equalsIgnoreCase("Web")){
            cabListingPage = new WebCabListingPage();
        }else
            cabListingPage = new AndroidCabListingPage();
    }
    @Then("verify user is on cab listing page")
    public void verifyUserIsOnCabListingPage() {
        Assert.assertTrue(cabListingPage.isCabListingPageDisplayed());
    }
}
