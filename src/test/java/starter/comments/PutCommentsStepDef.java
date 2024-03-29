package starter.comments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class PutCommentsStepDef {

    @Steps
    GorestCommentsAPI gorestCommentsAPI;

    @Given("Update comment with valid JSON {string} and comment id {int}")
    public void updateComment(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        gorestCommentsAPI.updateComment(jsonFile, id);
    }

    @When("Send request update comment")
    public void sendRequestUpdateComment() {
        SerenityRest.when()
                .put(GorestCommentsAPI.UPDATE_COMMENT);
    }

    @Given("Update comment with valid JSON {string} and unregistered comment id {int}")
    public void updateCommentWithValidJSONAndUnregisteredCommentId(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        gorestCommentsAPI.updateComment(jsonFile, id);
    }
}
