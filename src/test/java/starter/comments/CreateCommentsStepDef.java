package starter.comments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class CreateCommentsStepDef {
    @Steps
    GorestCommentsAPI gorestCommentsAPI;

    @Given("Create comments with valid post id {int} json {string}")
    public void createCommentsWithValidJson(int post_id, String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        gorestCommentsAPI.createComment(post_id, jsonFile);
    }

    @When("Send request create new comment")
    public void sendRequestCreateNewComment() {
        SerenityRest.when()
                .post(GorestCommentsAPI.CREATE_COMMENT);
    }

    @Given("Create comments with invalid post id {int} json {string}")
    public void createCommentsWithInvalidJson(int post_id, String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        gorestCommentsAPI.createComment(post_id, jsonFile);
    }
}
