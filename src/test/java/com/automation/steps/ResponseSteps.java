package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ResponseSteps {

    @Then("verify status code is {int}")
    public void verifyStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());
    }

    @And("verify response body has a field {string} with value {string}")
    public void verifyResponseBodyHasAFieldWithValue(String field, String value) {
        Assert.assertEquals(field, RestAssuredUtils.getResponseFieldValue(value));
    }

    @Then("verify response body has a field {string}")
    public void verifyResponseBodyHasAField(String key) {
        String responseBody = RestAssuredUtils.getResponse().getBody().asString();
        Assert.assertTrue(responseBody.contains(key));
    }


    @Then("store the id {string} in variable {string}")
    public void storeTheIdInVariable(String field, String fieldName) {
        String id = RestAssuredUtils.getResponse().jsonPath().getString(field);
        ConfigReader.setConfigValue(fieldName,id);
    }

    @And("retrieve the created data with id {string}")
    public void retrieveTheCreatedDataWithId(String id) {
        RestAssuredUtils.setEndPointWith(id);
    }

    @Then("user performs delete method")
    public void userPerformsDeleteMethod() {
        RestAssuredUtils.delete();
    }
}
