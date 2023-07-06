package base;

import driver.DriverFactory;
import functions.Action;
import functions.Assertions;
import functions.Elements;
import functions.Waiters;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import pages.BasePage;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.TestResultListener;


@Listeners(TestResultListener.class)

public class BaseTest {
    static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver = DriverFactory.startChromeDriver();
    protected BasePage basePage = new BasePage(driver);
    protected Action action= new Action(driver);
    protected Assertions assertions = new Assertions(driver);
    protected Elements elements = new Elements(driver);
    protected Waiters waiters = new Waiters(driver);
    protected HomePage homePage = new HomePage(driver);
    protected ProductPage productPage = new ProductPage(driver);
    protected CartPage cartPage = new CartPage(driver);


    @AfterSuite
    public void closeDriver(){
        logger.info("CLOSING DRIVER");
        driver.quit();
    }
}
