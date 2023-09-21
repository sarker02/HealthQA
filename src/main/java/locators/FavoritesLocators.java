package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FavoritesLocators {
    public static WebDriver driver;

    public By inductiveHealthLogo = By.xpath("(//img[@alt='Inductive Health Solutions'])[1]");
    public By noFavoritesAlertText = By.xpath("(//p[@class='text-sm'])[1]");
    public By chartList = By.xpath("//div[@class='break-inside-avoid-column']");
    public By starIcon = By.xpath("//button[@title='Remove Favorite']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]");
    //    public By starIcon = By.xpath("(//button[@title='Remove Favorite'])");
    public By starIconAdd = By.xpath("(//button[@title='Add Favorite'])");
    public By favoriteButton = By.xpath("//a[@href='/home']//button");
    public By favoritePageText = By.xpath("//h1[normalize-space()='Favorites']");
    public By diseaseSurveillanceButton = By.xpath("(//span[@class='flex-1 whitespace-nowrap'][normalize-space()='Disease Surveillance'])[1]");
    public By diseaseAnalytics = By.xpath("//span[@class='flex-1 whitespace-nowrap'][normalize-space()='Disease Analytics and Trends']");
    public By diseaseChartTitle = By.xpath("(//h1[normalize-space()='Stratified Investigation Volume Over Time'])[1]");

    //Heal_13
    public By syndromicAnalytics = By.xpath("(//span[@class='flex-1 whitespace-nowrap'][normalize-space()='Syndromic Analytics'])[1]");
    public By essenceAlerts = By.xpath("(//span[@class='flex-1 whitespace-nowrap'][normalize-space()='ESSENCE Alerts'])[1]");
    public By createAlertButton = By.cssSelector("div[class='relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden'] button:nth-child(2)");
    public By createButton = By.xpath("(//button[@type='submit'])[1]");
    public By bellIcon = By.xpath("//button[@class = 'inline-flex relative items-center']");
    public By markAllReadButton = By.xpath("//div[contains(text(), 'Mark All As Read')]");
}

