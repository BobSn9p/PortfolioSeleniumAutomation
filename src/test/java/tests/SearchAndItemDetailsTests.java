package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.*;
import testData.TestData;

import static navigation.ApplicationURLs.CART_URL;
import static navigation.ApplicationURLs.HELMET_DETAILS_MT_STINGER_2_SOLID_MATT_BLACK;
import static org.testng.AssertJUnit.*;
import static testData.TestData.*;


public class SearchAndItemDetailsTests extends TestBase {

    @Test
    public void searchForAnItem() {
        LandingPage landingPage = new LandingPage();
        landingPage.typeAndSearchInSearchBar("MT STINGER 2 SOLID MATT BLACK");
        String searchedProductName = landingPage.getProductNameAfterSearch();
        assertEquals(searchedProductName, TestData.HELMET_FULL_NAME_MT_STINGER_2_SOLID_MATT_BLACK);
    }

    @Test
    public void addItemToCartWithoutChosenSize() {
        DriverUtils.navigateToPage(HELMET_DETAILS_MT_STINGER_2_SOLID_MATT_BLACK);

        HelmetDetailPage helmetDetailPage = new HelmetDetailPage();
        assertEquals(helmetDetailPage.getHelmetSizes(), TestData.SIZES_5);

        boolean isAlertDisplayed = helmetDetailPage
                .clickOnAddToCartButton()
                .isChooseSizeAlertDisplayed();
        assertTrue(isAlertDisplayed);

        String alertMessage = helmetDetailPage.getSizeAlertText();
        assertEquals(alertMessage, NO_CHOSEN_SIZE_MESSAGE);
    }

    @Test
    public void addItemToCartWithChosenSize() {
        DriverUtils.navigateToPage(HELMET_DETAILS_MT_STINGER_2_SOLID_MATT_BLACK);

        HelmetDetailPage helmetDetailPage = new HelmetDetailPage();

        String helmetPrice = helmetDetailPage.getHelmetPrice();

        assertEquals(helmetDetailPage.getHelmetSizes(), TestData.SIZES_5);
        helmetDetailPage.clickOnFirstSize()
                .clickOnAddToCartButton();

        boolean isAddedToCartModalDisplayed = helmetDetailPage
                .isAddedToCartModalDisplayed();
        assertTrue(isAddedToCartModalDisplayed);

        String modalHeadline = helmetDetailPage.getAddedToCartModalHeadline();
        assertEquals(modalHeadline, ADDED_TO_CART + " " + HELMET_FULL_NAME_MT_STINGER_2_SOLID_MATT_BLACK);

        helmetDetailPage.clickOnProceedToCheckoutButton();
        String actualUrl = DriverManager.getWebDriver().getCurrentUrl();
        assertEquals(actualUrl, CART_URL);

        CheckoutPage checkoutPage = new CheckoutPage();
        String actualHelmetPrice = checkoutPage.getTotalAmount();

        assertEquals(helmetPrice, actualHelmetPrice);
    }

}