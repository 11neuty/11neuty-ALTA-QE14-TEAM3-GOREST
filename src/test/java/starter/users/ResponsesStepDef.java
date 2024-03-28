package starter.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ResponsesStepDef {

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @And("Response body data name should be {string} and email {string}")
    public void responseBodyDataIdShouldBeAndEmail(String name, String email) {
        SerenityRest.and()
                .body(GorestUsersResponses.USER_NAME, equalTo(name))
                .body(GorestUsersResponses.USER_EMAIL, equalTo(email));
    }

    @And("Validate json schema {string}")
    public void validateJsonSchema(String JSON) {
        File jsonFile = new File(Constants.JSON_SCHEMA + JSON);
        SerenityRest.and()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Response body data name should be {string}")
    public void responseBodyDataNameShouldBe(String name) {
        SerenityRest.and()
                .body(GorestUsersResponses.USER_NAME, equalTo(name));
    }

    @And("Response body data email should be {string}")
    public void responseBodyDataEmailShouldBe(String email) {
        SerenityRest.and()
                .body(GorestUsersResponses.USER_EMAIL, equalTo(email));
    }
}
