package stepDefinitions;

import driver.manager.DriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;

public class CommonLoginSteps {

    private LoginPage loginPage;

    public CommonLoginSteps() {
        loginPage = new LoginPage();
    }

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        DriverUtils.navigateToPage(LOGIN_URL);
        loginPage = new LoginPage();

    }

    @When("clicks on the login button")
    public void clicksOnTheLoginButton() {
        loginPage.ClickOnLoginButton();
    }

}