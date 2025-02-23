package com.automation.pages.web;

import com.automation.pages.ui.BusSearchPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebBusSearchPage extends WebBasePage implements BusSearchPage {

    @FindBy(xpath = "//h1[contains(text(), 'Online Bus Tickets')]")
    WebElement onlineBusTicketsText;

    @FindBy(xpath = "//input[@id='txtSrcCity']")
    WebElement fromCity;

    @FindBy(xpath = "//div[@class='auto-sugg-pre']/ul/li")
    WebElement selectCity;

    @FindBy(xpath = "//input[@id='txtDesCity']")
    WebElement toCity;

    @FindBy(xpath = "//input[@id='datepicker']")
    WebElement datePicker;

    @FindBy(xpath = "//span[@class='ui-datepicker-month']")
    WebElement datePickerMonth;

    @FindBy(xpath = "//a[@data-handler='next']")
    WebElement nextMonth;

    String DATE_XPATH = "//a[contains(@class,'ui-state-default') and text()='%s']";

    @FindBy(xpath = "//input[@id='srcbtn']")
    WebElement searchBtn;

    public boolean isBusSearchPageDisplayed() {
        return onlineBusTicketsText.isDisplayed();
    }

    public void enterBusDetails(String from, String to, String date) {

        fromCity.sendKeys(ConfigReader.getConfigValue(from));
        pause(2000);
        selectCity.click();

        toCity.sendKeys(ConfigReader.getConfigValue(to));
        pause(2000);
        selectCity.click();

        datePicker.click();
        String givenDate = ConfigReader.getConfigValue(date);
        String[] dateParts = givenDate.split(" ");
        while (!datePickerMonth.getText().equalsIgnoreCase(dateParts[1])) {
            nextMonth.click();
        }
        driver.findElement(By.xpath(String.format(DATE_XPATH, dateParts[0]))).click();
    }

    public void clickOnSearchBtn() {
        searchBtn.click();
    }


}
