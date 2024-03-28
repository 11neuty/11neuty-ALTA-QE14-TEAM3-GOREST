package starter.todos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.utils.Constants;

import java.io.File;

public class CreateTodosStepDef {
    @Steps
    GorestTodosAPI gorestTodosAPI;

    @Given("Create todos by user id {int} and valid json {string}")
    public void createTodosByUserIdAndValidJson(int userId, String json) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        gorestTodosAPI.createTodos(userId, jsonFile);
    }

    @When("Send request create todos")
    public void sendRequestCreateTodos() {
        SerenityRest.when()
                .post(GorestTodosAPI.TODOS_USERID);
    }


}
