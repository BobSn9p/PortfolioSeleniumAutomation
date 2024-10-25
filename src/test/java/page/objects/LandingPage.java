package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LandingPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "[href='#acceptAll']")
    private WebElement acceptCookies;

    public LandingPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LandingPage clickOnAcceptCookiesButton() {
        acceptCookies.click();
        logger.info("Clicked on Accept Cookies button");
        return this;
    }

}