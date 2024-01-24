package by.itacademy.vorontsova.ui;

import by.itacademy.vorontsova.MegatopElements;
import by.itacademy.vorontsova.MyDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class MegatopWomanSectionTest extends BaseTest {
    MegatopElements megatopElements = new MegatopElements();

    @BeforeEach
    public void getUrl() {
        MyDriver.getDriver().get("https://megatop.by/");
    }

    @Test
    public void testWomenShoesPopupWithSubcategories() {
        megatopElements.clickConfirmMinsk()
                       .clickConfirmCookies()
                       .hoverWomenShoes();

        String expected = "[Босоножки, Ботинки, Домашние тапочки, Кеды, Кроссовки, Лоферы, Полуботинки, Полусапоги, Полусапоги домашние, Сабо, Сапоги, Сланцы, Туфли]";
        String actual = String.valueOf(megatopElements.getWomenShoesSubsectionTitleText());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testUnauthorizedAddToFavorite() {
        megatopElements.clickConfirmMinsk();
        megatopElements.clickConfirmCookies();
        megatopElements.clickAccessories();
        megatopElements.clickFavorite();
        Assertions.assertEquals("Необходимо авторизоваться", megatopElements.getTextNotAuthorizedWarning());
    }

    @Test
    public void testFilters() throws InterruptedException {
        megatopElements.clickConfirmMinsk();
        megatopElements.clickConfirmCookies();
        megatopElements.clickWomenShoes();
        megatopElements.chooseBootsCategory();
        Assertions.assertTrue(megatopElements.isCategoryChosen());
        megatopElements.chooseColor();
        Assertions.assertTrue(megatopElements.isColorChosen());
        Thread.sleep(200);
        //WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(5));
        //wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        String actual = String.valueOf(megatopElements.getWomenShoesFilterResult());

        Assertions.assertTrue(actual.contains("Ботинки"));

    }
}
