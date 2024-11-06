package tests;

import org.testng.annotations.Test;
import page.objects.*;
import testData.TestData;
import waits.WaitForElement;

import static org.testng.AssertJUnit.*;


public class SearchAndItemDetailsTests extends TestBase {

    @Test
    public void addItemToCartWithoutChosenSize() throws InterruptedException {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnAcceptCookiesButton()
                .typeAndSearchInSearchBar("MT STINGER 2 SOLID MATT BLACK");
        String searchedProductName = landingPage.getProductNameAfterSearch();
        assertEquals(searchedProductName, TestData.HELMET_FULL_NAME_MT_STINGER_2_SOLID_MATT_BLACK);

        HelmetDetailPage helmetDetailPage = new HelmetDetailPage()
                .clickOnHelmetDetails();

        assertEquals(helmetDetailPage.getHelmetSizes(), TestData.SIZES_5);

        boolean isAlertDisplayed = helmetDetailPage
                .clickOnAddToCartButton()
                .isChooseSizeAlertDisplayed();
        assertTrue(isAlertDisplayed);

    }

}