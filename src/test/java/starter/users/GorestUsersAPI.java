package starter.users;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class GorestUsersAPI {
    public static String LIST_USERS = Constants.BASE_URL + "/users";
    public static String SINGLE_USERS = Constants.BASE_URL + "/users/{id}";
    public static String LIST_USERS_PAGED = Constants.BASE_URL + "/users?page={page}&per_page={per_page}";
    public static String CREATE_USER = Constants.BASE_URL + "/users";
    public static String UPDATE_USER = Constants.BASE_URL + "/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL + "/users/{id}";

    @Step("Get user without parameter (list user)")
    public void getListUsers() {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .get(LIST_USERS);
    }

    @Step("Get list user with page parameter")
    public void getListUserWithPage(int page, int per_page) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("page", page)
                .pathParam("per_page", per_page);
    }

    @Step("Get user with id")
    public void getUserWithId(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("id", id);
    }

    @Step("Create new user with valid body json")
    public void createNewUser(File JSON) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .contentType(ContentType.JSON)
                .body(JSON);
    }

    @Step("Put update user")
    public void putUpdateUser(File JSON, int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(JSON);
    }

    @Step("Patch update user")
    public void patchUpdateUser(File JSON, int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(JSON);
    }

    @Step("Delete user")
    public void deleteUser(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("id", id);
    }

}
