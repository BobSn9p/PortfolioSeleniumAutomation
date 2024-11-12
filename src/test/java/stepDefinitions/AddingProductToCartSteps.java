package stepDefinitions;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.HelmetDetailPage;
import testData.TestData;


import static navigation.ApplicationURLs.HELMET_DETAILS_MT_STINGER_2_SOLID_MATT_BLACK;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static testData.TestData.*;

public class AddingProductToCartSteps {

    private HelmetDetailPage helmetDetailPage;


    public AddingProductToCartSteps() {
        helmetDetailPage = new HelmetDetailPage();
    }

    @Given("user is on the product details page")
    public void userIsOnTheProductDetailsPage() {
        DriverUtils.navigateToPage(HELMET_DETAILS_MT_STINGER_2_SOLID_MATT_BLACK);
        String pageTitle = DriverManager.getWebDriver().getTitle();
        assertEquals(pageTitle, "Kask integralny MT STINGER 2 SOLID MATT BLACK czarny mat | RRmoto.pl");
    }


    @When("user tries to add item to cart without chosen size")
    public void userTriesToAddItemToCartWithoutChosenSize() {
        helmetDetailPage.clickOnAddToCartButton();
    }

    @When("user clicks on item size")
    public void userClicksOnItemSize() {
        assertEquals(helmetDetailPage.getHelmetSizes(), TestData.SIZES_5);
        helmetDetailPage.clickOnFirstSize();
    }

    @When("adds item to the cart")
    public void userAddsItemToCart() {
        helmetDetailPage.clickOnAddToCartButton();
    }

    @Then("window with information about added item to cart is displayed")
    public void modalAfterAddingItemToCartIsDisplayed() {
        boolean isAddedToCartModalDisplayed = helmetDetailPage.isAddedToCartModalDisplayed();
        assertTrue(isAddedToCartModalDisplayed);
        String modalHeadline = helmetDetailPage.getAddedToCartModalHeadline();
        assertEquals(modalHeadline, ADDED_TO_CART + " " + HELMET_FULL_NAME_MT_STINGER_2_SOLID_MATT_BLACK);
    }

    @Then("alert no chosen size is displayed")
    public void alertNoChosenSizeIsDisplayed() {
        boolean isAlertDisplayed = helmetDetailPage.isChooseSizeAlertDisplayed();
        assertTrue(isAlertDisplayed);

        String alertMessage = helmetDetailPage.getSizeAlertText();
        assertEquals(alertMessage, NO_CHOSEN_SIZE_MESSAGE);
    }
}