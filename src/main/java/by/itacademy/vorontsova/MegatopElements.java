package by.itacademy.vorontsova;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MegatopElements {
    String confirmMinsk = "//span[contains(., 'Да') and @class='v-btn__content']";
    String confirmCookies = "//span[contains(., 'Согласен') and @class='v-btn__content']";
    String womenShoes = "//div[contains(., 'Обувь') and @class='d-flex align-center pr-6']";
    String womenShoeSubsectionTitles = "//*[@class='mb-1 catalog__sub-title']";
    String accessoriesLink = "//a[*[contains(.,'Аксессуары')]]";
    String addToFavoriteButton = "//button[contains(@class, 'favorite v-btn v-btn--icon v-btn--round theme--light v-size--default')]";
    String notAuthorizedWarning = "//span[contains(text(), 'Необходимо авторизоваться')]";
    String categoryFilterButton = "//span[contains(text(), 'Категория')]";
    String bootsInCategory = "//div[contains(@class, 'filter__text my-auto') and contains(text(), 'Ботинки')]";
    String applyCategoryFilterButton = "//span[@class='v-btn__content']//span[contains(text(), 'Применить')]";
    String numberOfChosenFiltersInCategory = "//span[contains(@class, 'v-btn__content')]//div[contains(@class, 'btn__count ml-1')]//*[contains(text(), '1')]";
    String colorFilterButton = "//span[contains(text(), 'Цвет')]";
    String colorBeigeInColor = "//div[contains(@class, 'filter__text my-auto') and contains(text(), 'Бежевый')]";
    String colorWhiteInColor = "//div[contains(@class, 'filter__text my-auto') and contains(text(), 'Белый')]";
    String applyColorFilterButton = "//*[@id='filter-color']//span[@class='v-btn__content']//span[contains(text(), 'Применить')]";
    String numberOfChosenFiltersInColor = "//span[contains(@class, 'v-btn__content')]//div[contains(@class, 'btn__count ml-1')]//*[contains(text(), '2')]";
    String cardFilterResult = "//div[@class='card d-flex flex-column v-card v-card--flat v-sheet theme--light']";
    String menSection = "//a[*[contains(.,'Мужчины')]]";
    String beltQuickFilter = "//span[contains(@class, 'slider__card-text ma-auto') and contains(text(), 'Ремни')]";
    String beltFilterResult = "//*[contains(text(), 'Ремни') and @class='pa-0 content__title col col-12']";
    String addToCartIcon = "//button[contains(@class, 'basket v-btn v-btn--icon v-btn--round theme--light v-size--default')]";
    String addToCartButton = "//*[contains(concat(' ', normalize-space(@class), ' '), 'btn-gray')]";
    String chooseBeltSize = "//td[contains(@class,'text') and contains(text(), '120')]";
    String beltInCartPreview = "//*[contains(@class, 'product__text mr-1 my-auto') and contains(text(), 'Размер: 120')]";
    String previewPanel = "//*[contains(@class, 'v-navigation-drawer__content')]";
    String navigateToCartButton = "//button[contains(concat(' ', normalize-space(@class), ' '), 'btn-gray mt-5')]";



    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(5));

    public MegatopElements() {
        this.driver = MyDriver.getDriver();
    }

    public MegatopElements clickConfirmMinsk() {
        driver.findElement(By.xpath(confirmMinsk)).click();
        return this;
    }

    public MegatopElements clickConfirmCookies() {
        driver.findElement(By.xpath(confirmCookies)).click();
        return this;
    }

    public MegatopElements hoverWomenShoes() {
        WebElement element = driver.findElement(By.xpath(womenShoes));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        return this;
    }


    public List<WebElement> getWomenShoesSubsectionTitles() {
        return driver.findElements(By.xpath(womenShoeSubsectionTitles));
    }

    public List<String> getWomenShoesSubsectionTitleText() {
        List<WebElement> subtitlesText = getWomenShoesSubsectionTitles();
        List<String> result = new ArrayList<>();
        for (WebElement subtitleText : subtitlesText) {
            result.add(subtitleText.getText());
        }
        return result;
    }

    public void clickAccessories() {
        driver.findElement(By.xpath(accessoriesLink)).click();
    }

    public void clickFavorite() {
        driver.findElement(By.xpath(addToFavoriteButton)).click();
    }

    public String getTextNotAuthorizedWarning() {
        return driver.findElement(By.xpath(notAuthorizedWarning)).getText();
    }

    public void clickWomenShoes() {
        driver.findElement(By.xpath(womenShoes)).click();
    }

    public void chooseBootsCategory() {
        driver.findElement(By.xpath(categoryFilterButton)).click();
        driver.findElement(By.xpath(bootsInCategory)).click();
        driver.findElement(By.xpath(applyCategoryFilterButton)).click();
    }

    public boolean isCategoryChosen() {
        return driver.findElement(By.xpath(numberOfChosenFiltersInCategory)).isDisplayed();
    }

    public void chooseColor() {
        driver.findElement(By.xpath(colorFilterButton)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(colorBeigeInColor)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(colorBeigeInColor)));
        driver.findElement(By.xpath(colorBeigeInColor)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(colorWhiteInColor)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(colorWhiteInColor)));
        driver.findElement(By.xpath(colorWhiteInColor)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(applyColorFilterButton)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(applyColorFilterButton)));
        driver.findElement(By.xpath(applyColorFilterButton)).click();
    }

    public boolean isColorChosen() {
        return driver.findElement(By.xpath(numberOfChosenFiltersInColor)).isDisplayed();
    }


    public List<WebElement> getFilterResultList() {
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(5));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return driver.findElements(By.xpath(cardFilterResult));
    }
    public List<String> getWomenShoesFilterResult() throws InterruptedException {
        List<WebElement> cardsText = getFilterResultList();
        List<String> result = new ArrayList<>();
        for (WebElement cardResult : cardsText) {
            result.add(cardResult.getText());
        }
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(5));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return result;
    }

    public void clickMenSection() {
        driver.findElement(By.xpath(menSection)).click();
    }

    public void clickBeltQuickFilter() {
        driver.findElement(By.xpath(beltQuickFilter)).click();
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(5));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void clickAddToCartIcon() {
        WebDriverWait wait = new WebDriverWait(MyDriver.getDriver(), Duration.ofSeconds(5));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath(addToCartIcon)).click();
    }

    public void clickAddToCartButton() {
        driver.findElement(By.xpath(addToCartButton)).click();
    }

    public boolean isAddToCartButtonClickable() {
        return driver.findElement(By.xpath(addToCartButton)).isEnabled();
    }

    public void clickBeltSize() {
        driver.findElement(By.xpath(chooseBeltSize)).click();
    }

    public boolean isBeltFilterResultDisplayed(String text) {

        return wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath(beltFilterResult)), text));
    }

    public boolean isManSectionSelected() {
        return wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath(menSection)), "class", "link-active"));
    }

    public boolean isPreviewPanelVisible() {
        WebElement panelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(previewPanel)));
       return panelElement.isDisplayed();

    }

    public boolean isBeltAdded() {
        WebElement beltInPreview = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beltInCartPreview)));
        return beltInPreview.isDisplayed();
    }

    public void clickNavigateToCart() {
        driver.findElement(By.xpath(navigateToCartButton)).click();
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    }


}



