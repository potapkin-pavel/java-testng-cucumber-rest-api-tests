package ru.spb;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StepDefinitions {

    private RequestSpecification request = given();
    private Response response;

    @Before
    public void setUp() {
        request.filter(new AllureRestAssured());
    }

    @When("I send get method on {string}")
    public void sendGetRequestOn(String path) {
        response = request.get(path);
    }

    @Then("Status code is {int}")
    public void assertStatusCodeIs(int code) {
        assertThat(response.statusCode(), equalTo(code));
    }

    @After
    public void logResponse() {
       response.then().log().all();
    }

}
