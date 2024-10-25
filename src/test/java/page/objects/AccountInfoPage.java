package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccountInfoPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#content > h1 > span")
    private WebElement accountWelcomeHeadline;

    @FindBy(css = "#return_sub_account_badlogin > h3")
    private WebElement invalidLoginInfo;

    public AccountInfoPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean isAccountWelcomeHeadlineDisplayed() {
        boolean isDisplayed = accountWelcomeHeadline.isDisplayed();
        logger.info("Returning status of banner after login: {}", isDisplayed);
        return isDisplayed;

    }

    public boolean isAccountInvalidLoginInfoDisplayed() {
        boolean isDisplayed = invalidLoginInfo.isDisplayed();
        logger.info("Returning info after incorrect login: {}", isDisplayed);
        return isDisplayed;
    }
}