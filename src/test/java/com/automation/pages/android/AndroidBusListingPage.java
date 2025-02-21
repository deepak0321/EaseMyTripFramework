package com.automation.pages.android;

import com.automation.pages.ui.BusListingPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidBusListingPage extends AndroidBasePage implements BusListingPage {


    @FindBy(id = "com.easemytrip.android:id/buses_found")
    WebElement busesFoundText;

    @FindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"com.easemytrip.android:id/ll_bus_1\"])[1]")
    WebElement firstAvailableBus;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.easemytrip.android:id/sl\"]")
    List<WebElement> availableSeats;

    @FindBy(xpath = "//android.widget.TextView[@text=\"UPPER SEAT\"]")
    WebElement upperSeatsCategory;

    @FindBy(id = "com.easemytrip.android:id/btn_booknow")
    WebElement continueBtn;

    String POINT_XPATH = "//android.widget.TextView[@resource-id=\"com.easemytrip.android:id/tv_boarding_point_name\" and contains(@text, '%s')]";

    static boolean isContinueBtnClicked = false;

    public void selectPoint(String point) {
        String POINT_TO_SELECT_XPATH = String.format(POINT_XPATH, ConfigReader.getConfigValue(point));
        while (!isElementDisplayed(POINT_TO_SELECT_XPATH)) {
            scrollDown();
        }
        driver.findElement(By.xpath(POINT_TO_SELECT_XPATH)).click();
    }


    public void clickOnContinue() {
        if (!isContinueBtnClicked) {
            continueBtn.click();
            isContinueBtnClicked = true;
        }
    }


    public void selectFirstAvailableSeat() {
        if (ConfigReader.getConfigValue("mobile.seat.category").equalsIgnoreCase("upper")) {
            upperSeatsCategory.click();
        }
        int seatNo = 0;
        while (!isDisplayed(continueBtn)) {
            availableSeats.get(seatNo).click();
            seatNo++;
        }
        clickOnContinue();
    }


    public void clickOnSelectSeats() {
        firstAvailableBus.click();
    }


    public boolean isBusListingPageDisplayed() {
        return busesFoundText.isDisplayed();
    }
}
