package com.automation.pages.android;

import com.automation.pages.ui.TrainListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidTrainListingPage extends AndroidBasePage implements TrainListingPage {

    @FindBy(id = "com.easemytrip.android:id/imEditIcon")
    List<WebElement> editBtn;

    public boolean isTrainListingPageDisplayed() {
        return editBtn.isEmpty();
    }
}
