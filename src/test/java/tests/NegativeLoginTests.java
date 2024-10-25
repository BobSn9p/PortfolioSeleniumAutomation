package tests;

import driver.manager.DriverUtils;
import org.apache.commons.logging.Log;
import org.testng.annotations.Test;
import page.objects.*;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;


public class NegativeLoginTests extends TestBase {

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnAcceptCookiesButton();

        LoginPage loginPage = new LoginPage();
        boolean isAccountInvalidLoginInfoDisplayed = loginPage
                .TypeIntoUserNameField("ABC")
                .TypeIntoPasswordField("123")
                .ClickOnLoginButton()
                .isAccountInvalidLoginInfoDisplayed();
        assertTrue(isAccountInvalidLoginInfoDisplayed);

    }

}