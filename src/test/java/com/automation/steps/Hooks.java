package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.*;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        ConfigReader.initReader();
        DriverManager.createDriver();
    }

    @After
    public void cleanUp() {
       DriverManager.getDriver().quit();
    }



}
