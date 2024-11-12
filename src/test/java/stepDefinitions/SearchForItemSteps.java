package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import navigation.ApplicationURLs;
import page.objects.LandingPage;
import testData.TestData;

import static org.testng.AssertJUnit.assertEquals;

public class SearchForItemSteps {

    private LandingPage landingPage;

    public SearchForItemSteps() {
       landingPage = new LandingPage();

    }

    @Given("user is on the landing page")
    public void userIsOnTheLandingPage() {
        String URL = driver.manager.DriverManager.getWebDriver().getCurrentUrl();
        assertEquals(URL, ApplicationURLs.APPLICATION_URL);

    }

    @When("user enters product name in searchbar")
    public void userEntersProductNameInSearchbar() {
        landingPage.typeAndSearchInSearchBar("MT STINGER 2 SOLID MATT BLACK");
    }

    @When("clicks on the search button")
    public void userClicksOnSearchButton() {
        landingPage.clickOnSearchButton();

    }

    @Then("valid product is displayed on search result list")
    public void validProductIsDisplayed() {
        String searchedProductName = landingPage.getProductNameAfterSearch();
        assertEquals(searchedProductName, TestData.HELMET_FULL_NAME_MT_STINGER_2_SOLID_MATT_BLACK);
    }
}