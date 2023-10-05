package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestSpec {
    public static RequestSpecification requestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri("https://demoqa.com/")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static void installSpecification(RequestSpecification requestSpecification){
        RestAssured.requestSpecification = requestSpecification;
    }
}
