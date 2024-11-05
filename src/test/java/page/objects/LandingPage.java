package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LandingPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "[href='#acceptAll']")
    private WebElement acceptCookies;

    @FindBy(css = "#menu_search > div > div:first-of-type > input")
    private WebElement searchBar;

    @FindBy(css = "#search > div > h3 > a")
    private WebElement productName;

    public LandingPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LandingPage clickOnAcceptCookiesButton() {
        acceptCookies.click();
        logger.info("Clicked on Accept Cookies button");
        return this;
    }

    public LandingPage typeAndSearchInSearchBar(String itemName) {
        searchBar.clear();
        logger.info("Cleared search bar field");
        searchBar.sendKeys(itemName);
        logger.info("Typed into search bar field{}", itemName);
        searchBar.sendKeys(Keys.ENTER);
        logger.info("Searched for chosen item");
        return this;
    }

    public String getProductNameAfterSearch() {
    String searchedProductName = productName.getText();
    logger.info("Searched product name was: {}", searchedProductName);
    return searchedProductName;
    }

}