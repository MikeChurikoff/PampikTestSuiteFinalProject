package driver;


import functions.Action;
import functions.Assertions;
import functions.Elements;
import functions.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final long IMPLICITY_WAIT = 20L;
    static Waiters wait;
    static Action action;
    static Assertions assertions;
    static Elements elements;
    private static WebDriver driver;

    static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    private static WebDriver setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new Waiters(driver);
        action = new Action(driver);
        assertions = new Assertions(driver);
        elements = new Elements(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            try {
                driver = setUpDriver();
                logger.info("Driver started");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static WebDriver startChromeDriver() {
        driver = getInstance();
        return driver;
    }


}
