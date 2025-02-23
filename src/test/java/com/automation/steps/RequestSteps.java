package com.automation.steps;


import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RequestSteps {


    @Given("user calls the endpoint {string}")
    public void userCallsTheEndpoint(String endPoint) {
        RestAssuredUtils.setEndPoint(endPoint);
    }

    @When("user sets header {string} to {string}")
    public void userSetsHeaderTo(String key, String value) {
        RestAssuredUtils.setHeader(key,value);
    }

    @And("set request body from file {string}")
    public void setRequestBodyFromFile(String filePath) {
        RestAssuredUtils.setBody(filePath);
    }

    @Then("user performs post method")
    public void userPerformsPostMethod() {
        RestAssuredUtils.post();
    }


    @Then("user performs put method")
    public void userPerformsPutMethod() {
        RestAssuredUtils.put();
    }

    @Then("user performs get method")
    public void userPerformsGetMethod() {
        RestAssuredUtils.get();
    }
}
