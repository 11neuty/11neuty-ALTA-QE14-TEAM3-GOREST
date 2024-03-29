package starter.users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class UpdateUsersStepDef {

    @Steps
    GorestUsersAPI gorestUsersAPI;

    @Given("Put update user with valid json {string} and user id {int}")
    public void putUpdateUserWithValidJsonAndUserId(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        gorestUsersAPI.putUpdateUser(jsonFile, id);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when()
                .put(GorestUsersAPI.UPDATE_USER);
    }

    @Given("Update user with invalid JSON {string} and valid user id {int}")
    public void updateUserWithInvalidJSONAndValidUserId(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        gorestUsersAPI.putUpdateUser(jsonFile, id);
    }

    @Given("Patch update user with valid json {string} and user id {int}")
    public void patchUpdateUserWithValidJsonAndUserId(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        gorestUsersAPI.patchUpdateUser(jsonFile, id);
    }

    @When("Send request patch update user")
    public void sendRequestPatchUpdateUser() {
        SerenityRest.when()
                .patch(GorestUsersAPI.UPDATE_USER);
    }
}
