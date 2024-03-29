package starter.posts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class UpdatePostsStepDef {
    @Steps
    GoRestPostAPI goRestPostAPI;

    @Given("Set request body {string} as body and {int} as id")
    public void setRequestBodyAsBodyAndAsId(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        goRestPostAPI.postUpdatePosts(id, jsonFile);
    }

    @When("Send request update post")
    public void sendRequestUpdatePost() {

        SerenityRest.when().put(GoRestPostAPI.UPDATE_POSTS);
    }

    @Given("Set request body {string} as body and {string} as id")
    public void setRequestBodyAsBodyAndAsId(String json, String id) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        goRestPostAPI.postUpdatePostsInvalidId(id, jsonFile);
    }
}
