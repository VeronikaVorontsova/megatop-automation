package by.itacademy.vorontsova.ui;

import by.itacademy.vorontsova.pages.MegatopPage;
import by.itacademy.vorontsova.driver.SingletonDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MegatopWomanSectionTest extends BaseTest {
    MegatopPage megatopPage = new MegatopPage();
    private static final Logger logger = LogManager.getLogger();


    @BeforeEach
    public void getUrl() {
        SingletonDriver.getDriver().get("https://megatop.by/");
    }

    @Test
    public void testWomenShoesPopupWithSubcategories() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        megatopPage.clickConfirmMinsk()
                .clickConfirmCookies()
                .hoverWomenShoes();
        String expected = "[Босоножки, Ботинки, Домашние тапочки, Кеды, Кроссовки, Лоферы, Полуботинки, Полусапоги, Полусапоги домашние, Сабо, Сапоги, Сланцы, Туфли]";
        String actual = String.valueOf(megatopPage.getWomenShoesSubsectionTitleText());
        Assertions.assertEquals(expected, actual);
        logger.info("Test passed \n");
    }

    @Test
    public void testUnauthorizedAddToFavorite() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        megatopPage.clickConfirmMinsk();
        megatopPage.clickConfirmCookies();
        megatopPage.clickAccessories();
        megatopPage.clickFavorite();
        Assertions.assertEquals("Необходимо авторизоваться", megatopPage.getTextNotAuthorizedWarning());
        logger.info("Test passed \n");
    }

    @Test
    public void testFilters() throws InterruptedException {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
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
        logger.info("Test passed \n");

    }
}
