package starter.posts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.Constants;

import java.io.File;

public class GoRestPostsResponses {
    @Then("API should return response {int}")
    public void apiShouldReturnResponse(int statusCode) {

        SerenityRest.then().statusCode(statusCode);
    }

//    @And("Validate json schema {string}")
//    public void validateJsonSchema(String json) {
//        File jsonFile = new File(Constants.JSON_SCHEMA+json);
//        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
//    }
}
