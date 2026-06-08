package com.orangehrmlive.Pages.POM;

import com.orangehrmlive.Base.CommonToAllPage;
import com.orangehrmlive.Utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPassword extends CommonToAllPage {
    WebDriver driver;

    public ResetPassword(WebDriver driver) {
        this.driver = driver;
    }
        private By forgotPassword = By.xpath("//p[normalize-space()='Forgot your password?']");
        private By inputUsername = By.xpath("//input[@name='username']");
        private By resetPswd = By.xpath("//button[@type='submit']");
        // for assertion of visibility of form
        private By textVisible = By.xpath("//div/form/h6");
        // wait for the page to load properly
        public By waitforelementpresent = By.xpath("//p[text()='Username : Admin']");

        public void resetPassword (String name) {
            openOHRURL();
            WaitHelpers.visibilityOfElement(waitforelementpresent);
            clickElement(forgotPassword);
            WaitHelpers.visibilityOfElement(textVisible);
            enterInput(inputUsername, name);
            clickElement(resetPswd);

        }

}
