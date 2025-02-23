package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.*;
import io.restassured.RestAssured;

public class Hooks {

    @Before("@Web or @Android")
    public void setUp() {
        ConfigReader.initReader();
        DriverManager.createDriver();
    }


    @Before("@api")
    public void setUpAPI() {
        ConfigReader.initReader();
        RestAssured.baseURI = "https://67b972a051192bd378dd7191.mockapi.io";
        RestAssured.useRelaxedHTTPSValidation();
    }

    @After("@Web or @Android")
    public void cleanUp() {
         DriverManager.getDriver().quit();
    }


}
