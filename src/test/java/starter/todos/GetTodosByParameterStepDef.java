package starter.todos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;


public class GetTodosByParameterStepDef {
    @Steps
    GorestTodosAPI gorestTodosAPI;

    @Given("Get user todos by valid page {int}  per_page {int}")
    public void getUserTodosByValidPagePer_page(int page, int per_page) {
        gorestTodosAPI.getTodosByParameter(page,per_page);
    }

    @When("Send request get todos by parameter")
    public void sendRequestGetTodosByParameter() {
        SerenityRest.when().get(GorestTodosAPI.TODOS_PARAM);
    }
}
