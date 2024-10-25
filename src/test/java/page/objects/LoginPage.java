package page.objects;

import driver.manager.DriverManager;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#user_login")
    private WebElement loginField;

    @FindBy(css = "#user_pass")
    private WebElement passwordField;

    @FindBy(css = "#signin-form_box_sub_1 > form > div:nth-of-type(2) > button")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage TypeIntoUserNameField(String username) {
        loginField.clear();
        logger.info("Cleared username field");
        loginField.sendKeys(username);
        logger.info("Typed into User Name Field {}", username);
        return this;
    }

    public LoginPage TypeIntoPasswordField(String password) {
        passwordField.clear();
        logger.info("Cleared password field");
        passwordField.sendKeys(password);
        logger.info("Typed into Password Field {}", password);
        return this;
    }

    public AccountInfoPage ClickOnLoginButton() {
        loginButton.click();
        logger.info("Clicked on Login Button");
        return new AccountInfoPage();
    }
}
