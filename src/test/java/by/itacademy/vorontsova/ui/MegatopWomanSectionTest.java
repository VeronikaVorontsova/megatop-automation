package by.itacademy.vorontsova.ui;

import by.itacademy.vorontsova.pages.MegatopPage;
import by.itacademy.vorontsova.driver.MyDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MegatopWomanSectionTest extends BaseTest {
    MegatopPage megatopPage = new MegatopPage();

    @BeforeEach
    public void getUrl() {
        MyDriver.getDriver().get("https://megatop.by/");
    }

    @Test
    public void testWomenShoesPopupWithSubcategories() {
        megatopPage.clickConfirmMinsk()
                .clickConfirmCookies()
                .hoverWomenShoes();

        String expected = "[Босоножки, Ботинки, Домашние тапочки, Кеды, Кроссовки, Лоферы, Полуботинки, Полусапоги, Полусапоги домашние, Сабо, Сапоги, Сланцы, Туфли]";
        String actual = String.valueOf(megatopPage.getWomenShoesSubsectionTitleText());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testUnauthorizedAddToFavorite() {
        megatopPage.clickConfirmMinsk();
        megatopPage.clickConfirmCookies();
        megatopPage.clickAccessories();
        megatopPage.clickFavorite();
        Assertions.assertEquals("Необходимо авторизоваться", megatopPage.getTextNotAuthorizedWarning());
    }

    @Test
    public void testFilters() throws InterruptedException {
        megatopPage.clickConfirmMinsk();
        megatopPage.clickConfirmCookies();
        megatopPage.clickWomenShoes();
        megatopPage.chooseBootsCategory();
        Assertions.assertTrue(megatopPage.isCategoryChosen());
        megatopPage.chooseColor();
        Assertions.assertTrue(megatopPage.isColorChosen());
        Thread.sleep(200);
        String actual = String.valueOf(megatopPage.getWomenShoesFilterResult());

        Assertions.assertTrue(actual.contains("Ботинки"));

    }
}
