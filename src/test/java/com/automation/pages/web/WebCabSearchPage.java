package com.automation.pages.web;

import com.automation.pages.ui.CabSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    String SELECT_LOCATION_XPATH = "//div[@class='auto_sugg_tttl' and contains(text(),'%s')]";

    @FindBy(xpath = "//div[@id='destinationName']")
    WebElement destinationName;

    @FindBy(xpath = "//input[@id='a_ToSector_show']")
    WebElement destinationNameInput;

    @FindBy(xpath = "//input[@id='datepicker']")
    WebElement datePicker;

    @FindBy(xpath = "//input[@id='SlfDrivdatepicker']")
    WebElement selfDriveDatePicker;

    @FindBy(xpath = "//span[@class='ui-datepicker-month']")
    WebElement datePickerMonth;

    @FindBy(xpath = "//span[@class='ui-datepicker-year']")
    WebElement datePickerYear;

    @FindBy(xpath = "//a[@data-handler='next']")
    WebElement nextMonth;

    String DATE_XPATH = "//a[contains(@class,'ui-state-default') and text()='%s']";

    String MERIDIAN_XPATH = "//input[@id='%s']/following-sibling::label";

    String RETURN_MERIDIAN_XPATH = "//input[@id='r%s']/following-sibling::label";

    String SELF_DRIVE_MERIDIAN_XPATH = "//input[@id='SlfDriv%s']/following-sibling::label";

    String HOUR_XPATH = "//div[@id='hr']//li[%s]";

    String RETURN_HOUR_XPATH = "//div[@id='rhr']//li[%s]";

    String SELF_DRIVE_HOUR_XPATH = "//div[@id='SlfDrivhr']//li[%s]";

    String MINUTE_XPATH = "//div[@id='min']//li[%s]";

    String RETURN_MINUTE_XPATH = "//div[@id='rmin']//li[%s]";

    String SELF_DRIVE_MINUTE_XPATH = "//div[@id='SlfDrivmin']//li[%s]";

    @FindBy(xpath = "//div[@class='done_d']")
    List<WebElement> doneBtn;

    @FindBy(xpath = "//div[@class='srch-btn-c']")
    WebElement searchBtn;

    @FindBy(xpath = "//input[@id='rdbTravelTypeOther']/following-sibling::label")
    WebElement outStationOption;

    @FindBy(xpath = "//input[@id='rdbTravelTypeHourly']/following-sibling::label")
    WebElement hourlyOption;

    @FindBy(xpath = "//input[@id='rdbTravelTypeSelf']/following-sibling::label")
    WebElement selfDriveOption;

    @FindBy(xpath = "//div[@id='returnDate']")
    WebElement returnDateElement;

    @FindBy(xpath = "//div[@id='returndateTime']")
    WebElement returnDateOption;

    @FindBy(xpath = "//input[@id='SlfDrivrdatepicker']")
    WebElement sdReturnDatePicker;

    @FindBy(xpath = "//div[@id='rtimes']")
    WebElement rentalHours;

    String RENT_HOUR_XPATH = "//div[@id='addclsForRent']//li[contains(text(),'%s')]";

    @FindBy(xpath = "//select[@id='age']")
    WebElement ageDropdown;

    @FindBy(xpath = "//select[@id='LiveIn']")
    WebElement countryDropdown;

    @FindBy(xpath = "//div[@id='SlfDrivsourceName']")
    WebElement selfDriveSourceElement;

    @FindBy(xpath = "//input[@id='a_FromSector_showSlfDrive']")
    WebElement selfDriveSourceInput;

    String SELF_DRIVE_RETURN_MERIDIAN_PATH = "//div[@id='SlfDrivReturnrap']//label[@for='r%s']";

    String SELF_DRIVE_RETURN_HOUR_XPATH = "//div[@id='SlfDrivrhr']//li[%s]";

    String SELF_DRIVE_RETURN_MINUTE_XPATH = "//div[@id='SlfDrivrmin']//li[%s]";

    @FindBy(xpath = "//div[@id='SelfDriveSearch']//div[@class='srch-btn-c']")
    WebElement sdSearchBtn;


    public boolean isCabSearchPageDisplayed() {
        return cabHeaderText.isDisplayed();
    }

    public void selectCabBookingType(String cabBookingType) {
        if (cabBookingType.equalsIgnoreCase("Airport Drop")) {
            airportOptions.click();
            driver.findElement(By.xpath(String.format(AIRPORT_OPTION_XPATH, "drop"))).click();
        } else if (cabBookingType.equalsIgnoreCase("Outstation")) {
            outStationOption.click();
        } else if (cabBookingType.equalsIgnoreCase("Hourly")) {
            hourlyOption.click();
        } else if (cabBookingType.equalsIgnoreCase("Self Drive")) {
            selfDriveOption.click();
        }
    }

    public void enterPickupLocation(String pickUpLocation) {

        if (pickUpLocation.endsWith("SD")) {
            enterSelfDrivePickupLocation(pickUpLocation);
            return;
        }
        sourceName.click();
        sourceNameInput.sendKeys(pickUpLocation);
        pause(2000);
        driver.findElement(By.xpath(String.format(SELECT_LOCATION_XPATH, pickUpLocation))).click();
    }

    public void enterSelfDrivePickupLocation(String pickUpLocation) {
        String location = pickUpLocation.substring(0, pickUpLocation.length() - 3);
        selfDriveSourceElement.click();
        selfDriveSourceInput.sendKeys(location,Keys.BACK_SPACE);
        pause(3000);
        driver.findElement(By.xpath(String.format(SELECT_LOCATION_XPATH, location))).click();
    }

    public void enterDropLocation(String dropLocation) {
        if (dropLocation.endsWith("SD")) {
            return;
        }
        destinationName.click();
        destinationNameInput.sendKeys(dropLocation);
        pause(5000);
        driver.findElement(By.xpath(String.format(SELECT_LOCATION_XPATH, dropLocation))).click();

    }

    public void selectPickupDateAndTime(String date, String time) {

        if (date.endsWith("SD")) {
            selectSelfDrivePickupDate(date, time);
            return;
        }
        datePicker.click();
        String[] dateParts = date.split(" ");

        while (!datePickerMonth.getText().equalsIgnoreCase(dateParts[1]) || !datePickerYear.getText().equalsIgnoreCase(dateParts[2])) {
            nextMonth.click();
        }
        driver.findElement(By.xpath(String.format(DATE_XPATH, dateParts[0]))).click();

        String[] timeParts = timeSplitter(time);
        driver.findElement(By.xpath(String.format(HOUR_XPATH, timeParts[0]))).click();
        driver.findElement(By.xpath(String.format(MINUTE_XPATH, timeParts[1]))).click();
        driver.findElement(By.xpath(String.format(MERIDIAN_XPATH, timeParts[2]))).click();
        doneBtn.getFirst().click();
    }

    public void selectSelfDrivePickupDate(String date, String time) {
        selfDriveDatePicker.click();
        String sdDate = date.substring(0, date.length() - 3);
        String sdTime = time.substring(0, time.length() - 3);
        String[] dateParts = sdDate.split(" ");

        while (!datePickerMonth.getText().equalsIgnoreCase(dateParts[1]) || !datePickerYear.getText().equalsIgnoreCase(dateParts[2])) {
            nextMonth.click();
        }
        driver.findElement(By.xpath(String.format(DATE_XPATH, dateParts[0]))).click();

        String[] timeParts = timeSplitter(sdTime);
        driver.findElement(By.xpath(String.format(SELF_DRIVE_MERIDIAN_XPATH, timeParts[2]))).click();
        driver.findElement(By.xpath(String.format(SELF_DRIVE_HOUR_XPATH, timeParts[0]))).click();
        driver.findElement(By.xpath(String.format(SELF_DRIVE_MINUTE_XPATH, timeParts[1]))).click();
        doneBtn.get(2).click();
    }

    public void selectReturnDateAndTime(String date, String time) {

        if (date.endsWith("SD")) {
            selectSelfDriveReturnDateAndTime(date, time);
            return;
        }

        returnDateElement.click();
        returnDateOption.click();
        String[] returnDateParts = date.split(" ");

        while (!datePickerMonth.getText().equalsIgnoreCase(returnDateParts[1]) || !datePickerYear.getText().equalsIgnoreCase(returnDateParts[2])) {
            nextMonth.click();
        }
        driver.findElement(By.xpath(String.format(DATE_XPATH, returnDateParts[0]))).click();


        String[] timeParts = timeSplitter(time);

        driver.findElement(By.xpath(String.format(RETURN_MERIDIAN_XPATH, timeParts[2]))).click();
        driver.findElement(By.xpath(String.format(RETURN_HOUR_XPATH, timeParts[0]))).click();
        driver.findElement(By.xpath(String.format(RETURN_MINUTE_XPATH, timeParts[1]))).click();
        doneBtn.get(1).click();

    }

    public void selectSelfDriveReturnDateAndTime(String date, String time) {
        sdReturnDatePicker.click();
        String sdDate = date.substring(0, date.length() - 3);
        String sdTime = time.substring(0, time.length() - 3);
        String[] dateParts = sdDate.split(" ");

        while (!datePickerMonth.getText().equalsIgnoreCase(dateParts[1]) || !datePickerYear.getText().equalsIgnoreCase(dateParts[2])) {
            nextMonth.click();
        }
        driver.findElement(By.xpath(String.format(DATE_XPATH, dateParts[0]))).click();

        String[] timeParts = timeSplitter(sdTime);
        driver.findElement(By.xpath(String.format(SELF_DRIVE_RETURN_MERIDIAN_PATH, timeParts[2]))).click();
        driver.findElement(By.xpath(String.format(SELF_DRIVE_RETURN_HOUR_XPATH, timeParts[0]))).click();
        driver.findElement(By.xpath(String.format(SELF_DRIVE_RETURN_MINUTE_XPATH, timeParts[1]))).click();
        doneBtn.get(3).click();
    }

    public void selectRentalHours(String hours) {
        rentalHours.click();
        driver.findElement(By.xpath(String.format(RENT_HOUR_XPATH, hours))).click();
    }

    public void selectAge(String age) {
        Select select = new Select(ageDropdown);
        select.selectByVisibleText(age);

    }

    public void selectCountry(String country) {
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
    }


    public void clickOnSearchBtn() {
        if (sdSearchBtn.isDisplayed()) {
            sdSearchBtn.click();
            return;
        }
        searchBtn.click();
    }


}
