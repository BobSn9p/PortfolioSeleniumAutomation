package driver.manager;

import configuration.LocalWebDriverProperties;
import driver.BrowserFactory;
import driver.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (driver.get() == null) {
            WebDriver newDriver = BrowserFactory.getBrowser(LocalWebDriverProperties.getLocalBrowser());
            driver.set(newDriver);
        }
        return driver.get();
    }

    public static void disposeDriver() {
        if (driver.get() != null) {
            try {
                driver.get().close();
                if (!LocalWebDriverProperties.getLocalBrowser().equals(BrowserType.FIREFOX)) {
                    driver.get().quit();
                }
            } finally {
                driver.remove();
            }
        }
    }
}