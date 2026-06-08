package com.orangehrmlive.Tests.TestLoginPage;

import com.orangehrmlive.BaseTest.CommonToAllTest;
import com.orangehrmlive.Driver.DriverManager;
import com.orangehrmlive.Pages.POM.LoginPage;
import com.orangehrmlive.Utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test01_OHR_Invalid_Login extends CommonToAllTest {

    // add logger here
    @Owner("SUDARSHAN")
    @Description("Verify that with invalid email, password, and error message is shown on the OHR Login Page")
    @Test
    public void LGN_001_test_negative_login() {
        // with invalid username and password
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage.logintoInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        assertThat(error_msg).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }

    @Test
    public void LGN_002_test_negative_login() {
        // Login with only Username Entered
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String password_empty = loginPage.passwordFieldEmpty(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("empty_password"));

        assertThat(password_empty).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(password_empty, PropertiesReader.readKey("rqrd_msg"));
    }

    @Test
    public void LGN_003_test_negative_login() {
        // Login with only Password Entered
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String password_empty = loginPage.usernameFieldEmpty(PropertiesReader.readKey("empty_username"), PropertiesReader.readKey("invalid_password"));

        assertThat(password_empty).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(password_empty, PropertiesReader.readKey("rqrd_msg"));
    }

    @Test
    public void LGN_004_test_negative_login() {
        // Login with only Blank fields
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String password_empty = loginPage.bothFieldsEmpty(PropertiesReader.readKey("empty_username"), PropertiesReader.readKey("empty_password"));

        assertThat(password_empty).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(password_empty, PropertiesReader.readKey("rqrd_msg"));
    }
}
