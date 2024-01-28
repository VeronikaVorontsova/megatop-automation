package by.itacademy.vorontsova.ui;

import by.itacademy.vorontsova.pages.MegatopPage;
import by.itacademy.vorontsova.driver.SingletonDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class MegatopMenSectionTest extends BaseTest{

    MegatopPage megatopPage = new MegatopPage();
    private static final Logger logger = LogManager.getLogger();


    @BeforeEach
    public void getUrl() {
        SingletonDriver.getDriver().get("https://megatop.by/");
    }
    @Test
    public void testItemNotAddedWithoutChosenParameter() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        megatopPage.clickConfirmMinsk();
        megatopPage.clickConfirmCookies();
        megatopPage.clickMenSection();
        megatopPage.clickAccessories();
        megatopPage.clickBeltQuickFilter();
        megatopPage.clickAddToCartIcon();
        Assertions.assertFalse(megatopPage.isAddToCartButtonClickable());
        logger.info("Test passed \n");


    }

    @Test
    public void testAddItemToCart() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        megatopPage.clickConfirmMinsk();
        megatopPage.clickConfirmCookies();
        megatopPage.clickMenSection();
        Assertions.assertTrue(megatopPage.isManSectionSelected());
        megatopPage.clickAccessories();
        megatopPage.clickBeltQuickFilter();
        Assertions.assertTrue(megatopPage.isBeltFilterResultDisplayed("Ремни"));
        megatopPage.clickAddToCartIcon();
        megatopPage.clickBeltSize();
        Assertions.assertTrue(megatopPage.isAddToCartButtonClickable());
        megatopPage.clickAddToCartButton();
        Assertions.assertTrue(megatopPage.isPreviewPanelVisible());
        Assertions.assertTrue(megatopPage.isBeltAdded());
        megatopPage.clickNavigateToCart();
        String actual = SingletonDriver.getDriver().findElement(By.xpath("//*[contains(@class, 'card mt-2')]")).getText();
        Assertions.assertTrue(actual.contains("Ремни"));
        logger.info("Test passed \n");

    }

}
