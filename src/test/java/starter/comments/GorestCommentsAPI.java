package starter.comments;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class GorestCommentsAPI {

    public static String LIST_COMMENT = Constants.BASE_URL + "/comments";
    public static String COMMENT_ID = Constants.BASE_URL + "/comments/{id}";

    public static String CREATE_COMMENT = Constants.BASE_URL + "/posts/{post_id}/comments";

    public static String UPDATE_COMMENT = Constants.BASE_URL + "/comments/{id}";

    public static String DELETE_COMMENT = Constants.BASE_URL + "/comments/{id}";


    @Step("Get list comments")
    public void getListComment() {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab");
    }

    @Step("Get comment")
    public void getComments(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("id", id);
    }

    @Step("Create comments")
    public void createComment(int post_id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("post_id", post_id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update Comment with valid JSON and user id")
    public void updateComment(File json, int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete comment")
    public void deleteComment(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer f32607836cefd0d47c45ebd5574c856c7212e0836385ec032f57085b567773ab")
                .pathParam("id", id);
    }


}
