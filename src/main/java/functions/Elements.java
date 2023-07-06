package functions;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;

public class Elements {
    static final Logger logger = LoggerFactory.getLogger(Elements.class);
    private final WebDriver driver;
    private final Waiters waiters;

    public Elements(WebDriver driver) {
        this.driver = driver;
        waiters = new Waiters(driver);
    }
    public WebElement findElement(By by) {
        try {
            waiters.waitForVisibilityOfElement(by);
            return driver.findElement(by);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }
    public WebElement findElementByXpath(String xpath) {
        try {
            waiters.waitForVisibilityOfElement(By.xpath(xpath));
            return driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getElementText(WebElement element) {
        waiters.waitForVisibilityOfElement(element);
        logger.info("Getting text from element");
        return element.getText();
    }
    public String getElementText(By by) {
        waiters.waitForVisibilityOfElement(by);
        logger.info("Getting text from element");
        return driver.findElement(by).getText();
    }
    public String getTitleOfPage() {
        return driver.getTitle();
    }
    public void clickOnElement(WebElement element) {
        logger.info("Clicking on element: " + element.toString());
        waiters.waitForVisibilityOfElement(element);
        element.click();
    }
    public void clickOnElement(By by) {
        WebElement element = waiters.waitForElementToBeClickable(by);
        logger.info("Click on element located by" + by);
        element.click();
    }
    public void clickOnElementByXpath(String xpath) {
        findElementByXpath(xpath).click();
    }
     public void clickOnElementInsideFrameXpath(String xpathFrame, String xpathElement){
         waiters.waitForFrameAndSwitchXpath(xpathFrame);
         WebElement element =findElementByXpath(xpathElement);
         element.click();
     }
    public boolean isElementDisplayed(String xpath) {
        return findElementByXpath(xpath).isDisplayed();
    }
    public boolean isElementDisplayed(WebElement element) {
        try {
            waiters.waitForVisibilityOfElement(element);
            boolean isDisplayed = element.isDisplayed();
            if (isDisplayed) {
                logger.info("Element is displayed");
            }
            return isDisplayed;
        } catch (NoSuchElementException e) {
            logger.error("Element not found or not displayed");
            e.printStackTrace();
            return false;
        }
    }
   public int getIntFromCounter(By locator) {
        return Integer.parseInt(getElementText(locator));
    }

    public void closeDriver(){
        driver.quit();
    }
}
