package starter.todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ResponsesStepDef {
    @Steps
    GorestTodosAPI gorestTodosAPI;

//    @Then("Status code should be {int}")
//    public void statusCodeShouldBe(int statusCode){
//        SerenityRest.then()
//                .statusCode(statusCode);
//    }
//    @And("Validate json schema {string}")
//    public void validateJsonSchema(String json) {
//        File jsonFile = new File(Constants.JSON_SCHEMA+json);
//        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
//    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.and().body(GorestTodosResponses.ID, equalTo(id));
    }

    @And("Response body user id should be {int}")
    public void responseBodyUserIdShouldBe(int userId) {
        SerenityRest.and().body(GorestTodosResponses.USER_ID, equalTo(userId));
    }


    @And("Response body user id post should be {int}")
    public void responseBodyUserIdPostShouldBe(int userId) {
        SerenityRest.and().body(GorestTodosResponses.POST_USERID, equalTo(userId));
    }
}
