package by.itacademy.vorontsova.ui;

import by.itacademy.vorontsova.pages.MegatopPage;
import by.itacademy.vorontsova.driver.MyDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class MegatopMenSectionTest extends BaseTest{

    MegatopPage megatopPage = new MegatopPage();

    @BeforeEach
    public void getUrl() {
        MyDriver.getDriver().get("https://megatop.by/");
    }
    @Test
    public void testItemNotAddedWithoutChosenParameter() {
        megatopPage.clickConfirmMinsk();
        megatopPage.clickConfirmCookies();
        megatopPage.clickMenSection();
        megatopPage.clickAccessories();
        megatopPage.clickBeltQuickFilter();
        megatopPage.clickAddToCartIcon();
        Assertions.assertFalse(megatopPage.isAddToCartButtonClickable());

    }

    @Test
    public void testAddItemToCart() {
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
        String actual = MyDriver.getDriver().findElement(By.xpath("//*[contains(@class, 'card mt-2')]")).getText();
        Assertions.assertTrue(actual.contains("Ремни"));

    }

}
