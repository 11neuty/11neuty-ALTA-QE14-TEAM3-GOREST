package starter.posts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class GoRestPostAPI {
    public static String LIST_USER_POST = Constants.BASE_URL + "/users/{id}/posts";
    public static String LIST_USER_POST_WITHOUT_PARAMETER = Constants.BASE_URL + "/posts";
    public static String UPDATE_POSTS = Constants.BASE_URL + "/posts/{id}";
    public static String CREATE_POSTS = Constants.BASE_URL + "/users/{userid}/posts";
    public static String DELETE_POSTS = Constants.BASE_URL + "/posts/{userid}";

    @Step("Get list user posts with valid parameter")
    public void getListUserPosts(int id) {

        SerenityRest.given()
                .header("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("id", id);
    }

    @Step("Get list user posts with invalid parameter")
    public void getListUserPostsInvalid(String invalidId) {
        SerenityRest.given()
                .header("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("id", invalidId);
    }

    @Step("Get users posts without parameter")
    public void getListUserPostWithoutParameter() {
        SerenityRest.given()
                .header("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .get(LIST_USER_POST_WITHOUT_PARAMETER);
    }

    @Step("Update user with valid json and user id")
    public void postUpdatePosts(int id, File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("id", id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Update user with invalid id")
    public void postUpdatePostsInvalidId(String id, File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("id", id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Create new posts with valid body")
    public void postCreatePosts(int userid, File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("userid", userid)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Delete user post with valid id")
    public void deletePostsValidId(int id) {
        SerenityRest.given()
                .header("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("userid", id);
    }

    @Step("Delete user post with valid id")
    public void deletePostsInvalidId(String id) {
        SerenityRest.given()
                .header("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("userid", id);
    }
}
