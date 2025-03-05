package com.automation.pages.android;

import com.automation.pages.ui.ActivitiesPage;
import com.automation.utils.ConfigReader;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AndroidActivityDetailPage extends AndroidBasePage implements ActivitiesPage {

    @FindBy(xpath = "//android.view.View[@resource-id='mainPg']/android.widget.TextView[1]")
    WebElement title;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='selectedDate']/following-sibling::android.widget.Image[@text=\"Drop arrow icon\"][1]")
    WebElement selectDateBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='selectedTime']")
    WebElement selectTimeBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='trvlrPlaceholerOuter']")
    WebElement selectTravelersBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='traveldateTxt']")
    WebElement selectTab;

    @FindBy(xpath = "//android.view.View[@resource-id='_timeslots']")
    WebElement selectTimeTab;

    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text]")
    List<WebElement> timeSlots;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='youthCnt']")
    WebElement adultCountTab;

    @FindBy(xpath = "//android.widget.Button[@resource-id='add']")
    WebElement addAdultBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='Done']")
    WebElement doneBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='Select']")
    WebElement selectBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='BOOK NOW']")
    WebElement bookNowBtn;

    String DATE_XPATH = "//android.widget.TextView[@text='May 2025']/following-sibling::android.widget.ListView//android.widget.TextView[@text='%s']";

    public boolean isActivityDetailPageDisplayed() {
        System.out.println(title.getText());
        return title.isDisplayed();
    }

    public void selectDate(String inputDate) {

        wait.until(ExpectedConditions.elementToBeClickable(selectDateBtn));
        //javascriptExecutor(selectDateBtn);

        selectTab.click();
        while (!isDisplayed(String.format(DATE_XPATH, ConfigReader.getConfigValue(inputDate)))) {
            scrollDown();
        }

        driver.findElement(By.xpath(String.format(DATE_XPATH, ConfigReader.getConfigValue(inputDate)))).click();
    }

    public void selectTime() {
        selectTimeTab.click();
        timeSlots.get(1).click();
    }

    public void addPeople(String adultCount) {

        adultCountTab.click();
        for (int i = 1; i < Integer.parseInt(ConfigReader.getConfigValue(adultCount)); ++i) {
            addAdultBtn.click();
        }
        doneBtn.click();
        selectBtn.click();
    }

    public void clickOnBookNowBtn() {
        bookNowBtn.click();
    }
}
