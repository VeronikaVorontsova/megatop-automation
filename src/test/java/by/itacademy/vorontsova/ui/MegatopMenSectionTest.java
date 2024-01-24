package by.itacademy.vorontsova.ui;

import by.itacademy.vorontsova.MegatopElements;
import by.itacademy.vorontsova.MyDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class MegatopMenSectionTest extends BaseTest{

    MegatopElements megatopElements = new MegatopElements();

    @BeforeEach
    public void getUrl() {
        MyDriver.getDriver().get("https://megatop.by/");
    }
    @Test

    public void testItemNotAddedWithoutChosenParameter() {
        megatopElements.clickConfirmMinsk();
        megatopElements.clickConfirmCookies();
        megatopElements.clickMenSection();
        megatopElements.clickAccessories();
        megatopElements.clickBeltQuickFilter();
        megatopElements.clickAddToCartIcon();
        Assertions.assertFalse(megatopElements.isAddToCartButtonClickable());

    }

    @Test
    public void testAddItemToCart() {
        megatopElements.clickConfirmMinsk();
        megatopElements.clickConfirmCookies();
        megatopElements.clickMenSection();
        Assertions.assertTrue(megatopElements.isManSectionSelected());
        megatopElements.clickAccessories();
        megatopElements.clickBeltQuickFilter();
        Assertions.assertTrue(megatopElements.isBeltFilterResultDisplayed("Ремни"));
        megatopElements.clickAddToCartIcon();
        megatopElements.clickBeltSize();
        Assertions.assertTrue(megatopElements.isAddToCartButtonClickable());
        megatopElements.clickAddToCartButton();
        Assertions.assertTrue(megatopElements.isPreviewPanelVisible());
        Assertions.assertTrue(megatopElements.isBeltAdded());
        megatopElements.clickNavigateToCart();
        String actual = MyDriver.getDriver().findElement(By.xpath("//*[contains(@class, 'card mt-2')]")).getText();
        Assertions.assertTrue(actual.contains("Ремни"));





    }

}
