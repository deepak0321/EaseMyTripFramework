package com.automation.pages.web;

import com.automation.pages.ui.BusTravellersDetailsPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class WebBusTravellersDetailsPage extends WebBasePage implements BusTravellersDetailsPage {

    @FindBy(xpath = "//select[@id='title0']")
    WebElement titleOptions;

    @FindBy(xpath = "//input[@id='firstname0']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname0']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='age0']")
    WebElement ageInput;

    @FindBy(xpath = "//input[@id='TrvlMobileNo']")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//input[@id='continueOrg']")
    WebElement continueBookingBtn;

    String TRIP_INSURANCE_XPATH = "//div[@class='insur-%s']//input";

    @FindBy(xpath = "//input[@id='trvlEmail']")
    WebElement emailInput;

    @FindBy(xpath = "//div[@class='con']//span")
    WebElement continueBtn;


    @FindBy(xpath = "//div[@class='main-pymnt-bx']")
    WebElement paymentOptions;

    public void selectTripInsurance(String value){

        driver.findElement(By.xpath(String.format(TRIP_INSURANCE_XPATH, ConfigReader.getConfigValue(value)))).click();

    }

    public void enterEmail(String email){
        emailInput.sendKeys(ConfigReader.getConfigValue(email));
    }

    public void clickOnContinue(){
        continueBtn.click();
    }

    public boolean isPaymentOptionsDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(paymentOptions));
        return paymentOptions.isDisplayed();
    }



    public void enterUserDetails(String title,String firstName,String lastName,String age,String mobileNumber){

        Select select = new Select(titleOptions);
        select.selectByValue(ConfigReader.getConfigValue(title));

        firstNameInput.sendKeys(ConfigReader.getConfigValue(firstName));
        lastNameInput.sendKeys(ConfigReader.getConfigValue(lastName));
        ageInput.sendKeys(ConfigReader.getConfigValue(age));
        mobileNumberInput.sendKeys(ConfigReader.getConfigValue(mobileNumber));



    }

    public void clickOnContinueBooking(){
        continueBookingBtn.click();
    }

    public boolean isBusTravellersDetailsPageDisplayed(){

        return emailInput.isDisplayed();
    }


}
