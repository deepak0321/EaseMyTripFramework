package com.automation.pages.android;

import com.automation.pages.ui.GiftCardPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidGiftCardPage extends AndroidBasePage implements GiftCardPage {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Check Balance\"]")
    WebElement checkBalance;

    @FindBy(xpath = "//android.widget.Button[@text=\"loved Loved Ones\"]")
    WebElement lovedOnesCategory;

    @FindBy(xpath = "//android.widget.Button[@text=\"festival Festival\"]")
    WebElement festivalCategory;

    @FindBy(xpath = "//android.widget.Button[@text=\"occasion Occasional\"]")
    WebElement occasionalCategory;

    @FindBy(xpath = "//android.view.View[@resource-id=\"Strtfrm\"]/android.widget.EditText")
    WebElement denominationInput;

    @FindBy(xpath = "//android.view.View[@text=\"--Select Quantity--\"]")
    WebElement selectQuantityDropdown;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"pny\"]")
    WebElement payNowButton;

    @FindBy(xpath = "//android.view.View[@resource-id=\"Strtfrm\"]/android.view.View[1]/android.widget.EditText[1]")
    WebElement senderNameInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"txtEmailId\"]")
    WebElement senderEmailInput;

    @FindBy(xpath = "//android.view.View[@resource-id=\"Strtfrm\"]/android.view.View[1]/android.widget.EditText[3]")
    WebElement senderMobileNumberInput;

    @FindBy(xpath = "//android.widget.CheckBox[@text=\"Receiver Details Same as sender details\"]")
    WebElement detailsSameCheckbox;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"rcnm\"]")
    WebElement receiverNameInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"rceml\"]")
    WebElement receiverEmailInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"rcteml\"]")
    WebElement receiverEmailReEnterInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"rcephn\"]")
    WebElement receiverMobileNumberInput;

    @FindBy(xpath = "//android.view.View[@resource-id=\"Strtfrm\"]/android.view.View[2]/android.widget.CheckBox")
    WebElement acceptTC;

    @FindBy(xpath = "//android.view.View[@resource-id=\"ui-datepicker-div\"]")
    WebElement datePicker;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Verify Now\"]")
    WebElement verifyNowButton;

    String DATE_PICKER_MONTH_XPATH = "//android.view.View[@text=\"%s\"]";

    String DATE_PICKER_YEAR_XPATH = "//android.view.View[@text=\"%s\"]";

    @FindBy(xpath = "//android.view.View[@content-desc=\"Next\"]")
    WebElement nextMonthButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Make Payment\"]")
    WebElement makePaymentButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Payment Mode\"]")
    WebElement paymentMode;

    String DATE_XPATH = "//android.widget.TextView[@text=\"%s\"]";


    String GIFT_CARD_QUANTITY_XPATH = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text='%s']";

    String GIFT_CARD_TYPE_XPATH = "//android.widget.TextView[contains(@text,'%s Gift Card')]";

    String GIFT_CARD_DELIVERY_DATE_XPATH = "//android.widget.TextView[@text=\"%s\"]";


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
        return checkBalance.isDisplayed();
    }

    public void selectGiftCardType(String type) {
        while (!isDisplayed(String.format(GIFT_CARD_TYPE_XPATH, ConfigReader.getConfigValue(type)))) {
            scrollDown();
        }
        WebElement giftCardType = driver.findElement(By.xpath(String.format(GIFT_CARD_TYPE_XPATH, ConfigReader.getConfigValue(type))));
        giftCardType.click();

    }

    public void enterGiftCardDetails(String denomination, String quantity, String deliveryDate) {

        denominationInput.sendKeys(ConfigReader.getConfigValue(denomination));

        selectQuantityDropdown.click();
        driver.findElement(By.xpath(String.format(GIFT_CARD_QUANTITY_XPATH, ConfigReader.getConfigValue(quantity)))).click();

        driver.findElement(By.xpath(String.format(GIFT_CARD_DELIVERY_DATE_XPATH, ConfigReader.getConfigValue(deliveryDate)))).click();


    }

    public void enterSenderDetails(String name, String email, String mobileNumber) {

        while (!isDisplayed(payNowButton)) {
            scrollDown();
        }
        senderNameInput.sendKeys(ConfigReader.getConfigValue(name));
        senderEmailInput.sendKeys(ConfigReader.getConfigValue(email));
        senderMobileNumberInput.sendKeys(ConfigReader.getConfigValue(mobileNumber));
    }

    public void selectIfSenderAndReceiverDetailsAreSame(String isSame) {
        if (ConfigReader.getConfigValue(isSame).equalsIgnoreCase("yes")) {
            detailsSameCheckbox.click();
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

        if (!isDisplayed(datePicker))
            return;


        String monthXpath = String.format(DATE_PICKER_MONTH_XPATH, ConfigReader.getConfigValue(month));
        String yearXpath = String.format(DATE_PICKER_YEAR_XPATH, ConfigReader.getConfigValue(year));

        while (!isDisplayed(monthXpath) || !isDisplayed(yearXpath)) {
            nextMonthButton.click();
        }
        driver.findElement(By.xpath(String.format(DATE_XPATH, ConfigReader.getConfigValue(date)))).click();

    }

    public void enterOTP() {
        pause(5000);
    }

    public void clickOnVerifyNow() {
        verifyNowButton.click();
    }

    public boolean isPaymentModesDisplayed() {

        while(!isDisplayed(paymentMode))
            scrollUp();
        return makePaymentButton.isDisplayed();

    }


}
