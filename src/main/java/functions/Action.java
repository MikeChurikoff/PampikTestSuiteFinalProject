package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {
    private final Elements elements;
    private final Actions actions;
    private final WebDriver driver;

    public Action(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        elements = new Elements(driver);
    }

    public void dragNDrop(String xpath1, String xpath2) {
        actions.dragAndDrop(elements.findElementByXpath(xpath1), elements.findElementByXpath(xpath2)).perform();
    }

    public void performLeftClick(WebElement element) {
        actions.moveToElement(element).click().perform();
    }

    public void performLeftClick(By by) {
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).click().perform();
    }

    public void performInputSendKeys(WebElement element, String text) {
        actions.click(element);
        element.clear();
        actions.sendKeys(text).build().perform();
    }

    public void performInputSendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        actions.click(element);
        element.clear();
        actions.sendKeys(text).build().perform();
    }

    public void hoverOnElement(By by) {
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).perform();
    }
}
