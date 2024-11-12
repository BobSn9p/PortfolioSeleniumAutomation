package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.AccountInfoPage;
import page.objects.LoginPage;
import testData.LoginTestData;

import static org.testng.Assert.assertTrue;

public class NegativeLoginSteps {

    private LoginPage loginPage;
    private AccountInfoPage accountInfoPage;

    public NegativeLoginSteps() {
        loginPage = new LoginPage();
        accountInfoPage = new AccountInfoPage();
    }


    @When("user enters incorrect login and password")
    public void userEntersIncorrectLoginAndPassword() {
        loginPage.TypeIntoUserNameField(LoginTestData.INVALID_LOGIN)
                .TypeIntoPasswordField(LoginTestData.INVALID_PASSWORD);

    }

    @When("user enters only a valid password")
    public void userEntersOnlyAValidPassword() {
        loginPage.TypeIntoPasswordField(LoginTestData.VALID_PASSWORD);

    }
    @When("user enters only a valid username")
    public void userEntersOnlyAValidUsername() {
        loginPage.TypeIntoUserNameField(LoginTestData.VALID_LOGIN);

    }

    @Then("invalid login message is displayed")
    public void invalidLoginMessageIsDisplayed() {
        boolean loginInfo = accountInfoPage.isAccountInvalidLoginInfoDisplayed();
        assertTrue(loginInfo);

    }

}
