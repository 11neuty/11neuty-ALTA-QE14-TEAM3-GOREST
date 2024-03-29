package starter.comments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteCommentsStepDef {

    @Steps
    GorestCommentsAPI gorestCommentsAPI;

    @Given("Delete comment with valid comment id {int}")
    public void deleteCommentWithValidCommentId(int id) {
        gorestCommentsAPI.deleteComment(id);
    }

    @When("Send request delete comment")
    public void sendRequestDeleteComment() {
        SerenityRest.when()
                .delete(GorestCommentsAPI.DELETE_COMMENT);
    }

    @Given("Delete comment with invalid comment id {int}")
    public void deleteCommentWithInvalidCommentId(int id) {
        gorestCommentsAPI.deleteComment(id);
    }
}
