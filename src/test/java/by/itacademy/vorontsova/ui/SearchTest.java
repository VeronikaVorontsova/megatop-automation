package by.itacademy.vorontsova.ui;

import by.itacademy.vorontsova.pages.MegatopPage;
import by.itacademy.vorontsova.driver.SingletonDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTest extends BaseTest {
    MegatopPage megatopPage = new MegatopPage();
    private static final Logger logger = LogManager.getLogger();
    WebDriverWait wait = new WebDriverWait(SingletonDriver.getDriver(), Duration.ofSeconds(5));

    @BeforeEach
    public void getUrl() {
        SingletonDriver.getDriver().get("https://megatop.by/");
    }

    @Test
    public void testSearchNoResultsFound() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        megatopPage.clickConfirmMinsk();
        megatopPage.clickConfirmCookies();
        megatopPage.clickSearchButton();
        Assertions.assertTrue(megatopPage.isSearchTabAppears());
        megatopPage.enterSearchRequest("cevrf");
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'ml-4 my-auto catalog__title-count')]")));
        String actual = SingletonDriver.getDriver().findElement(By.xpath("//*[contains(@class, 'ml-4 my-auto catalog__title-count')]")).getText();
        Assertions.assertEquals("0", actual);
        logger.info("Test passed \n");
    }

    @Test
    public void testValidSearchResult() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        megatopPage.clickConfirmMinsk();
        megatopPage.clickConfirmCookies();
        megatopPage.clickSearchButton();
        Assertions.assertTrue(megatopPage.isSearchTabAppears());
        megatopPage.enterSearchRequest("Сумка");
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'ml-4 my-auto catalog__title-count')]")));
        String actual = SingletonDriver.getDriver().findElement(By.xpath("//*[contains(@class, 'ml-4 my-auto catalog__title-count')]")).getText();
        Assertions.assertNotEquals("0", actual);
        logger.info("Test passed \n");
    }


}
