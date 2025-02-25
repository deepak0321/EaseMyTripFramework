package com.automation.pages.web;

import com.automation.pages.ui.GiftCardPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class WebGiftCardPage extends WebBasePage implements GiftCardPage {


    @FindBy(xpath = "//button[text()='Occasional']")
    WebElement occasionalCategory;

    @FindBy(xpath = "//button[text()='Festival']")
    WebElement festivalCategory;

    @FindBy(xpath = "//button[text()='Loved Ones']")
    WebElement lovedOnesCategory;

    @FindBy(xpath = "//label[text()='Enter Denomination']/following-sibling::input")
    WebElement denominationInput;

    @FindBy(xpath = "//label[text()='Select Quantity ']/following-sibling::select")
    WebElement quantityInput;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']")
    WebElement datePicker;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    WebElement datePickerMonth;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    WebElement datePickerYear;

    @FindBy(xpath = "//label[text()='Sender details']/following-sibling::input")
    WebElement senderNameInput;

    @FindBy(xpath = "//input[@id='txtEmailId']")
    WebElement senderEmailInput;

    @FindBy(xpath = "(//input[contains(@placeholder,'mobile number')])[1]")
    WebElement senderMobileNumberInput;

    @FindBy(xpath = "//span[text()=' Same as sender details ']//input")
    WebElement isDetailsSame;

    @FindBy(xpath = "//input[@id='rcnm']")
    WebElement receiverNameInput;

    @FindBy(xpath = "//input[@id='rceml']")
    WebElement receiverEmailInput;

    @FindBy(xpath = "//input[@id='rcteml']")
    WebElement receiverEmailReEnterInput;

    @FindBy(xpath = "//input[@id='rcephn']")
    WebElement receiverMobileNumberInput;

    @FindBy(xpath = " //div[contains(text(),'accept')]//input[@type='checkbox']")
    WebElement acceptTC;

    @FindBy(xpath = "//div[@id='pny']")
    WebElement payNowButton;

    @FindBy(xpath = "//div[text()='Verify Now']")
    WebElement verifyNowButton;

    @FindBy(xpath = "//div[text()=' How to Redeem']")
    WebElement howToRedeemText;

    String DATE_XPATH = "//a[@class='ui-state-default' and text()='%s']";

    String DELIVERY_DATE_XPATH = "//input[@id='%s']";

    String TYPE_LOVED = "//div[@id=\"Loved\"]//div//img[@alt='%s Card']";

    String TYPE_FESTIVAL = "//div[@id=\"Festival\"]//div//img[@alt='%s Card']";

    String TYPE_OCCASIONAL = "//div[@id=\"Occational\"]//div//img[@alt='%s Card']";

    String TYPE_ALL = "//div[@id=\"Occational\"]//div//img[@alt='%s Card']";


    public void selectGiftCardCategory(String category) {
        if (ConfigReader.getConfigValue(category).equalsIgnoreCase("loved ones")) {
            lovedOnesCategory.click();
        } else if (ConfigReader.getConfigValue(category).equalsIgnoreCase("festival")) {
            festivalCategory.click();
        } else if (ConfigReader.getConfigValue(category).equalsIgnoreCase("occasion")) {
            occasionalCategory.click();
        }

    }

    public boolean isGiftCardPageDisplayed() {
        return occasionalCategory.isDisplayed() && festivalCategory.isDisplayed();
    }

    public void selectGiftCardType(String type) {
        String category = ConfigReader.getConfigValue("gift.card.category");
        if (category.equalsIgnoreCase("loved ones")) {
            if (ConfigReader.getConfigValue(type).equalsIgnoreCase("Wedding"))
                driver.findElement(By.xpath(String.format(TYPE_LOVED, "Holiday"))).click();
            else
                driver.findElement(By.xpath(String.format(TYPE_LOVED, ConfigReader.getConfigValue(type)))).click();
        } else if (category.equalsIgnoreCase("festival")) {
            driver.findElement(By.xpath(String.format(TYPE_FESTIVAL, ConfigReader.getConfigValue(type)))).click();
        } else if (category.equalsIgnoreCase("occasion")) {
            driver.findElement(By.xpath(String.format(TYPE_OCCASIONAL, ConfigReader.getConfigValue(type)))).click();
        } else {
            driver.findElement(By.xpath(String.format(TYPE_ALL, ConfigReader.getConfigValue(type)))).click();
        }

    }

    public void enterGiftCardDetails(String denomination, String quantity, String deliveryDate) {

        denominationInput.sendKeys(ConfigReader.getConfigValue(denomination));

        Select select = new Select(quantityInput);
        select.selectByValue(ConfigReader.getConfigValue(quantity));

        if (ConfigReader.getConfigValue(deliveryDate).equalsIgnoreCase("Today")) {
            driver.findElement(By.xpath(String.format(DELIVERY_DATE_XPATH, "tdy"))).click();
        } else
            driver.findElement(By.xpath(String.format(DELIVERY_DATE_XPATH, "ltr"))).click();

    }

    public void enterSenderDetails(String name, String email, String mobileNumber) {

        senderNameInput.sendKeys(ConfigReader.getConfigValue(name));
        senderEmailInput.sendKeys(ConfigReader.getConfigValue(email));
        senderMobileNumberInput.sendKeys(ConfigReader.getConfigValue(mobileNumber));


    }

    public void selectIfSenderAndReceiverDetailsAreSame(String isSame) {
        if (ConfigReader.getConfigValue(isSame).equalsIgnoreCase("Yes")) {
            isDetailsSame.click();
        }

    }

    public void enterReceiverDetails(String name, String email, String mobileNumber) {

        receiverNameInput.sendKeys(ConfigReader.getConfigValue(name));
        receiverEmailInput.sendKeys(ConfigReader.getConfigValue(email));
        receiverEmailReEnterInput.sendKeys(ConfigReader.getConfigValue(email));
        receiverMobileNumberInput.sendKeys(ConfigReader.getConfigValue(mobileNumber));

    }

    public void acceptTC() {
        acceptTC.click();

    }

    public void clickOnPayNow() {

        payNowButton.click();

    }

    public void enterDeliveryDateDetails(String date, String month, String year) {

        if (datePicker.isDisplayed()) {
            Select selectMonth = new Select(datePickerMonth);
            Select selectYear = new Select(datePickerYear);
            selectYear.selectByVisibleText(ConfigReader.getConfigValue(year));
            selectMonth.selectByVisibleText(ConfigReader.getConfigValue(month));
            driver.findElement(By.xpath(String.format(DATE_XPATH, ConfigReader.getConfigValue(date)))).click();
        }
    }

    public void enterOTP() {
        pause(10000);
    }

    public void clickOnVerifyNow() {
        verifyNowButton.click();
    }

    public boolean isPaymentModesDisplayed() {
        return howToRedeemText.isDisplayed();
    }
}
