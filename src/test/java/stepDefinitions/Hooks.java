package stepDefinitions;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import page.objects.LandingPage;

import java.io.ByteArrayInputStream;
import java.util.Properties;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class Hooks {

    @Before(order = 1)
    public void loadProperties() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Before(order = 2)
    public void setUpDriver() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnAcceptCookiesButton();
    }

    @After
    public void tearDownDriver(Scenario scenario) {

        if(scenario.isFailed()) {
            byte [] screenshot = ((TakesScreenshot)DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed step screenshot", new ByteArrayInputStream(screenshot));
        }
        DriverManager.disposeDriver();
    }
}