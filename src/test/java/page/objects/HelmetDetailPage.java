package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class HelmetDetailPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#projector_button_basket")
    private WebElement addToCart;

    @FindBy(css = ".projector_sizes__sub")
    private WebElement size;

    @FindBy(css = "#search > div > h3 > a")
    private WebElement helmetDetails;

    public HelmetDetailPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public HelmetDetailPage clickOnAddToCartButton() {
        addToCart.click();
        logger.info("Clicked on Add To Cart button");
        return this;
    }

    public HelmetDetailPage clickOnHelmetDetails() {
        helmetDetails.click();
        logger.info("Clicked on helmet Details");
        return this;
    }

    public List<String> getHelmetSizes() {
        List<WebElement> helmetsSizeWebElements = size.findElements(By.cssSelector(".projector_sizes__item"));

        List<String> helmetsSizeStringsList = new ArrayList<>();

        for (WebElement element : helmetsSizeWebElements) {
            helmetsSizeStringsList.add(element.getText());
            logger.info(element.getText());
        }
        return helmetsSizeStringsList;
    }




}