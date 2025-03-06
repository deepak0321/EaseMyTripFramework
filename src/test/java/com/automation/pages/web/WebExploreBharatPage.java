package com.automation.pages.web;

import com.automation.pages.ui.ExploreBharatPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebExploreBharatPage extends WebBasePage implements ExploreBharatPage {

    @FindBy(xpath = "//div[@id='exp']//div[@class='btitle']")
    WebElement title;

    @FindBy(xpath = "//button[@class='owl-next']")
    WebElement nextBtn;

    @FindBy(xpath = "//div[@class='owl-item active']//p[@class='ttl']")
    List<WebElement> activities;

    @FindBy(xpath = "//div[@class='custom_heading']")
    WebElement activityDetailTitle;

    @FindBy(xpath = "//span[@class='sr_dy']")
    List<WebElement> activityDetails;

    public boolean isExploreBharatPageDisplayed() {
        return title.isDisplayed();
    }

    public void selectActivity(String input) {

        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", title);

        outerLoop:
        while (true) {
            for (WebElement activity : activities) {
                if (activity.getText().equalsIgnoreCase(ConfigReader.getConfigValue(input))) {
                    activity.click();
                    break outerLoop;
                }
            }
            pause(1000);
            javascriptExecutor(nextBtn);
            activities = driver.findElements(By.xpath("//div[@class='owl-item active']//p[@class='ttl']"));
        }
    }

    public boolean isActivityDetailsDisplayed() {
        return activityDetailTitle.isDisplayed();
    }

    public void printDetails() {
        System.out.println(activityDetailTitle.getText());
        for (WebElement detail : activityDetails) {
            System.out.println(detail.getText());
        }
    }
}
