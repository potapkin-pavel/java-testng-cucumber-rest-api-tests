package ru.spb;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StepDefinitions {

    private RequestSpecification request = given();
    private Response response;

    @When("I send get method on {string}")
    public void sendGetRequestOn(String path) {
        response = request.get(path);
    }

    @Then("Status code is {int}")
    public void assertStatusCodeIs(int code) {
        assertThat(response.statusCode(), equalTo(code));
    }

}
