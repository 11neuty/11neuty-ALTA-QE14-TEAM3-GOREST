package starter.todos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.induk.GorestTodosAPI;

public class AllTodosStepDef {
    @Steps
    GorestTodosAPI gorestTodosAPI;

    @Given("Get all todos with valid page")
    public void getAllTodosWithValidPage() {
        gorestTodosAPI.getAllUserTodos();
    }

    @When("Send request get all todos")
    public void sendRequestGetAllTodos() {
        SerenityRest.when().get(GorestTodosAPI.ALL_TODOS);
    }
}
