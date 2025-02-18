package com.automation.pages.android;

import com.automation.pages.ui.BusTravellersDetailsPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidBusTravellersDetailsPage extends AndroidBasePage implements BusTravellersDetailsPage {

    @FindBy(id = "com.easemytrip.android:id/llToolBar")
    WebElement busTravellerDetailsPageToolbar;

    String GENDER_XPATH ="//android.widget.RadioButton[@resource-id=\"com.easemytrip.android:id/rb_%s\"]";

    @FindBy(id = "com.easemytrip.android:id/input_first_name")
    WebElement firstNameInput;

    @FindBy(id = "com.easemytrip.android:id/input_last_name")
    WebElement lastNameInput;

    @FindBy(id = "com.easemytrip.android:id/input_age")
    WebElement ageInput;

    @FindBy(id = "com.easemytrip.android:id/promo_tv")
    WebElement promoText;

    @FindBy(id = "com.easemytrip.android:id/input_mobile")
    WebElement mobileNumberInput;

    @FindBy(id = "com.easemytrip.android:id/input_email")
    WebElement emailInput;

    String INSURANCE_OPTION_XPATH = "//android.widget.RadioButton[@resource-id=\"com.easemytrip.android:id/radioButton_%s\"]";

    @FindBy(id = "com.easemytrip.android:id/button_paymentbooking")
    WebElement continueBookingBtn;

    @FindBy(id = "com.easemytrip.android:id/payment_heading")
    WebElement paymentOptionsHeader;




    public void selectTripInsurance(String value) {

        while(!isDisplayed(emailInput))
            scrollUp();
        String insuranceOption = ConfigReader.getConfigValue(value).equalsIgnoreCase("Yes")?"yes":"no";
        driver.findElement(By.xpath(String.format(INSURANCE_OPTION_XPATH,insuranceOption))).click();

    }

    public void enterEmail(String email) {
        emailInput.sendKeys(ConfigReader.getConfigValue(email));
    }

    public void clickOnContinue() {

        //Empty method since it's not needed in mobile

    }

    public boolean isPaymentOptionsDisplayed() {
        return paymentOptionsHeader.isDisplayed();
    }

    public void enterUserDetails(String title, String firstName, String lastName, String age, String mobileNumber) {

        scrollDown();
        String genderValue = ConfigReader.getConfigValue(title).equalsIgnoreCase("Mr") ? "male" : "mrs";
        driver.findElement(By.xpath(String.format(GENDER_XPATH,genderValue))).click();

        firstNameInput.sendKeys(ConfigReader.getConfigValue(firstName));
        lastNameInput.sendKeys(ConfigReader.getConfigValue(lastName));
        ageInput.sendKeys(ConfigReader.getConfigValue(age));
        while (!isDisplayed(promoText)){
            scrollUp();
        }
        mobileNumberInput.sendKeys(ConfigReader.getConfigValue(mobileNumber));

    }

    public void clickOnContinueBooking() {
        continueBookingBtn.click();
    }


    public boolean isBusTravellersDetailsPageDisplayed() {
        return busTravellerDetailsPageToolbar.isDisplayed();
    }
}
