package VWOLogin.com.test.VWOTests;

import VWOLogin.com.base.CommonToAllTests;
import VWOLogin.com.driver.DriverManager;
import VWOLogin.com.pages.PageobjectModel.LoginPage_POM;
import VWOLogin.com.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.util.logging.LogManager.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_POM extends CommonToAllTests {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_POM.class);

    @Test
    public void testLoginNegativeVWO() {
        logger.info("Starting the Testcases");
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        logger.info("Opening the URL");
        String error_msg_text = loginPagePom.loginToVWOInvalidCreds(PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));
        logger.info("Verifying the Error Message is the" +error_msg_text);

        assertThat(error_msg_text).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg_text, PropertyReader.readKey("error_message"));

    }

}
