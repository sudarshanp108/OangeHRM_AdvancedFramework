package com.orangehrmlive.Tests.TestLoginPage;

import com.orangehrmlive.BaseTest.CommonToAllTest;
import com.orangehrmlive.Driver.DriverManager;
import com.orangehrmlive.Pages.POM.ResetPassword;
import com.orangehrmlive.Utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

public class Test03_OHR_Forgot_Password extends CommonToAllTest {
    @Owner("SUDARSHAN")
    @Description("Verify that with click forgot password and reset password successfully")
    @Test
    public void test_forgot_password() {
        ResetPassword resetPassword = new ResetPassword(DriverManager.getDriver());
        resetPassword.resetPassword(PropertiesReader.readKey("ohr_username"));

        // bug found as 504 Gateway Time-out
    }

}
