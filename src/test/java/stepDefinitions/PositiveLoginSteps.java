package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.AccountInfoPage;
import page.objects.LoginPage;
import testData.LoginTestData;

import static org.testng.Assert.assertTrue;

public class PositiveLoginSteps {

    private LoginPage loginPage;
    private AccountInfoPage accountInfoPage;

    public PositiveLoginSteps() {
        loginPage = new LoginPage();
        accountInfoPage = new AccountInfoPage();
    }

    @When("user enters correct login and password")
    public void userEntersCorrectLoginAndPassword() {
        loginPage.TypeIntoUserNameField(LoginTestData.VALID_LOGIN)
                .TypeIntoPasswordField(LoginTestData.VALID_PASSWORD);
    }

    @Then("account welcome headline is displayed")
    public void accountWelcomeHeadlineIsDisplayed() {
        boolean loginInfo = accountInfoPage.isAccountWelcomeHeadlineDisplayed();
        assertTrue(loginInfo);
    }
}
