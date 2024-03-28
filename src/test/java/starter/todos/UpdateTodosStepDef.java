package starter.todos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class UpdateTodosStepDef {
    @Steps
    GorestTodosAPI gorestTodosAPI;
    @Given("Update todos with id {int} and json {string}")
    public void updateUserWithValidIdAndJson(int id, String json) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        gorestTodosAPI.updateTodos(id,jsonFile);
    }

    @When("Send request to update todos")
    public void sendRequestToUpdateTodos() {
        SerenityRest.when().put(GorestTodosAPI.TODOS_ID);
    }
}
