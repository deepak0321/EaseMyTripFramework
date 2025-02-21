package com.automation.pages.web;


import com.automation.pages.ui.TrainSearchPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTrainSearchPage extends WebBasePage implements TrainSearchPage {


    @FindBy(xpath = "//input[@id='txtfromcity']")
    WebElement fromCityElement;

    String CITY_XPATH = "//li[@class='ui-menu-item']//div[contains(text(),'%s')]";


    @FindBy(xpath = "//input[@id='txtdesticity']")
    WebElement toCityElement;

    @FindBy(xpath = "//input[@id='txtDate']")
    WebElement datePicker;

    @FindBy(xpath = "//span[@class='ui-datepicker-month']")
    List<WebElement> datePickerMonth;

    @FindBy(xpath = "//h1[text()='Book Train Tickets']")
    WebElement bookTrainTicketsText;

    @FindBy(xpath = "//a[@data-handler='next']//span")
    WebElement nextMonth;

    String DATE_XPATH = "//td[@data-month='%s']//a[@class='ui-state-default' and contains(text(),'%s')]";

    @FindBy(xpath = "//input[@id='SearchAll']")
    WebElement searchTrainsBtn;


    public void enterDepartureCity(String departureCity) {
        fromCityElement.click();
        fromCityElement.sendKeys(ConfigReader.getConfigValue(departureCity));
    }

    public void selectCity(String cityStation) {
        driver.findElement(By.xpath(String.format(CITY_XPATH, ConfigReader.getConfigValue(cityStation)))).click();
    }

    public void enterArrivalCity(String arrivalCity) {
        toCityElement.click();
        toCityElement.sendKeys(ConfigReader.getConfigValue(arrivalCity));
    }

    public boolean isTrainSearchPageDisplayed() {
        return bookTrainTicketsText.isDisplayed();
    }

    public void clickOnShowTrains() {
        searchTrainsBtn.click();
    }

    public void selectDepartureDate(String departureDate) {

        datePicker.click();
        String[] dateParts = parseDate(ConfigReader.getConfigValue(departureDate));
        boolean firstCalendarView = datePickerMonth.getFirst().getText().equalsIgnoreCase(dateParts[1]);
        boolean secondCalendarView = datePickerMonth.getLast().getText().equalsIgnoreCase(dateParts[1]);
        while (!firstCalendarView && !secondCalendarView) {
            firstCalendarView = datePickerMonth.getFirst().getText().equalsIgnoreCase(dateParts[1]);
            secondCalendarView = datePickerMonth.getLast().getText().equalsIgnoreCase(dateParts[1]);
            nextMonth.click();
        }
        if (firstCalendarView) {
            driver.findElement(By.xpath(String.format(DATE_XPATH, "1", dateParts[0]))).click();
        } else {
            driver.findElement(By.xpath(String.format(DATE_XPATH, "2", dateParts[0]))).click();
        }

    }

}
