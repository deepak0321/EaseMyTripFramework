package com.automation.pages.android;

import com.automation.pages.ui.ExploreBharatPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidExploreBharatPage extends AndroidBasePage implements ExploreBharatPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvSearchTittle']")
    WebElement title;

    @FindBy(xpath = "//android.view.View[@resource-id='exp']/android.view.View[2]/android.view.View[2]/android.widget.Button[2]")
    WebElement nextBtn;

    @FindBy(xpath = "//android.widget.Image[@text]/following-sibling::android.widget.TextView[1]")
    WebElement activity;

    @FindBy(xpath = "//android.view.View[@resource-id='tab1']/android.widget.TextView")
    WebElement activityTitle;

    @FindBy(xpath = "//android.widget.Image[@text='logo']")
    WebElement end;

    @FindBy(xpath = "//android.view.View[@resource-id='tab1']/android.view.View/android.widget.TextView")
    WebElement activityDetailTitle;

    public boolean isExploreBharatPageDisplayed() {
        return title.isDisplayed();
    }

    public void selectActivity(String input) {

        while(!isPresent(activity)) {
            scroll();
        }
        if (activity.getLocation().getY() > dimension.getHeight()/2) {
            scroll();
        }
        while (true) {
            if (activity.getText().equalsIgnoreCase(ConfigReader.getConfigValue(input))) {
                activity.click();
                break;
            } else {
                nextBtn.click();
                pause(1000);
                activity = driver.findElement(By.xpath("//android.widget.Image[@text]/following-sibling::android.widget.TextView[1]"));
            }
        }
    }

    public boolean isActivityDetailsDisplayed() {
        return activityTitle.isDisplayed();
    }

    public void printDetails() {
        while(true) {
            scroll();
            if (isPresent(driver.findElement(By.xpath("//android.view.View[@resource-id='tab1']/android.widget.TextView")))) {
                System.out.println(activityDetailTitle.getText());
                activity = driver.findElement(By.xpath("//android.view.View[@resource-id='tab1']/android.widget.TextView"));
            }
        }
    }


}
