package starter.posts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class CreatePostsStepDef {

    @Steps
    GoRestPostAPI goRestPostAPI;

    @Given("Set request create body {string} as body and {int} as id")
    public void setRequestCreateBodyAsBodyAndAsId(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        goRestPostAPI.postCreatePosts(id, jsonFile);
    }

    @When("Send request create posts")
    public void sendRequestCreatePosts() {
        SerenityRest.when().post(GoRestPostAPI.CREATE_POSTS);
    }


}
