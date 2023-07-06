package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static class Locators {
        private final static By checkLogoOnPageLocator = By.xpath("//*[@id=\"logo-box\"]/strong/a/img");
        private final static By helpListButtonLocator = By.id("help-box");
        private final static By helpDropdownListLocator = By.xpath("//*[@id=\"help-box\"]/ul");
        private final static By subscriptionFormLocator = By.xpath("//*[@id='footer']/div[1]/div/form/div/input");
        private final static By placeHolderEmailAreaLocator = By.xpath("//*[@id=\"footer\"]/div[1]/div/form/div/input");
        private final static By autoSelectionCurrentCityNameWindowLocator = By.xpath("//*[@id=\"current-city\"]/a");
        private final static By manualSelectionCurrentCityNameInComboBoxLocator = By.xpath("//*[@id=\"city-select-form\"]/div[1]/a[6]");
        private final static By linkLoginPageLocator = By.xpath("//*[@id=\"personal-profile-link\"]/span[2]");

    }

    private static class Labels {
        private final static String urlHomePage = "https://pampik.com/ua";
        private final static String urlLoginPage = "https://pampik.com/ua/account/login";
    }

    public static void checkHomePageLogo() {
        WebElement logo = elements.findElement(Locators.checkLogoOnPageLocator);
        assertions.elementIsDisplayed(logo);
    }

    public void clickButtonOfHelp() {
        WebElement buttonHelp = elements.findElement(Locators.helpListButtonLocator);
        elements.clickOnElement(buttonHelp);
    }

    public boolean isHelpListDisplayed() {
        WebElement helpList = elements.findElement(Locators.helpDropdownListLocator);
        boolean isDisplayed = elements.isElementDisplayed(helpList);
        return isDisplayed;
    }

    public void enterEmailInSubscriptionForm() {
        action.performInputSendKeys(Locators.subscriptionFormLocator, "mike@mikemike.com");
    }

    public void checkPresenceEmailInSubscriptionForm() {
        WebElement placeHolderEmailArea = driver.findElement(Locators.placeHolderEmailAreaLocator);
        wait.waitForVisibilityOfElement(placeHolderEmailArea);
        WebElement emailInput = driver.findElement(Locators.subscriptionFormLocator);
        String expectedText = emailInput.getAttribute("value");
        String actualText = placeHolderEmailArea.getAttribute("value");
        assertions.equalsOfText(actualText, expectedText);
    }

    public void currentCityNameClick() {
        WebElement сurrentCityName = driver.findElement(Locators.autoSelectionCurrentCityNameWindowLocator);
        wait.waitForVisibilityOfElement(сurrentCityName);
        elements.clickOnElement(сurrentCityName);
    }

    public void changeCityName() {
        WebElement citySelection = driver.findElement(Locators.manualSelectionCurrentCityNameInComboBoxLocator);
        wait.waitForVisibilityOfElement(citySelection);
        elements.clickOnElement(citySelection);
    }

    public void checkChangeCityName() {
        WebElement сurrentCityName = driver.findElement(Locators.autoSelectionCurrentCityNameWindowLocator);
        wait.waitForVisibilityOfElement(сurrentCityName);
        WebElement citySelection = driver.findElement(Locators.manualSelectionCurrentCityNameInComboBoxLocator);
        String expectedText = citySelection.getText();
        String actualText = сurrentCityName.getText();
        assertions.equalsIgnoreCaseOfText(actualText, expectedText);
    }

    public void LoginLinkClick() {
        WebElement LoginLink = driver.findElement(Locators.linkLoginPageLocator);
        elements.clickOnElement(LoginLink);
    }

    public void isLoginPageCheck() {
        String expectedUrl = Labels.urlLoginPage;
        assertions.equalsUrl(expectedUrl);
    }

    public void openHomePage() {
        driver.get(Labels.urlHomePage);
    }
}



