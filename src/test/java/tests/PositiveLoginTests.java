package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.*;
import testData.LoginTestData;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;


public class PositiveLoginTests extends TestBase {

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnAcceptCookiesButton();

        LoginPage loginPage = new LoginPage();
        boolean isAccountWelcomeHeadlineDisplayed = loginPage
                .TypeIntoUserNameField(LoginTestData.VALID_LOGIN)
                .TypeIntoPasswordField(LoginTestData.VALID_PASSWORD)
                .ClickOnLoginButton()
                .isAccountWelcomeHeadlineDisplayed();
        assertTrue(isAccountWelcomeHeadlineDisplayed);

    }

}