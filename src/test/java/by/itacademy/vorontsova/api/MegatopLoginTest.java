package by.itacademy.vorontsova.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MegatopLoginTest {

    private static final Logger logger = LogManager.getLogger();
    @Test

    public void testLoginIncorrect() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
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
        logger.info("Test passed \n");
    }

    @Test
    public void testEmptyLoginData() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
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
        logger.info("Test passed \n");
    }
}
