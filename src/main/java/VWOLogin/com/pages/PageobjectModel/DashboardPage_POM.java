package VWOLogin.com.pages.PageobjectModel;

import VWOLogin.com.base.CommonToAllPages;
import org.openqa.selenium.By;

public class DashboardPage_POM extends CommonToAllPages {

    public DashboardPage_POM(){

    }


    // Page Locators
    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");



    // Page Actions
    public String loggedInUserName() {
        presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }



}
