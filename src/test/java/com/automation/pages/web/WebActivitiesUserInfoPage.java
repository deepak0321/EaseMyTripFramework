package com.automation.pages.web;

import com.automation.utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

public class WebActivitiesUserInfoPage extends WebBasePage {

    @FindBy(xpath = "//label[text()='Title']/following-sibling::div[@class='_slcttltle f14']")
    List<WebElement> titleInputs;

    @FindBy(xpath = "//ul[@class='ng-scope']/li")
    List<WebElement> prefix;

    @FindBy(xpath = "//input[@placeholder='Enter Your First Name']")
    List<WebElement> firstNameInputs;

    @FindBy(xpath = "//input[@placeholder='Enter Your Last Name']")
    List<WebElement> lastNameInputs;

    @FindBy(xpath = "//span[@class='checkmark1a']")
    WebElement checkBox;

    @FindBy(id = "mobile")
    WebElement mobile;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "PanName")
    WebElement panName;

    @FindBy(id = "Pan")
    WebElement panNumber;

    @FindBy(xpath = "//a[@id='continueToPay']")
    WebElement continueToPayBtn;

    @FindBy(xpath = "//div[@class='_frdetlmn f15']")
    WebElement priceDetails;

    public boolean isUserInfoPageDisplayed() {
        return continueToPayBtn.isDisplayed();
    }

    public void fillUserDetails (DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (int i=0;i<data.size();++i) {

            String prefixValue = data.get(i).get("prefix");
            String firstNameValue = data.get(i).get("firstName");
            String lastNameValue = data.get(i).get("lastName");

            wait.until(ExpectedConditions.elementToBeClickable(titleInputs.get(i)));
            javascriptExecutor(titleInputs.get(i));

            prefix = driver.findElements(By.xpath("//ul[@class='ng-scope']/li"));

            for (WebElement element : prefix) {
                if (element.getText().contains(prefixValue)) {
                    wait.until(ExpectedConditions.elementToBeClickable(element));
                    javascriptExecutor(element);
                    break;
                }
            }

            firstNameInputs.get(i).sendKeys(firstNameValue);
            lastNameInputs.get(i).sendKeys(lastNameValue);
        }
    }

    public void fillContactDetails(String mobileInput, String emailInput, String panNameInput, String panNumberInput) {

        email.sendKeys(ConfigReader.getConfigValue(emailInput));
        mobile.sendKeys(ConfigReader.getConfigValue(mobileInput));
        panName.sendKeys(ConfigReader.getConfigValue(panNameInput));
        panNumber.sendKeys(ConfigReader.getConfigValue(panNumberInput));
    }

    public void printDetails() {
        System.out.println(priceDetails.getText());
    }
}
