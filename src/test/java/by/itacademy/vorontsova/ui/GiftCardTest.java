package by.itacademy.vorontsova.ui;

import by.itacademy.vorontsova.driver.MyDriver;
import by.itacademy.vorontsova.pages.MegatopPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GiftCardTest extends BaseTest{

    MegatopPage megatopPage = new MegatopPage();

    @BeforeEach
    public void getUrl() {
        MyDriver.getDriver().get("https://megatop.by/");
    }

    @Test
    public void testCheckGiftCardWithEmptyValue() {
        megatopPage.clickConfirmMinsk();
        megatopPage.clickConfirmCookies();
        megatopPage.clickGiftCardLink();
        megatopPage.clickCheckBalance();
        String actual = MyDriver.getDriver().findElement(By.xpath("//*[contains(@class, 'v-messages__message')]")).getText();
        String expected = "Номер обязательное поле";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testCheckGiftCardWithPartialValue() {
        megatopPage.clickConfirmMinsk();
        megatopPage.clickConfirmCookies();
        megatopPage.clickGiftCardLink();
        megatopPage.enterGiftCardInputValue("12345");
        String actual = MyDriver.getDriver().findElement(By.xpath("//*[contains(@class, 'v-messages__message')]")).getText();
        String expected = "Введите полностью номер";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testCheckGiftCardWithInvalidValue() {
        megatopPage.clickConfirmMinsk();
        megatopPage.clickConfirmCookies();
        megatopPage.clickGiftCardLink();
        megatopPage.enterGiftCardInputValue("1234567890000");
        megatopPage.clickCheckBalance();
        String actual = MyDriver.getDriver().findElement(By.xpath("//*[contains(@class, 'gift__text gift__text--red pt-4 col col-12')]")).getText();
        Assertions.assertTrue(actual.contains("сертификат не найден"));
    }
}
