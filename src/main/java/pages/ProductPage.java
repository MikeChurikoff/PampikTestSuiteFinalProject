package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private static class Locators {
        private final static By productCategorySelectionButtonLocator = By.xpath("//*[@id=\"category-menu\"]/ul/li[8]/a");
        private final static By personalHygieneBlockLocator = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[3]/ul/li[2]/a[2]");
        private final static By soupHandAndDisinfectionLocator = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[3]/ul/li[1]/a[2]");
        private final static By productTileLocator = By.xpath("//*[@id=\"products-list\"]/li[1]/div");
        private final static By inputSearchFormLocator = By.xpath("//*[@id=\"search-form__input\"]");
        private final static By buttonSearchFormLocator = By.xpath("//*[@id=\"search-form\"]/div[1]/button");
        private final static By buyButtonLocator = By.xpath("//*[@id=\"products-list\"]/li[1]/div/div[2]/span[2]/div");///*[@id="65004"]/
        private final static By productPurchaseBuyButtonLocator = By.xpath("//*[@id=\"cart-block\"]/a[1]");
        private final static By counterOfSelectedProductsToCartLocator = By.xpath("//*[@id=\"products-list\"]/li[1]/div/div[2]/span[2]/div/div/div/input");
        private final static By selectedProductTileLocator = By.xpath("//*[@id=\"products-list\"]/li[1]/div/a");
        private final static By plusButtonLocator = By.xpath("//*[@id=\"products-list\"]/li[1]/div/div[2]/span[2]/div/div/div/button[2]");
        private final static By minusButtonLocator = By.xpath("//*[@id=\"product-block\"]/div[2]/div[2]/div[2]/div[1]/div/div/button[1]");

    }

    private static class Labels {
        private final static String urlHomePage = "https://pampik.com/ua";
        private final static String urlProductsPage = "https://pampik.com/ua/category/myilo-dlya-ruk-i-dezinfektsiya";
        private final static String urlCartPage = "https://pampik.com/ua/cart";
    }

    public void openProductsPage() {
        driver.get(Labels.urlProductsPage);
    }

    public void openHomePage() {
        driver.get(Labels.urlHomePage);
    }

    public void openCartePage() {
        driver.get(Labels.urlCartPage);
    }

    public void productSelectOnHeader() {
        elements.clickOnElement(Locators.productCategorySelectionButtonLocator);
    }

    public void selectpersonalHygiene() {
        elements.clickOnElement(Locators.personalHygieneBlockLocator);
    }

    public void selectSoupHandAndDisinfection() {
        elements.clickOnElement(Locators.soupHandAndDisinfectionLocator);
    }

    public void inputSearchProductInSearchBar(String text) {
        By inputSearch = Locators.inputSearchFormLocator;
        action.performInputSendKeys(inputSearch, text);
    }

    public void searchButtonClick() {
        elements.clickOnElement(Locators.buttonSearchFormLocator);
    }

    public void addProductToCart() {
        action.hoverOnElement(Locators.productTileLocator);
        elements.clickOnElement(Locators.buyButtonLocator);
    }

    public void productPurchaseAndAddToCart() {
        action.hoverOnElement(Locators.productPurchaseBuyButtonLocator);
        elements.clickOnElement(Locators.productPurchaseBuyButtonLocator);
    }

    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    public void scrollPageUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-300)");
    }

    public int getIntFromCounter() {
        WebElement counter = elements.findElement(Locators.counterOfSelectedProductsToCartLocator);
        wait.waitForPresenceOfElementReturn(counter);
        String dataCurrentValue = counter.getAttribute("data-current");
        return Integer.parseInt(dataCurrentValue);
    }

    public void plusClick(int count) {
        for (int i = 0; i < count; i++) {
            elements.clickOnElement(Locators.plusButtonLocator);
        }
        wait.waitSomeSecond(3);
    }

    public void clickOnSelectionProduct() {
        elements.clickOnElement(Locators.selectedProductTileLocator);
    }
}





