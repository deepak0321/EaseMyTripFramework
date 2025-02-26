package com.automation.pages.web;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public abstract class WebBasePage {

    WebDriver driver;
    WebDriverWait wait;
    static String queryNumber;

    public WebBasePage() {

        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
    }

    public static String getFormattedDate(String expectedFormat, String date, String currentDateFormat) {
        try {
            SimpleDateFormat currentFormatter = new SimpleDateFormat(currentDateFormat);
            Date dateObject = currentFormatter.parse(date);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateObject);

            SimpleDateFormat expectedFormatter = new SimpleDateFormat(expectedFormat);
            return expectedFormatter.format(calendar.getTime());
        } catch (Exception e) {
            throw new RuntimeException("Invalid date format " + expectedFormat);
        }
    }


    public void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean isDisplayed(WebElement element) {
        setImplicitWait(0);
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(60);
        }
    }

    public void waitForElementVisible(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void waitForElementClickable(WebElement ele) {
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public void setImplicitWait(long secs) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
    }

    public String[] timeSplitter(String time) {
        String[] timeParts = time.split(" ");
        String[] hourMinute = timeParts[0].split(":");
        int minute = Integer.parseInt(hourMinute[1]);
        String period = timeParts[1];
        int dividedMinute = minute / 5;
        return new String[]{hourMinute[0], String.valueOf(dividedMinute + 1), period};

    }

    public static String[] parseDate(String inputDate) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("d MMM yyyy");
            Date date = inputFormat.parse(inputDate);

            SimpleDateFormat dayFormat = new SimpleDateFormat("d");
            SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");

            String day = dayFormat.format(date);
            String month = monthFormat.format(date);

            return new String[]{day, month};
        } catch (Exception e) {
            return new String[]{};
        }
    }
}
