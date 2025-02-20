package com.automation.pages.web;

import com.automation.pages.ui.CabSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebCabSearchPage extends WebBasePage implements CabSearchPage {

    @FindBy(xpath = "//h1[text()='Book Online Cab']")
    WebElement cabHeaderText;

    @FindBy(xpath = "//div[@id='airport']")
    WebElement airportOptions;

    String AIRPORT_OPTION_XPATH = "//li[@id='%s']";

    @FindBy(xpath = "//div[@id='sourceName']")
    WebElement sourceName;

    @FindBy(xpath = "//input[@id='a_FromSector_show']")
    WebElement sourceNameInput;

    @FindBy(xpath = "//div[@id='StartCity']//li")
    WebElement source;

    @FindBy(xpath = "//div[@id='destinationName']")
    WebElement destinationName;

    @FindBy(xpath = "//input[@id='a_ToSector_show']")
    WebElement destinationNameInput;

    @FindBy(xpath = "//div[@id='EndCity']//li")
    WebElement destination;

    @FindBy(xpath = "//input[@id='datepicker']")
    WebElement datePicker;

    @FindBy(xpath = "//span[@class='ui-datepicker-month']")
    WebElement datePickerMonth;

    @FindBy(xpath = "//span[@class='ui-datepicker-year']")
    WebElement datePickerYear;

    @FindBy(xpath = "//a[@data-handler='next']")
    WebElement nextMonth;

    String DATE_XPATH = "//a[contains(@class,'ui-state-default') and text()='%s']";

    String MERIDIAN_XPATH = "//input[@id='%s']/following-sibling::label";

    String HOUR_XPATH = "//div[@id='hr']//li[%s]";

    String MINUTE_XPATH = "//div[@id='min']//li[%s]";

    @FindBy(xpath = "//div[@class='done_d']")
    WebElement doneBtn;

    @FindBy(xpath = "//div[@class='srch-btn-c']")
    WebElement searchBtn;
    
    @FindBy(xpath = "//input[@id='rdbTravelTypeOther']/following-sibling::label")
    WebElement outStationOption;

    @FindBy(xpath = "//input[@id='rdbTravelTypeHourly']/following-sibling::label")
    WebElement hourlyOption;

    @FindBy(xpath = "//input[@id='rdbTravelTypeSelf']/following-sibling::label")
    WebElement selfDriveOption;

    @FindBy(xpath = "//div[@id='returnDate']")
    WebElement returnDateOption;


    public boolean isCabSearchPageDisplayed(){
        return cabHeaderText.isDisplayed();
    }

    public void selectCabBookingType(String cabBookingType){
        if(cabBookingType.equalsIgnoreCase("Airport Drop")){
            airportOptions.click();
            driver.findElement(By.xpath(String.format(AIRPORT_OPTION_XPATH,"drop"))).click();
        } else if (cabBookingType.equalsIgnoreCase("Outstation")) {
            outStationOption.click();
        } else if (cabBookingType.equalsIgnoreCase("Hourly")) {
            hourlyOption.click();
        } else if (cabBookingType.equalsIgnoreCase("Self Drive")) {
            selfDriveOption.click();
        }
    }

    public void enterPickupLocation(String pickUpLocation){
        sourceName.click();
        sourceNameInput.sendKeys(pickUpLocation);
        pause(3000);
        source.click();
    }

    public void enterDropLocation(String dropLocation){
        destinationName.click();
        destinationNameInput.sendKeys(dropLocation);
        pause(3000);
        destination.click();
    }

    public void selectPickupDateAndTime(String date, String time) {

        datePicker.click();
        String[] dateParts = date.split(" ");

        while(!datePickerMonth.getText().equalsIgnoreCase(dateParts[1]) || !datePickerYear.getText().equalsIgnoreCase(dateParts[2])){
            nextMonth.click();
        }
        driver.findElement(By.xpath(String.format(DATE_XPATH,dateParts[0]))).click();

        String[] timeParts = timeSplitter(time);
        driver.findElement(By.xpath(String.format(HOUR_XPATH,timeParts[0]))).click();
        driver.findElement(By.xpath(String.format(MINUTE_XPATH,timeParts[1]))).click();
        driver.findElement(By.xpath(String.format(MERIDIAN_XPATH,timeParts[2]))).click();
    }

    public void selectReturnDateAndTime(String date,String time) {

        returnDateOption.click();


    }



    public void clickOnSearchBtn(){
        searchBtn.click();
    }





}
