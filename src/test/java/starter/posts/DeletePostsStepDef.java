package starter.posts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeletePostsStepDef {
    @Steps
    GoRestPostAPI goRestPostAPI;

    @Given("Set parameter with {int} as id")
    public void setParameterWithAsId(int id) {
        goRestPostAPI.deletePostsValidId(id);
    }

    @When("Send request delete posts")
    public void sendRequestDeletePosts() {
        SerenityRest.when().delete(GoRestPostAPI.DELETE_POSTS);
    }

    @Given("Set parameter with {string} as id")
    public void setParameterWithAsId(String id) {
        goRestPostAPI.deletePostsInvalidId(id);
    }

    @When("Send request delete posts with invalid id")
    public void sendRequestDeletePostsWithInvalidId() {
        SerenityRest.when().delete(GoRestPostAPI.DELETE_POSTS);
    }
}
