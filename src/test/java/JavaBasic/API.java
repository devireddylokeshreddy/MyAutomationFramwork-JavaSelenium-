package JavaBasic;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class API {
    @Test
    public void getMethod(){
        baseURI = "https://reqres.in/";
        given().body("{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}").log().all().when().get("/api/login").then().log().all().assertThat().statusCode(200);

        given().contentType(ContentType.JSON).header("","").queryParam("","").pathParam("","").when().get().then().log().all().extract().response();
        Response response = given().body("{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}").log().all().when().get("/api/login").then().log().all().assertThat().statusCode(200).extract().response();
        JsonPath json = response.jsonPath();

    }
}
