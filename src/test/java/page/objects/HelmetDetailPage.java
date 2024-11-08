package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import waits.WaitForElement;

import java.util.ArrayList;
import java.util.List;

public class HelmetDetailPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#projector_button_basket")
    private WebElement addToCart;

    @FindBy(css = ".projector_sizes__sub")
    private WebElement size;

    @FindBy(css = "#alert")
    private WebElement alert;

    @FindBy(css= "#projector_sizes_cont > div:nth-of-type(2) > a:first-of-type")
    private WebElement firstSize;

    @FindBy(css = "#menu_preloader_add")
    private WebElement addedToCartModalInformation;

    @FindBy(css = "#menu_preloader_add > h2 > span")
    private WebElement addedToCartModalInformationHeadline;

    @FindBy(css = "#menu_preloader_add > div > div > h3 > a")
    private WebElement getAddedToCartModalInformationProductName;

    @FindBy(css = "#menu_preloader_add > div > div > div:nth-of-type(3) > a:nth-of-type(2)")
    private WebElement proceedToCheckout;

    @FindBy(css = "#projector_price_value")
    private WebElement helmetPrice;


    public HelmetDetailPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public HelmetDetailPage clickOnAddToCartButton() {
        addToCart.click();
        logger.info("Clicked on Add To Cart button");
        return this;
    }

    public List<String> getHelmetSizes() {
        List<WebElement> helmetsSizeWebElements = size.findElements(By.cssSelector(".projector_sizes__item"));

        List<String> helmetsSizeStringsList = new ArrayList<>();
        logger.info("Getting helmet sizes");

        for (WebElement element : helmetsSizeWebElements) {
            helmetsSizeStringsList.add(element.getText());
            logger.info(element.getText());
        }
        return helmetsSizeStringsList;
    }

    public boolean isChooseSizeAlertDisplayed() {
        WaitForElement.waitUntilElementIsVisible(alert);
        boolean isDisplayed = alert.isDisplayed();
        logger.info("Returning alert about not chosen size: {}", isDisplayed);
        return isDisplayed;
    }

    public String getSizeAlertText() {
        String sizeAlertText = alert.getText();
        logger.info("Returned warning message was: {}", sizeAlertText);
        return sizeAlertText;
    }

    public HelmetDetailPage clickOnFirstSize() {
        firstSize.click();
        logger.info("Clicked on first size");
        return this;
    }

    public boolean isAddedToCartModalDisplayed() {
       WaitForElement.waitUntilElementIsVisible(addedToCartModalInformation);
        boolean isDisplayed = addedToCartModalInformation.isDisplayed();
        logger.info("Returning added to cart modal information: {}", isDisplayed);
        return isDisplayed;
    }

    public String getAddedToCartModalHeadline() {
        String addedToCartModalHeadline = addedToCartModalInformationHeadline.getText() + " " + getAddedToCartModalInformationProductName.getText();
        logger.info("Modal headline and product name was: {}", addedToCartModalHeadline);
        return addedToCartModalHeadline;
    }

    public CheckoutPage clickOnProceedToCheckoutButton() {
        proceedToCheckout.click();
        logger.info("Clicked od proceed to checkout");
        return new CheckoutPage();
    }

    public String getHelmetPrice() {
        String helmetActualPrice = helmetPrice.getText() + " brutto";
        logger.info("Returned helmet actual price was: {}", helmetActualPrice);
        return helmetActualPrice;
    }



}