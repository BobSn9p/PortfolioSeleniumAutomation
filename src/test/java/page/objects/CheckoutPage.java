package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckoutPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = ".basketedit_total_summary > strong")
    private WebElement totalAmount;


    public CheckoutPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public String getTotalAmount() {
        String totalAmountToPay = totalAmount.getText();
        logger.info("Total amount to pay was: {}", totalAmountToPay);
        return totalAmountToPay;
    }

}