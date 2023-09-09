package stepDefinitions.home;

import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.FavoritesLocators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;


public class FavoritesPageSteps {
    private static WebDriver driver;
    private static PageObjectManager pom;
    private static FavoritesLocators favoritesLocators = new FavoritesLocators();

    public FavoritesPageSteps(DriverSetup driverSetup){
        this.driver = driverSetup.driver;
        this.pom = new PageObjectManager(driver);
    }

    @Given("User opens chrome browser and navigates to the url")
    public void userOpensChromeBrowserAndNavigatesToTheUrl() throws InterruptedException {
        driver.get("https://solutions-qa.inductivehealth.com/");
        Thread.sleep(1000);
    }

    @Then("Home page should be loaded")
    public void homePageShouldBeLoaded() throws InterruptedException {
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.inductiveHealthLogo));
    }

    @Given("I am an authenticated user")
    public void iAmAnAuthenticatedUser() throws InterruptedException {
        driver.get("https://solutions-qa.inductivehealth.com/");
        Thread.sleep(1000);
    }

    @And("Verify that initially there are no favorites charts displayed")
    public void verifyThatInitiallyThereAreNoFavoritesChartsDisplayed() throws InterruptedException {
        Thread.sleep(1000);
        PageObjectManager.performMouseHover(driver, favoritesLocators.inductiveHealthLogo);
        try{
            Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.noFavoritesAlertText));
            pom.assertElementText(driver, favoritesLocators.noFavoritesAlertText, "You haven't selected any dashboards as favorites. Get started by clicking the star icon (★) at the top of any of your Insights graphs or tables.");

        }catch (Exception err){
            pom.isBarChartDisplayedAndHighlightStar(driver, favoritesLocators.chartList, favoritesLocators.starIcon);
        }
    }

    @Then("Verify that favorites page is displayed")
    public void verifyThatFavoritesPageIsDisplayed() throws InterruptedException {
        Thread.sleep(1000);
        pom.clickElement(favoritesLocators.favoriteButton);
        Thread.sleep(1000);
        pom.assertElementText(driver, favoritesLocators.favoritePageText, "Favorites");

    }

    @When("Remove all favorite charts from the favorites page")
    public static void removeAllFavoriteChartsFromTheFavoritesPage() throws InterruptedException {
//        try {
            Thread.sleep(1000);
            pom.removeChartsByLocator(driver, favoritesLocators.starIcon);
            Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.noFavoritesAlertText));
            pom.assertElementText(driver, favoritesLocators.noFavoritesAlertText, "You haven't selected any dashboards as favorites. Get started by clicking the star icon (★) at the top of any of your Insights graphs or tables.");

//        }
//        catch (Exception e){
//            Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.noFavoritesAlertText));
//            pom.assertElementText(driver, favoritesLocators.noFavoritesAlertText, "You haven't selected any dashboards as favorites. Get started by clicking the star icon (★) at the top of any of your Insights graphs or tables.");
//
//        }
    }
}
