package starter.Comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class CommentStepDef {
    public static String BASE_URL = "https://gorest.co.in/public/v2";

    public static String LIST_COMMENT = Constants.BASE_URL +"/comments/{comment_id}";

    public static String CREATE_COMMENT = Constants.BASE_URL+"/posts/{post_id}/comments";

    public static String UPDATE_COMMENT = Constants.BASE_URL+"/comments/{comment_id}";

    public static String DELETE_COMMENT = Constants.BASE_URL+"/comments/{comment_id}";


    @Step("Get list user with valid parameter page")
    public void getListUser(int page) {
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Post create comment with valid JSON")
    public void postCreateUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Update comment with valid JSON and comment id")
    public void putUpdateUser(int id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }
    @Step("Delete comment with valid comment id")
    public void deleteUser (int id) {
        SerenityRest.given().pathParam("id", id);
    }@Given("Create comments with valid json {string}")
    public void createCommentsWithValidJson(String json) {
        File jsonFile =new  File(Constants.REQ_BODY+json);
        postCreateUser(jsonFile);
    }

    @When("Send request create new comment")
    public void sendRequestCreateNewComment() {SerenityRest.when().post(CREATE_COMMENT);
    }
    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {SerenityRest.then().statusCode(statusCode);
    }

//    @And("Validate Json Schema {string}")
//    public void validateJsonSchema(String json) {
//        File jsonFile = new File(Constants.JSON_SCHEMA+json);
//        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
//    }

    @Given("Delete comment with valid comment id {int}")
    public void deleteCommentWithValidCommentId(int id) {
        deleteUser(id);
    }
    @When("Send request delete user")
    public void sendRequestDeleteUser() {SerenityRest.when().delete(DELETE_COMMENT);
    }

    @Given("Get comment with valid comment id {int}")
    public void getCommentWithValidCommentId(int page) {
        getListUser(page);
    }

    @When("Send request get comment")
    public void sendRequestGetComment() {SerenityRest.when().get(LIST_COMMENT);
    }

    @Given("Get comment with unregistered comment id {int}")
    public void getCommentWithUnregisteredCommentId(int page) {
        getListUser(page);
            }

    @Given("Update comment with valid JSON {string} and unregistered comment id {int}")
    public void updateCommentWithValidJSONAndUnregisteredCommentId(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        putUpdateUser(id, jsonFile);
    }

    @Given("Update comment with valid JSON {string} and comment id {int}")
    public void updateCommentWithValidJSONAndCommentId(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        putUpdateUser(id, jsonFile);
    }

    @When("Send request update comment")
    public void sendRequestUpdateComment() {SerenityRest.when().put(UPDATE_COMMENT);
    }

}

