package api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.Tests.AbstractTest;

import static api.RestSpec.installSpecification;
import static api.RestSpec.requestSpec;
import static io.restassured.RestAssured.given;

public class LinkApiTests extends AbstractTest {
    @Test
    @DisplayName("Created api test")
    public void createdLinkTest(){
        installSpecification(requestSpec());
        given()
                .when()
                .get("created")
                .then().log().all().statusCode(201);
    }

    @Test
    @DisplayName("No content api test")
    public void noContentApiTest(){
        installSpecification(requestSpec());
        given()
                .when()
                .get("no-content")
                .then().log().all().statusCode(204);
    }

    @Test
    @DisplayName("Moved api test")
    public void movedApiTest() {
        installSpecification(requestSpec());
        given()
                .redirects().follow(false)
                .when()
                .get("moved")
                .then().log().all().statusCode(301);
    }

    @Test
    @DisplayName("Bad request api test")
    public void badRequestTest(){
        installSpecification(requestSpec());
        given()
                .when()
                .get("bad-request")
                .then().log().all().statusCode(400);
    }

    @Test
    @DisplayName("Unauthorized api test")
    public void unauthorizedRequestTest(){
        installSpecification(requestSpec());
        given()
                .when()
                .get("unauthorized")
                .then().log().all().statusCode(401);
    }

    @Test
    @DisplayName("Forbidden api test")
    public void forbiddenRequestTest(){
        installSpecification(requestSpec());
        given()
                .when()
                .get("forbidden")
                .then().log().all().statusCode(403);
    }

    @Test
    @DisplayName("invalid-url api test")
    public void invalidUrlRequestTest(){
        installSpecification(requestSpec());
        given()
                .when()
                .get("invalid-url")
                .then().log().all().statusCode(404);
    }


}
