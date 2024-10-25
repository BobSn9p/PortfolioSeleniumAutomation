package tests;

import driver.manager.DriverUtils;
import org.apache.commons.logging.Log;
import org.testng.annotations.Test;
import page.objects.*;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;


public class PositiveLoginTests extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnAcceptCookiesButton();

        LoginPage loginPage = new LoginPage();
        boolean isAccountWelcomeHeadlineDisplayed = loginPage
                .TypeIntoUserNameField("Testing")
                .TypeIntoPasswordField("123456")
                .ClickOnLoginButton()
                .isAccountWelcomeHeadlineDisplayed();
        assertTrue(isAccountWelcomeHeadlineDisplayed);

    }

}