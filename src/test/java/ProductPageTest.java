import base.BaseTest;
import org.testng.annotations.Test;



public class ProductPageTest extends BaseTest {
    @Test
    public void checkProductsSearchOnPageByURL() {
        productPage.openHomePage();
        productPage.productSelectOnHeader();
        productPage.selectpersonalHygiene();
        productPage.selectSoupHandAndDisinfection();
        assertions.equalsUrl("https://pampik.com/ua/category/myilo-dlya-ruk-i-dezinfektsiya");
    }

    @Test
    public void checkProductsSearchThroughSearchBarByURL() {
        productPage.openHomePage();
        productPage.inputSearchProductInSearchBar("Одяг");
        productPage.searchButtonClick();
        assertions.equalsUrl("https://pampik.com/ua/category/odezda-pampik-fashion");
    }

    @Test
    public void checkTransitionToPageOfSelectedProductByURL() {
        productPage.openProductsPage();
        productPage.scrollPage();
        productPage.clickOnSelectionProduct();
        assertions.equalsUrl("https://pampik.com/ua/catalog/zidkoe-mylo-safeguard-klassiceskoe-225-ml");
    }

    @Test
    public void checkAddProductToCartByCartCounter() {
        productPage.openProductsPage();
        productPage.scrollPage();
        productPage.addProductToCart();
        productPage.getIntFromCounter();
        assertions.assertCounterStatus(productPage.getIntFromCounter());
    }

    @Test
    public void checkAdditionGoodsToCartByCounterOnPage() {
        productPage.openProductsPage();
        productPage.scrollPage();
        productPage.addProductToCart();
        productPage.plusClick(3);
        productPage.scrollPageUp();
        productPage.productPurchaseAndAddToCart();
        cartPage.getReadingOfFirstCartCounter();
    }
}

