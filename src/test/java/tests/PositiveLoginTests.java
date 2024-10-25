package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.*;

import static navigation.ApplicationURLs.LOGIN_URL;


public class PositiveLoginTests extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnAcceptCookiesButton();

    }

}