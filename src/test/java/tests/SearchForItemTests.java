package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.objects.*;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


public class SearchForItemTests extends TestBase {
    List<String> desiredHelmetSizes = List.of("XS", "S", "M", "L", "XL");

    @Test
    public void addItemToCartWithoutChosenSize() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnAcceptCookiesButton()
                .typeAndSearchInSearchBar("MT STINGER 2 SOLID MATT BLACK");
        String searchedProductName = landingPage.getProductNameAfterSearch();
        assertEquals(searchedProductName, "Kask integralny MT STINGER 2 SOLID MATT BLACK czarny mat");

        HelmetDetailPage helmetDetailPage = new HelmetDetailPage();
        helmetDetailPage.clickOnHelmetDetails();

        assertEquals(helmetDetailPage.getHelmetSizes(), desiredHelmetSizes);



    }

}