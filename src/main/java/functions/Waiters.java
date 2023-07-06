package functions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.function.Function;

public class Waiters {
    static final Logger logger = LoggerFactory.getLogger(Waiters.class);
    private final WebDriver driver;
    private static final long EXPLICITY_WAIT = 20L;

    public Waiters(WebDriver driver) {
        this.driver = driver;
    }

    private FluentWait<WebDriver> fluentWait(Long duration) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    private void waitForFunction(Function function, Long timeOutInSeconds) {
        logger.info("Waiting for function");
        FluentWait<WebDriver> wait = fluentWait(timeOutInSeconds);
        wait.until(function);
    }

    public void waitForVisibilityOfElement(WebElement element) {
        logger.info("Waiting for visability of element");
        waitForFunction(ExpectedConditions.visibilityOf(element), EXPLICITY_WAIT);
    }

    public void waitForVisibilityOfElement(By by) {
        logger.info("Waiting for visability of element" + by.toString());
        waitForFunction(ExpectedConditions.visibilityOf(driver.findElement(by)), EXPLICITY_WAIT);
    }

    public void waitForPresenceOfElement(By by) {
        logger.info("Waiting for presence of element located by: " + by.toString());
        waitForFunction(ExpectedConditions.presenceOfElementLocated(by), EXPLICITY_WAIT);
    }

    public WebElement waitForPresenceOfElementReturn(By by) {
        logger.info("Waiting for presence of element located by" + by.toString());
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForPresenceOfElementReturn(WebElement element) {
        logger.info("Waiting for presence of element located by" + element.toString());
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForVisibilityOfElementReturn(WebElement element) {
        logger.info("Waiting for visability of element located by" + element.toString());
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForVisibilityOfElementReturn(By by) {
        logger.info("Waiting for visibility of element located by: " + by.toString());
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    public void waitForTextToBePresentInElementValue(WebElement element, String text) {
        logger.info("Waiting for text '" + text + "' to be present in element value: " + element.toString());
        waitForFunction(ExpectedConditions.textToBePresentInElementValue(element, text), EXPLICITY_WAIT);
    }

    public void waitForTextToBePresentInElementValue(WebElement element) {
        String expectedText = "Expected Text";
        logger.info("Waiting for text '" + expectedText + "' to be present in element value: " + element.toString());
        waitForFunction(ExpectedConditions.textToBePresentInElementValue(element, expectedText), EXPLICITY_WAIT);
    }
    public void waitForInvisibilityOf(WebElement element) {
        logger.info("Waiting for invisibility of element: " + element.toString());
        waitForFunction(ExpectedConditions.invisibilityOf(element), EXPLICITY_WAIT);
    }

    public void waitForInvisibilityOf(By by) {
        logger.info("Waiting for invisibility of element located by: " + by.toString());
        waitForFunction(ExpectedConditions.invisibilityOfElementLocated(by), EXPLICITY_WAIT);
    }

    public void waitForTitleContains(String text) {
        logger.info("Waiting for title to contain: " + text);
        waitForFunction(ExpectedConditions.titleContains(text), EXPLICITY_WAIT);
    }

    public WebElement waitForPresenceOfElementLocated(By by) {
        logger.info("Waiting for presence of element located by" + by.toString());
        return fluentWait(EXPLICITY_WAIT)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitSomeSecond(int seconds) {
        int milisecond = seconds * 1000;
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        logger.info("Waiting for element to be clickable: " + element.toString());
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeClickable(By by) {
        logger.info("Waiting for element to be clickable: " + by.toString());
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }

    public void waitForElementToBeSelected(By by) {
        logger.info("Waiting for element to be selected: " + by.toString());
        waitForFunction(ExpectedConditions.elementToBeSelected(driver.findElement(by)), EXPLICITY_WAIT);
    }

    public void waitForFrameAndSwitchXpath(String xpath) {
        logger.info("Waiting for presence of frame located by" + xpath);
        waitForPresenceOfElementLocated(By.xpath(xpath));
        waitForFunction(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(By.xpath(xpath)), EXPLICITY_WAIT);
    }
}


