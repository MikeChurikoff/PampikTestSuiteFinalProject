import base.BaseTest;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {
    @Test
    public void checkVisibilityLogoOnHomePage() {
        homePage.openHomePage();
        homePage.checkHomePageLogo();
    }
    @Test
    public void checkHelpListIsDisplayed() {
        homePage.openHomePage();
        homePage.clickButtonOfHelp();
        homePage.isHelpListDisplayed();
    }
    @Test
    public void checkEnterEmailInSubscription() {
        homePage.openHomePage();
        homePage.enterEmailInSubscriptionForm();
        homePage.checkPresenceEmailInSubscriptionForm();
    }
    @Test
    public void checkSelectionCurrentCity() {
        homePage.openHomePage();
        homePage.currentCityNameClick();
        homePage.changeCityName();
        homePage.checkChangeCityName();
    }
    @Test
    public void checkSwitchToLoginPage() {
        homePage.openHomePage();
        homePage.LoginLinkClick();
        homePage.isLoginPageCheck();
    }
}

