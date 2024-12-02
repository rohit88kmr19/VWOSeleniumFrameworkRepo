package VWOLogin.com.test.VWOTests;

import VWOLogin.com.Listeners.RetryAnalyzer;
import VWOLogin.com.base.CommonToAllTests;
import VWOLogin.com.driver.DriverManager;
import VWOLogin.com.pages.PageobjectModel.LoginPage_POM;
import VWOLogin.com.utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_POM_Retry extends CommonToAllTests {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_POM_Retry.class);

    @Test
    @Owner("Rohit")
    @Description("Verify that the Login Test Case will fail and will retry it three times")
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
