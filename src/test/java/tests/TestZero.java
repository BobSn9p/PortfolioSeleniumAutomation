package tests;

import org.testng.annotations.Test;
import page.objects.*;


public class TestZero extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnAcceptCookiesButton();

    }

}