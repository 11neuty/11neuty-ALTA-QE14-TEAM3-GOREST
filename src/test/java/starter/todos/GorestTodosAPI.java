package starter.todos;

import io.cucumber.java.eo.Se;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class GorestTodosAPI {
    public static String ALL_TODOS = Constants.BASE_URL + "/todos";

    public static String TODOS_ID = Constants.BASE_URL + "/todos/{id}";

    public static String TODOS_USERID = Constants.BASE_URL + "/users/{userId}/todos";

    public static String TODOS_PARAM = Constants.BASE_URL + "/todos?page={page}&per_page={per_page}";

    @Step("Get all user todos")
    public void getAllUserTodos() {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab");
    }

    @Step("Get single todos by valid id")
    public void getTodosById(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("id", id);
    }

    @Step("Get single todos by valid user id")
    public void getTodosByUserId(int userId) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("userId", userId);
    }

    @Step("Create todos by valid user id and json")
    public void createTodos(int userId, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("userId", userId)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Update todos by valid id and json")
    public void updateTodos(int id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("id", id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Delete todos by valid id")
    public void deleteTodosById(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("id", id);
    }

    @Step("Get todos by parameter")
    public void getTodosByParameter(int page, int per_page) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("page", page)
                .pathParam("per_page", per_page);
    }

}
