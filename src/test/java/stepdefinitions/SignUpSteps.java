package stepdefinitions;

import core.RequestBuilder;
import core.ResponseHandler;
import core.ScenarioContext;
import io.cucumber.java.en.*;
import io.restassured.response.Response;


public class SignUpSteps {

    Response response;

    @Given("user is authenticated")
    public void user_is_authenticated() {
        ScenarioContext.set("token", "dummy-token");
    }
    @When("user wants to signup")
    public void user_wants_to_signup() {
        response = new RequestBuilder()
                .addHeader("Authorization", "Bearer " + ScenarioContext.get("token"))
                .post("/accounts");

        ScenarioContext.set("accountId",
                ResponseHandler.getValue(response, "accountId"));
    }
    @Then("account should be created successfully")
    public void account_should_be_created_successfully() {
        ResponseHandler.validateStatus(response, 201);
    }
}
