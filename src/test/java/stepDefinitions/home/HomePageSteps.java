package stepDefinitions.home;

import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import locators.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

public class HomePageSteps {
    private WebDriver driver;
    private PageObjectManager pom;
    private HomePage homePage = new HomePage();

    public HomePageSteps(DriverSetup driverSetup){
        this.driver = driverSetup.driver;
        this.pom = new PageObjectManager(driver);
    }

    @Given("User opens chrome browser and navigates to the url")
    public void userOpensChromeBrowserAndNavigatesToTheUrl() throws InterruptedException {
        driver.get("https://solutions-qa.inductivehealth.com/");
        Thread.sleep(1000);
    }

    @Then("Home page should be loaded")
    public void homePageShouldBeLoaded() {
        Assert.assertTrue(pom.isElementDisplayed(homePage.inductiveHealthLogo));
    }

    @Given("I am an authenticated user")
    public void iAmAnAuthenticatedUser() throws InterruptedException {
        driver.get("https://solutions-qa.inductivehealth.com/");
        Thread.sleep(1000);
    }

    @And("Verify that initially there are no favorites charts displayed")
    public void verifyThatInitiallyThereAreNoFavoritesChartsDisplayed() throws InterruptedException {
        Thread.sleep(1000);
        PageObjectManager.performMouseHover(driver, homePage.inductiveHealthLogo);
        try{
            Assert.assertTrue(pom.isElementDisplayed(homePage.noFavoritesAlertText));
            PageObjectManager.assertElementText(driver,homePage.noFavoritesAlertText, "You haven't selected any dashboards as favorites. Get started by clicking the star icon (★) at the top of any of your Insights graphs or tables.");

        }catch (Exception err){
            PageObjectManager.isBarChartDisplayedAndHighlightStar(driver,homePage.chartList,homePage.starIcon);
        }
    }
}
