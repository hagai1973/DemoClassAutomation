package example2.tests;

import all.utils.GenerateDriverAll;
import all.utils.JsonUtils;
import example2.actions.Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RegistrationFormTest {

    WebDriver driver;
    Actions actions;

    /**
     * Sets up the test environment by initializing the WebDriver and Actions.
     * Reads the URL and browser type from the JSON configuration file.
     */
    @BeforeSuite
    public void setUp() {
        String URL = JsonUtils.readJsonFromFile("url");
        String BROWSER = JsonUtils.readJsonFromFile("browser");
        driver = GenerateDriverAll.initDriver(BROWSER, URL);
        actions = new Actions(driver);
    }

    /**
     * Tests the forgot password functionality.
     */
    @Test(description = "testing the registration form positive")
    public void forgotPassword() {
        assert actions.doForgotPassword();
    }

    /**
     * Cleans up the test environment by quitting the WebDriver.
     */
    @AfterSuite
    public void tearDown() {
        GenerateDriverAll.cleanDriver(driver);
    }
}