package com.automation.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {
    static WebDriver driver;
    static ChromeOptions chromeOptions;

    public static void createDriver() {
        chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-geolocation");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--deny-permission-prompts");

        if (ConfigReader.getConfigValue("application.type").equals("Web")) {
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        } else if (ConfigReader.getConfigValue("application.type").equals("Android")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
            capabilities.setCapability("automationName", ConfigReader.getConfigValue("automation.name"));
            capabilities.setCapability("app", System.getProperty("user.dir") + ConfigReader.getConfigValue("app.path"));
            capabilities.setCapability("deviceName", ConfigReader.getConfigValue("device.name"));
            capabilities.setCapability("appPackage", ConfigReader.getConfigValue("app.package"));
            capabilities.setCapability("appActivity", ConfigReader.getConfigValue("app.activity"));
            driver = new AndroidDriver(capabilities);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));


    }

    public static WebDriver getDriver() {
        return driver;
    }
}
