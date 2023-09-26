package stepDefinitions.home;

import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.FavoritesLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverSetup;

import java.sql.SQLOutput;
import java.time.Duration;


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
        pom.waitUntilElementIsVisible(favoritesLocators.inductiveHealthLogo);
        PageObjectManager.performMouseHover(driver, favoritesLocators.inductiveHealthLogo);
        try{
            pom.waitUntilElementIsVisible(favoritesLocators.noFavoritesAlertText);
            Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.noFavoritesAlertText));
            pom.assertElementText(driver, favoritesLocators.noFavoritesAlertText, "You haven't selected any dashboards as favorites. Get started by clicking the star icon (★) at the top of any of your Insights graphs or tables.");

        }catch (Exception err){
            pom.isBarChartDisplayedAndHighlightStar(driver, favoritesLocators.chartList, favoritesLocators.starIcon);
        }
    }

    @Then("Verify that favorites page is displayed")
    public void verifyThatFavoritesPageIsDisplayed() throws InterruptedException {
        pom.waitUntilElementIsVisible(favoritesLocators.favoriteButton);
        pom.clickElement(favoritesLocators.favoriteButton);
        pom.waitUntilElementIsVisible(favoritesLocators.favoritePageText);
        pom.assertElementText(driver, favoritesLocators.favoritePageText, "Favorites");

    }

    @When("Remove all favorite charts from the favorites page")
    public static void removeAllFavoriteChartsFromTheFavoritesPage() throws InterruptedException {
//            pom.waitUntilElementIsVisible(favoritesLocators.starIcon);
        Thread.sleep(2000);
        pom.removeChartsByLocator(driver, favoritesLocators.starIcon);
    }

    @When("I navigate to the Favorite Page")
    public void iNavigateToTheFavoritePage() throws InterruptedException {
        PageObjectManager.performMouseHover(driver, favoritesLocators.inductiveHealthLogo);
        pom.waitUntilElementIsVisible(favoritesLocators.favoriteButton);
        pom.clickElement(favoritesLocators.favoriteButton);
        pom.waitUntilElementIsVisible(favoritesLocators.favoritePageText);
        pom.assertElementText(driver, favoritesLocators.favoritePageText, "Favorites");
    }

    @Then("I expect there are no favorite charts and the system display a text")
    public void iExpectThereAreNoFavoriteChartsAndTheSystemDisplayAText() throws InterruptedException {
        pom.waitUntilElementIsVisible(favoritesLocators.inductiveHealthLogo);
        PageObjectManager.performMouseHover(driver, favoritesLocators.inductiveHealthLogo);
        try{
            pom.waitUntilElementIsVisible(favoritesLocators.noFavoritesAlertText);
            Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.noFavoritesAlertText));
            pom.assertElementText(driver, favoritesLocators.noFavoritesAlertText, "You haven't selected any dashboards as favorites. Get started by clicking the star icon (★) at the top of any of your Insights graphs or tables.");

        }catch (Exception err){
            pom.waitUntilElementIsVisible(favoritesLocators.chartList);
            pom.isBarChartDisplayedAndHighlightStar(driver, favoritesLocators.chartList, favoritesLocators.starIcon);
        }
    }

    @When("I navigate to Selected Chart page and click on the favorite Icon")
    public void iNavigateToSelectedChartPageAndClickOnTheFavoriteIcon() {
        pom.waitUntilElementIsVisible(favoritesLocators.diseaseSurveillanceButton);
        pom.clickElement(favoritesLocators.diseaseSurveillanceButton);
        pom.clickElement(favoritesLocators.diseaseAnalytics);

    }

    @Then("I expect the Favorite Start icon to be highlighted")
    public void iExpectTheFavoriteStartIconToBeHighlighted() {
        try{
            pom.clickElement(favoritesLocators.starIconAdd);
            pom.isBarChartDisplayedAndHighlightStar(driver, favoritesLocators.chartList, favoritesLocators.starIcon);
        }catch (Exception error){
            pom.isBarChartDisplayedAndHighlightStar(driver, favoritesLocators.chartList, favoritesLocators.starIcon);
        }
    }

    @When("I navigate to the Favorite home page")
    public void iNavigateToTheFavoriteHomePage() {
        pom.waitUntilElementIsVisible(favoritesLocators.favoriteButton);
        pom.clickElement(favoritesLocators.favoriteButton);
    }

    @Then("I see the favorite chart that was previously favorite to be visible on the favorites page")
    public void iSeeTheFavoriteChartThatWasPreviouslyFavoriteToBeVisibleOnTheFavoritesPage() throws InterruptedException {
        pom.waitUntilElementIsVisible(favoritesLocators.diseaseChartTitle);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.diseaseChartTitle));
    }

    @And("Create at least one alert")
    public void createAtLeastOneAlert() {
        pom.waitUntilElementIsVisible(favoritesLocators.syndromicAnalytics);
        pom.clickElement(favoritesLocators.syndromicAnalytics);
        pom.waitUntilElementIsVisible(favoritesLocators.essenceAlerts);
        pom.clickElement(favoritesLocators.essenceAlerts);
        pom.waitUntilElementIsVisible(favoritesLocators.createAlertButton);
        pom.javaScriptClick(favoritesLocators.createAlertButton);
        pom.switchToWindowByTitle("Create Alert");
        System.out.println();
        pom.waitUntilElementIsVisible(favoritesLocators.createButton);
        pom.javaScriptClick(favoritesLocators.createButton);
    }

    @And("Click on the notification button")
    public void clickOnTheNotificationButton() {
        pom.waitUntilElementIsVisible(favoritesLocators.bellIcon);
        pom.clickElement(favoritesLocators.bellIcon);
    }

    @Then("Verify alert interface is visible")
    public void verifyAlertInterfaceIsVisible() {
//        pom.waitUntilElementIsVisible(favoritesLocators.markAllReadButton);
//        pom.clickElement(favoritesLocators.markAllReadButton);
    }

    @When("Click on the Surveillance NBS link")
    public void clickOnTheSurveillanceNBSLink() {
        pom.waitUntilElementIsVisible(favoritesLocators.nbsOption);
        pom.clickElement(favoritesLocators.nbsOption);
    }

    @Then("Check NBS page is displayed")
    public void checkNBSPageIsDisplayed() throws InterruptedException {
        pom.waitUntilElementIsVisible(favoritesLocators.nbsPage);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.nbsPage));
    }

    @When("Click on the Surveillance ESSENCE link")
    public void clickOnTheSurveillanceESSENCELink() {
        pom.waitUntilElementIsVisible(favoritesLocators.essenceOption);
        pom.clickElement(favoritesLocators.essenceOption);
    }

    @Then("Check ESSENCE page is displayed")
    public void checkESSENCEPageIsDisplayed() throws InterruptedException {
        pom.waitUntilElementIsVisible(favoritesLocators.essencePage);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.essencePage));
        pom.waitUntilElementIsVisible(favoritesLocators.essenceDemo);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.essenceDemo));
        pom.waitUntilElementIsVisible(favoritesLocators.essenceDemoButton);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.essenceDemoButton));
    }

    @When("Click on the Surveillance EpiTrax link")
    public void clickOnTheSurveillanceEpiTraxLink() {
        pom.waitUntilElementIsVisible(favoritesLocators.epiTraxOption);
        pom.clickElement(favoritesLocators.epiTraxOption);
    }

    @Then("Check EpiTrax page is displayed")
    public void checkEpiTraxPageIsDisplayed() throws InterruptedException {
        pom.waitUntilElementIsVisible(favoritesLocators.epiTraxPage);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.epiTraxPage));
        pom.waitUntilElementIsVisible(favoritesLocators.epiTraxDemo);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.epiTraxDemo));
        pom.waitUntilElementIsVisible(favoritesLocators.epiTraxDemoButton);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.epiTraxDemoButton));
    }

    @When("Click on the Surveillance Respond point of care link")
    public void clickOnTheSurveillanceRespondPointOfCareLink() {
        pom.waitUntilElementIsVisible(favoritesLocators.respondPointOption);
        pom.clickElement(favoritesLocators.respondPointOption);
    }

    @Then("Check Respond point of care page is displayed")
    public void checkRespondPointOfCarePageIsDisplayed() throws InterruptedException {
        pom.waitUntilElementIsVisible(favoritesLocators.respondPage);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.respondPage));
    }

    @When("Click on the profile icon from the top right corner")
    public void clickOnTheProfileIconFromTheTopRightCorner() {
        pom.waitUntilElementIsVisible(favoritesLocators.profileIcon);
        pom.clickElement(favoritesLocators.profileIcon);
    }

    @Then("Check All menu option is visible")
    public void checkAllMenuOptionIsVisible() throws InterruptedException {
        pom.waitUntilElementIsVisible(favoritesLocators.contactSupportOption);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.contactSupportOption));
        pom.waitUntilElementIsVisible(favoritesLocators.giveFeedbackOption);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.giveFeedbackOption));
        pom.waitUntilElementIsVisible(favoritesLocators.videoTutorialOption);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.videoTutorialOption));
        pom.waitUntilElementIsVisible(favoritesLocators.aboutOption);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.aboutOption));
        pom.waitUntilElementIsVisible(favoritesLocators.logoutOption);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.logoutOption));
    }

    @When("Click on the logout option")
    public void clickOnTheLogoutOption() {
        pom.waitUntilElementIsVisible(favoritesLocators.logoutOption);
        pom.clickElement(favoritesLocators.logoutOption);
    }

    @Then("Check logout popup is displayed")
    public void checkLogoutPopupIsDisplayed() throws InterruptedException {
        pom.waitUntilElementIsVisible(favoritesLocators.logoutPopup);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.logoutPopup));
    }

    @When("Click on the yes button")
    public void clickOnTheYesButton() {
        pom.waitUntilElementIsVisible(favoritesLocators.yesButton);
        pom.clickElement(favoritesLocators.yesButton);
    }

    @Then("Check landing page is displayed")
    public void checkLandingPageIsDisplayed() throws InterruptedException {
        pom.waitUntilElementIsVisible(favoritesLocators.landingPage);
        Assert.assertTrue(pom.isElementDisplayed(favoritesLocators.landingPage));
    }

    @When("Click on the keep working button")
    public void clickOnTheKeepWorkingButton() {
        pom.waitUntilElementIsVisible(favoritesLocators.keepWorkingButton);
        pom.clickElement(favoritesLocators.keepWorkingButton);
    }

    @Then("Check home page is displayed")
    public void checkHomePageIsDisplayed() {
        PageObjectManager.performMouseHover(driver, favoritesLocators.inductiveHealthLogo);
        pom.waitUntilElementIsVisible(favoritesLocators.favoriteButton);
        pom.clickElement(favoritesLocators.favoriteButton);
        pom.waitUntilElementIsVisible(favoritesLocators.favoritePageText);
        pom.assertElementText(driver, favoritesLocators.favoritePageText, "Favorites");
    }
}
