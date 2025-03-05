package com.automation.pages.web;

import com.automation.pages.ui.ActivitiesPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WebActivityDetailPage extends WebBasePage implements ActivitiesPage {

    @FindBy(xpath = "//h1[@class='f23']")
    WebElement title;

    @FindBy(id = "traveldateTxt")
    WebElement dateBtn;

    @FindBy(xpath = "//div[@class='ruppes']/preceding-sibling::span")
    List<WebElement> dates;

    @FindBy(id = "tslVal")
    WebElement selectTimeTab;

    @FindBy(xpath = "//ul[@id='timeslots']/li")
    List<WebElement> timeSlots;

    @FindBy(id = "shwtraveler")
    WebElement selectTravelersTab;

    @FindBy(id = "adultadd")
    WebElement addAdultBtn;

    @FindBy(xpath = "//a[@class='dn_btn']")
    WebElement doneBtn;

    @FindBy(xpath = "//div[@class='bkng_b']/a")
    WebElement bookNowBtn;


    public boolean isActivityDetailPageDisplayed() {
        System.out.println(title.getText());
        return title.isDisplayed();
    }

    public void selectDate(String inputDate) {
        pause(5000);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='ldr_cnt']"))));
        dateBtn.click();

        for (WebElement date : dates) {
            if (date.getText().equalsIgnoreCase(ConfigReader.getConfigValue(inputDate))) {
                date.click();
                break;
            }
        }
    }

    public void selectTime() {
        selectTimeTab.click();

        timeSlots.getFirst().click();
    }

    public void addPeople(String adultCount) {
        selectTravelersTab.click();

        for (int i=1;i<Integer.parseInt(ConfigReader.getConfigValue(adultCount));++i) {
            addAdultBtn.click();
        }
        doneBtn.click();
    }

    public void clickOnBookNowBtn() {
        bookNowBtn.click();
    }
}
