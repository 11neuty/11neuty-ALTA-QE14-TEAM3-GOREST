package starter.comments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;


public class GetCommentsStepDef {

    @Steps
    GorestCommentsAPI gorestCommentsAPI;

    @Given("Get list comments without comment id")
    public void getListCommentsWithoutCommentId() {
        gorestCommentsAPI.getListComment();
    }

    @When("Send request get list comment")
    public void sendRequestGetListComment() {
        SerenityRest.when()
                .get(GorestCommentsAPI.LIST_COMMENT);
    }

    @Given("Get comment with valid comment id {int}")
    public void getCommentValid(int id) {
        gorestCommentsAPI.getComments(id);
    }

    @When("Send request get comment")
    public void sendRequestGetComment() {
        SerenityRest.when()
                .get(GorestCommentsAPI.COMMENT_ID);
    }

    @Given("Get comment with unregistered comment id {int}")
    public void getCommentWithUnregisteredCommentId(int id) {
        gorestCommentsAPI.getComments(id);
    }

}
