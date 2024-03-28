package starter.todos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetTodosIdStefDef {
    @Steps
    GorestTodosAPI gorestTodosAPI;

    @Given("Get user todos by id {int}")
    public void getSingleUserTodosByValidId(int id) {
        gorestTodosAPI.getTodosById(id);
    }

    @When("Send request get todos by id")
    public void sendRequestGetTodosById() {
        SerenityRest.when().get(GorestTodosAPI.TODOS_ID);
    }

    @When("Send request get todos by invalid method")
    public void sendRequestGetTodosByInvalidMethod() {
        SerenityRest.when().put(GorestTodosAPI.TODOS_ID);
    }
}
