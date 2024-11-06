package tests;

import org.testng.annotations.Test;
import page.objects.*;
import testData.TestData;

import static org.testng.AssertJUnit.assertEquals;


public class SearchAndItemDetailsTests extends TestBase {

    @Test
    public void addItemToCartWithoutChosenSize() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnAcceptCookiesButton()
                .typeAndSearchInSearchBar("MT STINGER 2 SOLID MATT BLACK");
        String searchedProductName = landingPage.getProductNameAfterSearch();
        assertEquals(searchedProductName, TestData.HELMET_FULL_NAME_MT_STINGER_2_SOLID_MATT_BLACK);

        HelmetDetailPage helmetDetailPage = new HelmetDetailPage();
        helmetDetailPage.clickOnHelmetDetails();

        assertEquals(helmetDetailPage.getHelmetSizes(), TestData.SIZES_5);

    }

}