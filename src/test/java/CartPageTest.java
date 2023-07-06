import base.BaseTest;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

    @Test
    public void checkIsСartEmpty() {
        cartPage.openCartPage();
        cartPage.verifyEmptyCartTitle();
    }

    @Test
    public void сhескAddingGoodToCartByCounter() {
        cartPage.openCartPage();
        cartPage.addingProductToCartByCartButton();
        productPage.productSelectOnHeader();
        productPage.selectpersonalHygiene();
        productPage.selectSoupHandAndDisinfection();
        productPage.scrollPage();
        productPage.addProductToCart();
        cartPage.openCartPage();
        cartPage.getReadingOfFirstCartCounter();
    }

    @Test
    public void сhескAddingGoodToCartFromCartByCounter() {
        productPage.openProductsPage();
        cartPage.scrollPage();
        productPage.addProductToCart();
        cartPage.scrollPageUp();
        cartPage.productPurchaseAndAddToCart();
        cartPage.getReadingOfFirstCartCounter();
        cartPage.scrollPage();
        cartPage.addProductToCart();
        cartPage.scrollPageUp();
        cartPage.getReadingOfSecondCartCounter();
    }

    @Test
    public void checkDeletingGoodFromCart() {
        productPage.openProductsPage();
        cartPage.scrollPage();
        productPage.addProductToCart();
        cartPage.scrollPageUp();
        cartPage.productPurchaseAndAddToCart();
        cartPage.deleteProductFromCart();
        cartPage.verifyEmptyCartTitle();
    }

    @Test
    public void checkAdditionGoodsToCart() {
        productPage.openProductsPage();
        cartPage.scrollPage();
        productPage.addProductToCart();
        cartPage.scrollPageUp();
        cartPage.productPurchaseAndAddToCart();
        cartPage.plusClick(3);
        cartPage.getReadingOfFirstCartCounter();
    }
}
