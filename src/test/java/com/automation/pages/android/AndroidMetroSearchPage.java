package com.automation.pages.android;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidMetroSearchPage extends AndroidBasePage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.easemytrip.android:id/nav_label\" and @text=\"Metro\"]")
    WebElement metroTab;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.easemytrip.android:id/tvSourceName\"]")
    WebElement metroDepartFrom;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.easemytrip.android:id/edtSearch\"]")
    WebElement stationNameInput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.easemytrip.android:id/tvDestinationName\"]")
    WebElement metroDestination;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.easemytrip.android:id/stationNameTV\"]")
    WebElement selectStation;


    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.easemytrip.android:id/tvPlus\"]")
    WebElement addPassengerBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.easemytrip.android:id/tvTotalCount\"]")
    WebElement passengerCount;

    @FindBy(id = "com.easemytrip.android:id/accept_term_and_condition")
    WebElement acceptTC;

    @FindBy(id = "com.easemytrip.android:id/tvProceed")
    WebElement proceedToPayBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.easemytrip.android:id/txt_line\" and @text=\"Line 2\"]")
    WebElement metroLine2;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.easemytrip.android:id/etEmailId\"]")
    WebElement emailInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.easemytrip.android:id/etMobileNo\"]")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.easemytrip.android:id/tv_verify\"]")
    WebElement verifyAndPayBtn;

    @FindBy(id = "com.easemytrip.android:id/btnContinue")
    WebElement continueBtn;


    String METRO_XPATH = "//android.widget.TextView[@resource-id=\"com.easemytrip.android:id/txt_city\" and @text=\"%s Metro\"]";

    String METRO_LINE_XPATH = "//android.widget.TextView[@resource-id=\"com.easemytrip.android:id/txt_line\" and @text=\"Line %s\"]";


    public boolean isMetroSearchPageDisplayed() {
        return metroTab.getAttribute("selected").equals("true");
    }

    public void selectMetro(String metroLocation) {
        driver.findElement(By.xpath(String.format(METRO_XPATH, ConfigReader.getConfigValue(metroLocation)))).click();
    }

    public void selectMetroLine(String line) {
        if (metroLine2.isDisplayed())
            driver.findElement(By.xpath(String.format(METRO_LINE_XPATH, ConfigReader.getConfigValue(line)))).click();
    }

    public void enterMetroDetails(String from, String to) {
        metroDepartFrom.click();
        stationNameInput.sendKeys(ConfigReader.getConfigValue(from));
        selectStation.click();

        metroDestination.click();
        stationNameInput.sendKeys(ConfigReader.getConfigValue(to));
        selectStation.click();
    }

    public void selectPassengers(String number) {
        while (!passengerCount.getText().equals(ConfigReader.getConfigValue(number)))
            addPassengerBtn.click();
    }

    public void acceptTC() {
        acceptTC.click();
    }

    public void clickOnProceedToPayButton() {
        proceedToPayBtn.click();
    }

    public void enterTravellerDetails(String email, String mobileNumber) {
        emailInput.sendKeys(ConfigReader.getConfigValue(email));
        mobileNumberInput.sendKeys(ConfigReader.getConfigValue(mobileNumber));
    }

    public void clickOnContinue() {
        continueBtn.click();
    }

    public boolean isPaymentSectionsDisplayed() {
        return verifyAndPayBtn.isDisplayed();
    }


}
