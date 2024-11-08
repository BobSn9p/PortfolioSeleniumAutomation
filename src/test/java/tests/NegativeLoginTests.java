package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.*;
import testData.LoginTestData;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;


public class NegativeLoginTests extends TestBase {

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        boolean isAccountInvalidLoginInfoDisplayed = loginPage
                .TypeIntoUserNameField(LoginTestData.INVALID_LOGIN)
                .TypeIntoPasswordField(LoginTestData.INVALID_PASSWORD)
                .ClickOnLoginButton()
                .isAccountInvalidLoginInfoDisplayed();
        assertTrue(isAccountInvalidLoginInfoDisplayed);
    }

    @Test
    public void asUserTryToLogInWithoutLogin() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        boolean isAccountInvalidLoginInfoDisplayed = loginPage
                .TypeIntoPasswordField(LoginTestData.VALID_PASSWORD)
                .ClickOnLoginButton()
                .isAccountInvalidLoginInfoDisplayed();
        assertTrue(isAccountInvalidLoginInfoDisplayed);
    }

    @Test
    public void asUserTryToLogInWithoutPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        boolean isAccountInvalidLoginInfoDisplayed = loginPage
                .TypeIntoUserNameField(LoginTestData.VALID_LOGIN)
                .ClickOnLoginButton()
                .isAccountInvalidLoginInfoDisplayed();
        assertTrue(isAccountInvalidLoginInfoDisplayed);
    }

}