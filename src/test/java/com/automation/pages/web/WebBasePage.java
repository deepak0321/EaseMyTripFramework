package com.automation.pages.web;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class WebBasePage {

    WebDriver driver;
    WebDriverWait wait;


    public WebBasePage() {

        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
    }

    public void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isDisplayed(WebElement element){
        setImplicitWait(0);
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }finally {
            setImplicitWait(60);
        }
    }

    public void setImplicitWait(long secs){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
    }
    public String[] timeSplitter(String time) {
        String[] timeParts = time.split(" ");
        String[] hourMinute = timeParts[0].split(":");
        int minute = Integer.parseInt(hourMinute[1]);
        String period = timeParts[1];
        int dividedMinute = minute / 5;
        return new String[]{hourMinute[0],String.valueOf(dividedMinute+1),period};

    }

}
