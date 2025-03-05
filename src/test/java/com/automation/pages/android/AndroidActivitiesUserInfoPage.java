package com.automation.pages.android;

import com.automation.pages.ui.ActivitiesPage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class AndroidActivitiesUserInfoPage extends AndroidBasePage implements ActivitiesPage {

    @FindBy(xpath = "//android.widget.EditText[@resource-id]")
    List<WebElement> inputFields;

    @FindBy(xpath = "//android.widget.TextView[@text='Contact Details']")
    WebElement contactDetails;

    @FindBy(xpath = "//android.widget.TextView[@text='Contact Details']/following-sibling::android.view.View//android.widget.EditText")
    List <WebElement> details;

    @FindBy(xpath = "//android.widget.TextView[@text='Grand Total']/following-sibling::android.widget.TextView")
    WebElement price;

    public boolean isUserInfoPageDisplayed() {
        return price.isDisplayed();
    }

    public void fillUserDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (int i=0;i<data.size();++i) {

            String firstNameValue = data.get(i).get("firstName");
            String lastNameValue = data.get(i).get("lastName");

            if (inputFields.get(i).getText().isEmpty()) {
                inputFields.get(i).sendKeys(firstNameValue);
                inputFields.get(i+1).sendKeys(lastNameValue);
            }
            scrollDown();
            inputFields = driver.findElements(By.xpath("//android.widget.EditText[@resource-id]"));
        }
    }

    public void fillContactDetails(String mobileInput, String emailInput, String panNameInput, String panNumberInput) {
        while (!isPresent(contactDetails)) {
            scrollDown();
        }
        details.get(0).sendKeys(emailInput);
        details.get(1).sendKeys(mobileInput);
        scrollDown();
        details.get(2).sendKeys(panNameInput);
        details.get(3).sendKeys(panNumberInput);
    }

    public void printDetails() {
        System.out.println(price.getText());
    }
}
