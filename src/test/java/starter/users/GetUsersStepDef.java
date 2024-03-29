package starter.users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class GetUsersStepDef {

    @Steps
    GorestUsersAPI gorestUsersAPI;

    @Given("Get user without parameter")
    public void getUserWithoutParameter() {
        gorestUsersAPI.getListUsers();
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when()
                .get(GorestUsersAPI.LIST_USERS);
    }

    @Given("Get list user with valid parameter page {int} and per_page {int}")
    public void getListUserWithValidParameterPageAndPerPage(int page, int per_page) {
        gorestUsersAPI.getListUserWithPage(page, per_page);
    }

    @When("Send request get list user by page")
    public void sendRequestGetListUserByPage() {
        SerenityRest.when()
                .get(GorestUsersAPI.LIST_USERS_PAGED);
    }

    @Given("Get list user with invalid parameter page {int} and per_page {int}")
    public void getListUserWithInvalidParameterPageAndPer_page(int page, int per_page) {
        gorestUsersAPI.getListUserWithPage(page, per_page);
    }

    @Given("Get user with valid parameter id {int}")
    public void getUserWithValidParameterId(int id) {
        gorestUsersAPI.getUserWithId(id);
    }

    @When("Send request get user")
    public void sendRequestGetUser() {
        SerenityRest.when()
                .get(GorestUsersAPI.SINGLE_USERS);
    }

    @Given("Get user with invalid parameter id {int}")
    public void getUserWithInvalidParameterId(int id) {
        gorestUsersAPI.getUserWithId(id);
    }

}
