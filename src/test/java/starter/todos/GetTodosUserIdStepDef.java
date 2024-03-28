package starter.todos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetTodosUserIdStepDef {
    @Steps
    GorestTodosAPI gorestTodosAPI;
    @Given("Get user todos by user id {int}")
    public void getUserTodosByValidUserId(int userId) {
        gorestTodosAPI.getTodosByUserId(userId);
    }

    @When("Send request get todos by user id")
    public void sendRequestGetTodosByUserId() {
        SerenityRest.when().get(GorestTodosAPI.TODOS_USERID);

    }

}
