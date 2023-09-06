package stepDefinitions.Login;

import ReusableMethods.ExcelDataReader;
import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

import java.io.IOException;
import java.util.List;

public class LoginSteps {
    private WebDriver driver;
    private PageObjectManager pom;
    private LoginPage loginPage = new LoginPage();

    public LoginSteps(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
        this.pom = new PageObjectManager(driver);
    }

    @When("User enter valid username and password in login form")
    public void userEnterValidUsernameAndPasswordInLoginForm() throws IOException {
        String filePath = "TestData/Credentials.xlsx";
        String sheetName = "Sheet1";
        List<String[]> excelData = ExcelDataReader.readDataFromExcel(filePath, sheetName);

        for (String[] row : excelData) {
            String username1 = row[0];
            String password = row[1];

            pom.sendKeysToElement(loginPage.usernameField, username1);
            pom.sendKeysToElement(loginPage.passwordField, password);
        }
    }
    @When("User enter invalid username and password in login form")
    public void userEnterInvalidUsernameAndPasswordInLoginForm() throws IOException {
        String filePath = "TestData/Credentials.xlsx";
        String sheetName = "Sheet1";
        List<String[]> excelData = ExcelDataReader.readDataFromExcel(filePath, sheetName);

        for (String[] row : excelData) {
            String username1 = row[0];
            String password = row[2];

            pom.sendKeysToElement(loginPage.usernameField, username1);
            pom.sendKeysToElement(loginPage.passwordField, password);
        }
    }
    @And("Clicks on Log in button")
    public void clicksOnLogInButton() {
        pom.clickElement(loginPage.loginButton);
    }
    @Then("Verify that the username or password is invalid")
    public void verifyThatTheUsernameOrPasswordIsInvalid() {
        Assert.assertEquals(pom.getTextOfElement(loginPage.invalidUserInfo),"You have entered an invalid password or username. Please check the information entered and try again.");
    }
}
