package com.automation.pages.web;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class WebChatbotPage extends WebBasePage {

    @FindBy(xpath = "//div[@class='clkbubb']")
    List<WebElement> availableOptions;

    @FindBy(xpath = "//div[@id='no']")
    WebElement yseOrNoBtn;

    @FindBy(id = "send_message_text")
    WebElement inputTextField;

    @FindBy(xpath = "//img[@class='eb_widget_send_input_message']")
    WebElement sendInputBtn;

    @FindBy(xpath = "//div[contains(text(), 'kind of holiday')]")
    WebElement question;

    String xpath = "(//div[@class='eb-bubble eb-you'])[%s]";

    @FindBy(xpath = "(//div[contains(text(), 'Thank you')])")
    WebElement confirmationMsg;

    public boolean isChatbotDisplayed() {
        return !availableOptions.isEmpty();
    }

    public void selectOption(String option) {

        for (WebElement element : availableOptions) {
            if (element.getText().equalsIgnoreCase(option)) {
                element.click();
                break;
            }
        }
    }

    public void enterQueryNumber(String option) {
        if (option.equals("Yes")) {
            inputTextField.sendKeys(queryNumber);
            sendInputBtn.click();
        }
        yseOrNoBtn.click();
    }

    public boolean isChatbotAsksDetails() {
        return question.isDisplayed();
    }

    public void enterDetails(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        int k = 4;

        for (Map<String, String> row : data) {

            String updatedXpath = String.format(xpath, k++);

            question = driver.findElement(By.xpath(updatedXpath));
            String[] str = question.getText().split("\n");

            String value = row.get("Value");

            for (int i = 0; i < str.length; ++i) {
                if (str[i].contains(value)) {
                    inputTextField.sendKeys(i - 1 + "");
                    sendInputBtn.click();
                    break;
                }
            }
        }
        inputTextField.sendKeys(data.getLast().get("Value"));
        sendInputBtn.click();
    }

    public boolean isConfirmationDisplayed() {
        System.out.println(confirmationMsg.getText());
        return confirmationMsg.isDisplayed();
    }
}
