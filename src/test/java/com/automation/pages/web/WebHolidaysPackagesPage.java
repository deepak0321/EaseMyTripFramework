package com.automation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebHolidaysPackagesPage extends WebBasePage {

    @FindBy(xpath = "//h1[contains(text(), 'Holiday Packages')]")
    WebElement title;

    @FindBy(xpath = "//input[@ng-model='exCity.CityName']")
    WebElement fromCityInput;

    @FindBy(xpath = "//li[@ng-click='SelectExCitys(ct)']")
    List<WebElement> availableCitiesList;

    @FindBy(xpath = "//select[@ng-model='Fval']")
    WebElement sortOptions;

    @FindBy(xpath = "//li[contains(@ng-click, 'ModeFilter')]/label")
    List<WebElement> packageTypes;

    @FindBy(xpath = "//span[text() = 'More Filter']")
    WebElement moreFilterBtn;

    @FindBy(xpath = "//span[@class='checkmark_f2']/..")
    List<WebElement> availableThemes;

    @FindBy(xpath = "//div[@class='ritbtn']/a[text()='View Package  ']")
    List<WebElement> availablePackages;

    @FindBy(xpath = "//div[@class='ritbtn']/a[text()='View Package  ']/ancestor::div[3]/div/span")
    List<WebElement> cards;

    String option = "//option[contains(text(), '%s')]";

    public boolean isTourPackagesPageDisplayed() {
        return title.isDisplayed();
    }

    public void selectFromCity(String inputCity) {
        fromCityInput.click();

        for (WebElement city : availableCitiesList) {
            if (city.getText().equalsIgnoreCase(inputCity)) {
                city.click();
                break;
            }
        }

        pause(2000);
    }

    public void filterOptions(String sortOrder, String packageType) {
        flightOption = packageType;

        sortOptions.click();
        String xpath = String.format(option, sortOrder);
        driver.findElement(By.xpath(xpath)).click();

        for (WebElement type : packageTypes) {
            if (type.getText().equalsIgnoreCase(packageType)) {
                type.click();
                break;
            }
        }
    }

    public void moreFilterOptions(String theme) {
        moreFilterBtn.click();

        for (WebElement element : availableThemes) {
            if (element.getText().equalsIgnoreCase(theme)) {
                element.click();
                break;
            }
        }

    }

    public boolean isPackagesDisplayed() {
        return !availablePackages.isEmpty();
    }

    public void selectRecommendedPackage() {

        for (int i=0;i<cards.size();++i) {
            if (cards.get(i).getText().equalsIgnoreCase("recommended")) {
                availablePackages.get(i).click();
                return;
            }
        }
        driver.findElement(By.xpath("//div[@ng-click='GoDetail(lst)']/img")).click();
    }
}
