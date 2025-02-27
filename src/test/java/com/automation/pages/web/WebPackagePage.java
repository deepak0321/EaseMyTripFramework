package com.automation.pages.web;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WebPackagePage extends WebBasePage {

    @FindBy(xpath = "//span[@class='pkgname ng-binding']")
    WebElement title;

    @FindBy(xpath = "//span[@class='pkgtimex ng-binding']")
    WebElement days;

    @FindBy(xpath = "//div[@class='stycitydtl ng-binding']")
    WebElement detailedDays;

    @FindBy(xpath = "//div[@class='mflex acenter']/ancestor::div[@class='mflex']")
    WebElement titleCard;

    @FindBy(xpath = "//span[@class='close_er']")
    WebElement closeBtn;

    @FindBy(xpath = "//a[@class='sbmtbtn mgt10']")
    WebElement enquiryBtn;

    @FindBy(xpath = "//input[@ng-model='queryDetail.Name']")
    WebElement nameInput;

    @FindBy(xpath = "//input[@ng-model='queryDetail.MobileNo']")
    WebElement mobileInput;

    @FindBy(xpath = "//input[@ng-model='queryDetail.Email']")
    WebElement emailInput;

    @FindBy(xpath = "//div[text()='Child']/following-sibling::div/input[@type='text']/../button[2]")
    WebElement childQtyIncrementBtn;

    @FindBy(xpath = "//div[text()='Infant']/following-sibling::div/input[@type='text']/../button[2]")
    WebElement infantQtyIncrementBtn;

    @FindBy(id = "Button2")
    WebElement submitEnquiryBtn;

    @FindBy(xpath = "//div[@class='mglauto ng-scope']/a[@class='chnbtn']")
    WebElement changeHotelBtn;

    @FindBy(xpath = "//select[@ng-model='htlSort']")
    WebElement sortBtn;

    @FindBy(xpath = "//select[@ng-model='htlSort']/option")
    List<WebElement> sortOptions;

    @FindBy(xpath = "(//a[@class='slct_btn mgt7'])")
    WebElement selectRoomBtn;

    @FindBy(xpath = "//div[@class='btnhcol mga_15 ']/a[@class='slct_btn']")
    WebElement selectBtn;

    @FindBy(id = "showprde")
    WebElement price;

    public void printDetails() {

        if (flightOption.equalsIgnoreCase("with flights")) {
            System.out.println(titleCard.getText());
        } else {
            System.out.println(title.getText() + "\n" + days.getText() + "\n" + detailedDays.getText());
        }
        wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
        closeBtn.click();

    }

    public boolean isPackagePageDisplayed() {
        if (flightOption.equalsIgnoreCase("with flights")) {
            return titleCard.isDisplayed();
        }
        return title.isDisplayed();
    }

    public void clickOnEnquiryBtnAndFillDetails(String name, String mobileNo, String mail) {
        pause(4000);
        wait.until(ExpectedConditions.elementToBeClickable(enquiryBtn));
        enquiryBtn.click();
        nameInput.sendKeys(ConfigReader.getConfigValue(name));
        mobileInput.sendKeys(ConfigReader.getConfigValue(mobileNo));
        emailInput.sendKeys(ConfigReader.getConfigValue(mail));

        childQtyIncrementBtn.click();
        infantQtyIncrementBtn.click();
    }

    public void clickOnEnquiryBtn() {
        submitEnquiryBtn.click();
        pause(3000);
    }

    public void customizeRooms(String sortOption) {
        changeHotelBtn.click();

        pause(6000);
        sortBtn.click();

        for (WebElement option : sortOptions) {
            if (option.getText().equalsIgnoreCase(ConfigReader.getConfigValue(sortOption))) {
                option.click();
                break;
            }
        }

        selectRoomBtn.click();
        selectBtn.click();
    }

    public void printPriceDetails() {
        System.out.println(price.getText());
    }
}