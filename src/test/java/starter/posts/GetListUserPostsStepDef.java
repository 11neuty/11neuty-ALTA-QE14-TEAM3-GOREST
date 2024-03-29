package starter.posts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetListUserPostsStepDef {
    @Steps
    GoRestPostAPI goRestPostAPI;

    @Given("Set parameter with id {int}")
    public void setParameterWithId(int id) {
        goRestPostAPI.getListUserPosts(id);
    }

    @When("Send request get list user posts")
    public void sendRequestGetListUserPosts() {
        SerenityRest.when().get(GoRestPostAPI.LIST_USER_POST);
    }

    @Given("Set parameter with id {string}")
    public void setParameterWithId(String invalidId) {
        goRestPostAPI.getListUserPostsInvalid(invalidId);
    }

    @Given("Set path without parameter")
    public void setPathWithoutParameter() {

        goRestPostAPI.getListUserPostWithoutParameter();
    }

    @When("Send request get list user posts without parameter")
    public void sendRequestGetListUserPostsWithoutParameter() {
        SerenityRest.when().get(GoRestPostAPI.LIST_USER_POST_WITHOUT_PARAMETER);
    }
}
