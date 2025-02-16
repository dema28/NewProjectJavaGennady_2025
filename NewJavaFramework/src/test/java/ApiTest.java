import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {
    @Test
    void createUser() {
        String body = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }""";

        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/") // Исправленный URL
                .header("Content-Type", "application/json") // Можно сократить
                .header("accept", "application/json")
//                .contentType("application/json") // Можно сократить
//                .accept("application/json")
                .body(body)
                .when()
                .post("user")
                .andReturn();
//                .then()
//                .log().all() // Логируем ответ
//                .extract().response();
//        response.then().statusCode(200); // Проверяем код ответа
//        System.out.println(response.body().prettyPrint()); // Выводим ответ в удобочитаемом виде
        int actualCode = response.getStatusCode();
        Assertions.assertEquals(200, actualCode);
    }
}

