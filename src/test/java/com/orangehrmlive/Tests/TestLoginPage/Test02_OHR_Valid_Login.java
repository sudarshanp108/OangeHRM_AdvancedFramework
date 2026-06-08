package com.orangehrmlive.Tests.TestLoginPage;

import com.orangehrmlive.BaseTest.CommonToAllTest;
import com.orangehrmlive.Driver.DriverManager;
import com.orangehrmlive.Pages.POM.LoginPage;
import com.orangehrmlive.Utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test02_OHR_Valid_Login extends CommonToAllTest {
        // add logger here
        private static final Logger logger = LogManager.getLogger(Test02_OHR_Valid_Login.class);
        @Owner("SUDARSHAN")
        @Description("Verify that with valid email, password, and successfully Login to the Page")
        @Test
        public void test_positive_login() {
            logger.info("Starting test_positive_login...");
            LoginPage loginPage = new LoginPage(DriverManager.getDriver());
            loginPage.logintoValidCreds(PropertiesReader.readKey("ohr_username"), PropertiesReader.readKey("ohr_password"));
            logger.info("test_positive_login passed successfully!");
        }
    }
