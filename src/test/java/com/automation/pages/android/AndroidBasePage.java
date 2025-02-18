package com.automation.pages.android;


import com.automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;

public abstract class AndroidBasePage {

    AppiumDriver driver;

    public AndroidBasePage() {
        driver = (AppiumDriver) DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void scrollUp() {
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), width / 2, height / 2));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(finger.createPointerMove(Duration.ofSeconds(2),PointerInput.Origin.viewport(),width/2,height/4));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    public void scrollDown(){
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), width / 2, height / 2));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), width / 2, height * 3 / 4));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

   public void swipe(WebElement element){
       int elementX = element.getLocation().getX();
       int elementY = element.getLocation().getY();
       PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
       Sequence swipeSequence = new Sequence(finger, 0);
       swipeSequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), elementX, elementY));
       swipeSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
       swipeSequence.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),elementX/3 , elementY));
       swipeSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
       driver.perform(Collections.singletonList(swipeSequence));
   }

    private void setImplicitWait(long seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public boolean isElementDisplayed(String XPath){
        setImplicitWait(0);
        try {
            driver.findElement(By.xpath(XPath));
            return true;
        } catch (Exception e) {
            return false;
        }finally {
            setImplicitWait(10);
        }

    }

    public String dateFormat(String givenDate) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("d MMMM yyyy");
        Date date;
        try {
            date = inputFormat.parse(givenDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
        return outputFormat.format(date);
    }

    public boolean isDisplayed(WebElement element){
        setImplicitWait(0);
        try {
            element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }finally {
            setImplicitWait(60);
        }

    }


}
