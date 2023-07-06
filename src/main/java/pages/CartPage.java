package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {


    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static class Locators {
        private final static By addProductToCartByCartButtonLocator = By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[4]/div/a");
        private final static By deleteFromCartButtonLocator = By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div[4]/div/div[1]/section/div/div/section/div/div[3]/button");
        private final static By deleteFromCartConfirmButtonLocator = By.xpath(("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div[4]/div/div[1]/section/div/div/section/div/div[3]/section/button[2]"));
        private final static By isEmptyCartTextLocator = By.xpath(("//*[@id=\"root\"]/div[2]/div[2]/div/div[4]/div/p"));
        private final static By productTileInCartLocator = By.xpath("//*[@id=\"softcube_16865\"]/div/div/div[1]");
        private final static By buyButtonOnTileProductLocator = By.xpath("//*[@id=\"128720\"]");
        private final static By productPurchaseBuyButtonLocator = By.xpath("//*[@id=\"cart-block\"]/a[1]");
        private final static By counterOneOfGoodsInCartLocator = By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div[4]/div/div[1]/section/div/div/section/div/div[2]/div[1]/div/span");
        private final static By counterTwoOfGoodsInCartLocator = By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div[4]/div/div[2]/section/div/div/section/div/div[2]/div[1]/div/span");
        private final static By plusCounterOfGoodsInCartLocator = By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div[4]/div/div[1]/section/div/div/section/div/div[2]/div[1]/div/button[2]");
        private final static By minusCounterOfGoodsInCartLocator = By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div[4]/div/div[1]/section/div/div/section/div/div[2]/div[1]/div/button[1]");
        private final static By totalPriceLocator = By.cssSelector("span.total-price");
        private final static By removeProductButtonLocator = By.cssSelector("button.remove-product-button");
    }


    private static class Labels {
        private final static String urlHomePage = "https://pampik.com/ua";
        private final static String urlProductsPage = "https://pampik.com/ua/category/myilo-dlya-ruk-i-dezinfektsiya";
        private final static String urlCartPage = "https://pampik.com/ua/cart";
    }


    public void openCartPage() {
        driver.get(Labels.urlCartPage);
    }

    public void openHomePage() {
        driver.get(Labels.urlHomePage);
    }

    public void deleteProductFromCart() {
        elements.clickOnElement(Locators.deleteFromCartButtonLocator);
        elements.clickOnElement(Locators.deleteFromCartConfirmButtonLocator);
    }

    public void verifyEmptyCartTitle() {
        assertions.equalsOfText("Ваш кошик порожній", elements.getElementText(Locators.isEmptyCartTextLocator));
    }

    public int getIntFromCartCounter() {
        WebElement counter = elements.findElement(Locators.counterOneOfGoodsInCartLocator);
        String dataCurrentValue = counter.getText();
        String value = dataCurrentValue.replaceAll("\\D+", "");
        return Integer.parseInt(value);
    }

    public void addingProductToCartByCartButton() {
        elements.clickOnElement(Locators.addProductToCartByCartButtonLocator);
    }

    public void productPurchaseAndAddToCart() {
        action.hoverOnElement(Locators.productPurchaseBuyButtonLocator);
        elements.clickOnElement(Locators.productPurchaseBuyButtonLocator);
    }

    public void addProductToCart() {
        action.hoverOnElement(Locators.productTileInCartLocator);
        elements.clickOnElement(Locators.buyButtonOnTileProductLocator);
        wait.waitSomeSecond(3);
    }

    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
    }

    public void plusClick(int count) {
        for (int i = 0; i < count; i++) {
            elements.clickOnElement(Locators.plusCounterOfGoodsInCartLocator);
        }
        wait.waitSomeSecond(5);
    }

    public void getReadingOfFirstCartCounter() {
        int actualCounter = elements.getIntFromCounter(Locators.counterOneOfGoodsInCartLocator);
        assertions.assertCounterStatus(actualCounter);
    }

    public void getReadingOfSecondCartCounter() {
        int actualCounter = elements.getIntFromCounter(Locators.counterOneOfGoodsInCartLocator);
        assertions.assertCounterStatus(actualCounter);
    }

    public void scrollPageUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-400)");
    }
}






