package starter.users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteUsersStepDef {

    @Steps
    GorestUsersAPI gorestUsersAPI;

    @Given("Delete single user with valid user id {int}")
    public void deleteSingleUserWithValidUserId(int id) {
        gorestUsersAPI.deleteUser(id);
    }


    @When("Send request delete single user")
    public void sendRequestDeleteSingleUser() {
        SerenityRest.when()
                .delete(GorestUsersAPI.DELETE_USER);
    }

    @Given("Delete single user with invalid user id {}")
    public void deleteSingleUserWithInvalidUserId(int id) {
        gorestUsersAPI.deleteUser(id);
    }
}
