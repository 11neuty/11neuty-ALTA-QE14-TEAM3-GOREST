package starter.todos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.induk.GorestTodosAPI;

public class DeleteTodosByIdStepDef {
    @Steps
    GorestTodosAPI gorestTodosAPI;
    @Given("Delete todos by id {int}")
    public void deleteTodosByValidId(int id) {
        gorestTodosAPI.deleteTodosById(id);
    }

    @When("Send request to delete todos")
    public void sendRequestToDeleteTodos() {
        SerenityRest.when().delete(GorestTodosAPI.TODOS_ID);
    }
}
