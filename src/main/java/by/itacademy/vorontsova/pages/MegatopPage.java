package by.itacademy.vorontsova.pages;

import by.itacademy.vorontsova.driver.SingletonDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MegatopPage {
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
    String colorBeigeInColor = "//input[contains(@role, 'checkbox') and contains(@value, 'bezhevyy')]";
    String colorWhiteInColor = "//input[contains(@role, 'checkbox') and contains(@value, 'belyy')]";
    String applyColorFilterButton = "//*[@id='filter-color']//span[@class='v-btn__content']//span[contains(text(), 'Применить')]";
    String numberOfChosenFiltersInColor = "//span[contains(@class, 'v-btn__content')]//div[contains(@class, 'btn__count ml-1')]//*[contains(text(), '2')]";
    String cardFilterResult = "//a[*[contains(@class, 'pa-0 content__title col col-12')]]";
    String menSection = "//a[*[contains(.,'Мужчины')]]";
    String beltQuickFilter = "//a[*[contains(@class, 'slider__card-text ma-auto') and contains(.,'Ремни')]]";
    String beltFilterResult = "//*[contains(text(), 'Ремни') and @class='pa-0 content__title col col-12']";
    String addToCartIcon = "//button[contains(@class, 'basket v-btn v-btn--icon v-btn--round theme--light v-size--default')]";
    String addToCartButton = "//*[contains(concat(' ', normalize-space(@class), ' '), 'btn-gray')]";
    String beltSizeTable = "//*[contains(@role, 'list')]//*[contains(@class, 'v-data-table__wrapper')]";
    String chooseBeltSize = "//td[contains(@class,'text') and contains(text(), '120')]";
    String beltInCartPreview = "//*[contains(@class, 'product__text mr-1 my-auto') and contains(text(), 'Размер: 120')]";
    String previewPanel = "//*[contains(@class, 'v-navigation-drawer__content')]";
    String navigateToCartButton = "//button[contains(concat(' ', normalize-space(@class), ' '), 'btn-gray mt-5')]";
    String searchButton = "//button[contains(@class, 'px-0 btn-wrap v-btn v-btn--text theme--light v-size--default white--text')]";
    String searchInput = "//div[contains(@class,'search v-card')]//*[@type=\"text\"]";
    String searchTab = "//div[contains(@class,'search v-card')]";
    String giftCardLink = "//a[contains(.,'ПОДАРОЧНЫЕ КАРТЫ')]";
    String checkBalance = "//button[contains(.,'Проверить баланс')]";
    String giftCardField = "//input[contains(@type, 'text') and contains(@placeholder, 'XXXXXXXXXXXXX')]";


    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(SingletonDriver.getDriver(), Duration.ofSeconds(5));

    public MegatopPage() {
        this.driver = SingletonDriver.getDriver();
    }

    public MegatopPage clickConfirmMinsk() {
        driver.findElement(By.xpath(confirmMinsk)).click();
        return this;
    }

    public MegatopPage clickConfirmCookies() {
        driver.findElement(By.xpath(confirmCookies)).click();
        return this;
    }

    public MegatopPage hoverWomenShoes() {
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

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(accessoriesLink)));
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
        driver.findElement(By.xpath(colorBeigeInColor)).click();
        driver.findElement(By.xpath(colorWhiteInColor)).click();
        driver.findElement(By.xpath(applyColorFilterButton)).click();
    }

    public boolean isColorChosen() {
        return driver.findElement(By.xpath(numberOfChosenFiltersInColor)).isDisplayed();
    }


    public List<WebElement> getFilterResultList() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return driver.findElements(By.xpath(cardFilterResult));
    }

    public List<String> getWomenShoesFilterResult() {
        List<WebElement> cardsText = getFilterResultList();
        List<String> result = new ArrayList<>();
        for (WebElement cardResult : cardsText) {
            result.add(cardResult.getText());
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cardFilterResult)));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return result;
    }

    public void clickMenSection() {
        driver.findElement(By.xpath(menSection)).click();
    }

    public void clickBeltQuickFilter() {
        driver.findElement(By.xpath(beltQuickFilter)).click();

    }

    public void clickAddToCartIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beltFilterResult)));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath(addToCartIcon)).click();
    }

    public void clickAddToCartButton() {
        driver.findElement(By.xpath(addToCartButton)).click();
    }

    public boolean isAddToCartButtonClickable() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beltSizeTable)));
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

    public void clickSearchButton() {
        driver.findElement(By.xpath(searchButton)).click();
    }

    public boolean isSearchTabAppears() {
        return driver.findElement(By.xpath(searchTab)).isDisplayed();
    }

    public void enterSearchRequest(String text) {
        driver.findElement(By.xpath(searchInput)).sendKeys(text);
        driver.findElement(By.xpath(searchInput)).sendKeys(Keys.ENTER);

    }

    public void clickGiftCardLink() {
        driver.findElement(By.xpath(giftCardLink)).click();
    }

    public void clickCheckBalance() {
        driver.findElement(By.xpath(checkBalance)).click();
    }

    public void enterGiftCardInputValue(String text) {
        driver.findElement(By.xpath(giftCardField)).sendKeys(text);
    }


}



