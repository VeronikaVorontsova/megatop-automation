package by.itacademy.vorontsova.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class MegatopLogin {
    @Test
    public void testLoginIncorrect() {
        String body = "{\n" +
                "    \"email\": \"375998888889\",\n" +
                "    \"password\": \"99999999998888\"\n" +
                "}";
        given().
                body(body).
                header("content-type", "application/json").
        when().
                post("https://admin.megatop.by/api/v1/user/login").
        then().
                assertThat().
                statusCode(422).
                body("message", equalTo("Вы ввели неверный номер телефона и/или пароль"));
    }

    @Test
    public void testEmptyLoginData() {
        String body = "{\n" +
                "    \"email\": \"\",\n" +
                "    \"password\": \"\"\n" +
                "}";
        given().
                body(body).
                header("content-type", "application/json").
                when().
                post("https://admin.megatop.by/api/v1/user/login").
                then().
                assertThat().
                statusCode(500);

    }
}
