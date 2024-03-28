package starter.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class CreateUsersStepDef {
    @Steps
    GorestUsersAPI gorestUsersAPI;

    @Given("Create new user with valid body json {string}")
    public void createNewUserWithValidBodyJson(String JSON) {
        File jsonFile = new File(Constants.REQ_BODY + JSON);
        gorestUsersAPI.createNewUser(jsonFile);
    }

    @When("Send request post user")
    public void sendRequestPostUser() {
        SerenityRest.when()
                .post(GorestUsersAPI.CREATE_USER);
    }

    @Given("Create new user with invalid body json {string}")
    public void createNewUserWithInvalidBodyJson(String JSON) {
        File jsonFile = new File(Constants.REQ_BODY + JSON);
        gorestUsersAPI.createNewUser(jsonFile);
    }
}
