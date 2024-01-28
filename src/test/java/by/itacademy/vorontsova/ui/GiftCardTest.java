package by.itacademy.vorontsova.ui;

import by.itacademy.vorontsova.driver.SingletonDriver;
import by.itacademy.vorontsova.pages.MegatopPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GiftCardTest extends BaseTest{

    MegatopPage megatopPage = new MegatopPage();
    private static final Logger logger = LogManager.getLogger();


    @BeforeEach
    public void getUrl() {
        SingletonDriver.getDriver().get("https://megatop.by/");
    }

    @Test
    public void testCheckGiftCardWithEmptyValue() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        megatopPage.clickConfirmMinsk();
        megatopPage.clickConfirmCookies();
        megatopPage.clickGiftCardLink();
        megatopPage.clickCheckBalance();
        String actual = SingletonDriver.getDriver().findElement(By.xpath("//*[contains(@class, 'v-messages__message')]")).getText();
        String expected = "Номер обязательное поле";
        Assertions.assertEquals(expected, actual);
        logger.info("Test passed \n");

    }

    @Test
    public void testCheckGiftCardWithPartialValue() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        megatopPage.clickConfirmMinsk();
        megatopPage.clickConfirmCookies();
        megatopPage.clickGiftCardLink();
        megatopPage.enterGiftCardInputValue("12345");
        String actual = SingletonDriver.getDriver().findElement(By.xpath("//*[contains(@class, 'v-messages__message')]")).getText();
        String expected = "Введите полностью номер";
        Assertions.assertEquals(expected, actual);
        logger.info("Test passed \n");

    }

    @Test
    public void testCheckGiftCardWithInvalidValue() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        megatopPage.clickConfirmMinsk();
        megatopPage.clickConfirmCookies();
        megatopPage.clickGiftCardLink();
        megatopPage.enterGiftCardInputValue("1234567890000");
        megatopPage.clickCheckBalance();
        String actual = SingletonDriver.getDriver().findElement(By.xpath("//*[contains(@class, 'gift__text gift__text--red pt-4 col col-12')]")).getText();
        Assertions.assertTrue(actual.contains("сертификат не найден"));
        logger.info("Test passed \n");
    }
}
