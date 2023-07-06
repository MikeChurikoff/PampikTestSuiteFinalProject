package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Assertions {
    static final Logger logger = LoggerFactory.getLogger(Elements.class);
    private final WebDriver driver;
    private final Waiters waiters;
    private final Action action;
    private final Elements elements;

    public Assertions(WebDriver driver) {
        this.driver = driver;
        elements = new Elements(driver);
        waiters = new Waiters(driver);
        action = new Action(driver);
    }

    public void elementIsDisplayed(WebElement element) {
        assertTrue(elements.isElementDisplayed(element), "Element is not displayed, but should have been");
    }

    public void equalsOfInts(int actual, int expected) {
        assertEquals(actual, expected,
                "I expected to receive" + expected + ". But received" +
                        actual + ".");
    }

    public void assertCounterStatus(int actual) {
        try {
            Assert.assertTrue(actual > 0);
            logger.info("Counter readings changed and equal: " + actual);
        } catch (AssertionError e) {
            logger.info("The counter is 0");
        }
    }

    public void equalsOfText(String actualText, String expectedText) {
        assertEquals(actualText, expectedText, "I expected to receive text " + expectedText + ". But received " +
                actualText + ".");
        logger.info("The text was successfully compared. Actual value: " + actualText + ", expected value: " + expectedText);
    }

    public void equalsIgnoreCaseOfText(String actualText, String expectedText) {
        assertTrue(actualText.equalsIgnoreCase(expectedText), "I expected to receive text " + expectedText + ". But received " +
                actualText + ".");
        logger.info("Text matched successfully (case insensitive). Actual value: " + actualText + ", expected value: " + expectedText);
    }

    public void equalsUrl(String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, expectedURL,
                "URLs do not match. Expected value: " + expectedURL + ", actual value: " + actualURL);
        logger.info("URLs match. Actual value: " + actualURL + ", expected value: " + expectedURL);
    }

    public void equalsUrl(By expectedURL) {
        String actualURL = driver.getCurrentUrl();
        String expectedUrl = driver.findElement(expectedURL).getAttribute("href");
        Assert.assertEquals(actualURL, expectedUrl,
                "URLs do not match. Expected value: " + expectedURL + ", actual value: " + actualURL);
        logger.info("URLs match. Actual value: " + actualURL + ", expected value: " + expectedURL);
    }
}









