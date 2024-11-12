package stepDefinitions;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import page.objects.LandingPage;

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
    public void tearDownDriver() {
        DriverManager.disposeDriver();
    }
}