package com.orangehrmlive.Pages.POM;

import com.orangehrmlive.Base.CommonToAllPage;
import com.orangehrmlive.Utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPage {

    WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver=driver;
    }

    private By username = By.name("username");
    private By password = By.name("password");
    private By loginbutton = By.xpath("//button");
    private By error_message = By.xpath("//div[contains(@class, 'oxd-alert-content')]");
    // wait for the page to load properly
    public By waitforelementpresent = By.xpath("//p[text()='Username : Admin']");
    // wait for required text appears
    public  By fieldRequired = By.xpath("//span[@class]");

    public String logintoInvalidCreds (String usr, String pwd) {
        openOHRURL();
        WaitHelpers.visibilityOfElement(waitforelementpresent);
        enterInput(username, usr);
        enterInput(password, pwd);
        clickElement(loginbutton);
//        WaitHelpers.checkVisibility(getDriver(), error_message);
        WaitHelpers.waitJVM(5000);
        WaitHelpers.visibilityOfElement(error_message);
        return getText(error_message);

    }

    public String passwordFieldEmpty (String usr, String pwd) {
        openOHRURL();
        WaitHelpers.visibilityOfElement(waitforelementpresent);
        enterInput(username, usr);
        enterInput(password, "");
        clickElement(loginbutton);
        WaitHelpers.waitJVM(5000);
        WaitHelpers.visibilityOfElement(fieldRequired);
        return getText(fieldRequired);

    }

    public String usernameFieldEmpty (String usr, String pwd) {
        openOHRURL();
        WaitHelpers.visibilityOfElement(waitforelementpresent);
        enterInput(username, "");
        enterInput(password, pwd);
        clickElement(loginbutton);
        WaitHelpers.waitJVM(5000);
        WaitHelpers.visibilityOfElement(fieldRequired);
        return getText(fieldRequired);

    }

    public String bothFieldsEmpty (String usr, String pwd) {
        openOHRURL();
        WaitHelpers.visibilityOfElement(waitforelementpresent);
        enterInput(username, "");
        enterInput(password, "");
        clickElement(loginbutton);
        WaitHelpers.waitJVM(5000);
        WaitHelpers.visibilityOfElement(fieldRequired);
        return getText(fieldRequired);

    }

    public void logintoValidCreds (String usr, String pwd) {
        openOHRURL();
//        WaitHelpers.visibilityOfElement(waitforelementpresent);
        WaitHelpers.visibilityOfElement(username);
        enterInput(username, usr);
        enterInput(password, pwd);
        clickElement(loginbutton);

        WaitHelpers.waitJVM(5000);

    }

}
