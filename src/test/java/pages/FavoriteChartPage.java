package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FavoriteChartPage {
	private WebDriver driver;

	public FavoriteChartPage(WebDriver driver) {
		this.driver = driver;
	}
	public By inductiveHealthLogo = By.xpath("//*[contains(@alt,'Inductive Health Solutions') and contains(@class,'object-scale-down mt-4 mb-0.5')]");
    public By noFavoritesAlertText = By.xpath("//*[contains(@class,'p-2 text-sm text-gray-500')]");
    public By chartList = By.xpath("//*[contains(@class,'break-inside-avoid-column')]");
    public By starIcon = By.xpath("//*[contains(@title,'Remove Favorite')]//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]");
    public By starIconAdd = By.xpath("//*[contains(@title,'Add Favorite')]");
    public By favoriteButton = By.xpath("//*[contains(@href,'/home')]//button");
    public By favoritePageText = By.xpath("//*[contains(normalize-space(),'Favorites') and contains(@class,'inline-block font')]");
    public By diseaseSurveillanceButton = By.xpath("//*[contains(@class,'flex-1 whitespace-nowrap') and contains(normalize-space(),'Disease Surveillance')]");
    public By diseaseAnalytics = By.xpath("//*[contains(@class,'flex-1 whitespace-nowrap') and contains(normalize-space(),'Disease Analytics and Trends')]");
    public By diseaseChartTitle = By.xpath("//*[contains(normalize-space(),'Stratified Investigation Volume Over Time') and contains(@class,'font-bold text-lg md:text-md mr-2')]");

    public void performMouseHover(WebDriver driver, By locator) {
        WebElement targetElement = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(targetElement).build().perform();
    }
    public boolean isBarChartDisplayedAndHighlightStar(WebDriver driver, By chartLocator, By starIconLocator) {
        try {
            // Check if the bar chart element is displayed
            WebElement chartElement = driver.findElement(chartLocator);
            if (chartElement.isDisplayed()) {
                // Highlight the star icon element
                WebElement starIconElement = driver.findElement(starIconLocator);
                highlightElement(driver, starIconElement);
                return true; // Bar chart is displayed
            }
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            // Handle exceptions if the elements are not found or stale
        }
        return false; // Bar chart is not displayed
    }
    public void highlightElement(WebDriver driver, WebElement element) {
        try {
            if (driver instanceof JavascriptExecutor) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
            }
        } catch (Exception e) {
            // Handle exceptions if highlighting fails
        }
    }
}
