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

    //Heal_14
    public By nbsOption = By.xpath("(//span[@class='flex-1 whitespace-nowrap'][normalize-space()='NBS'])[1]");
    public By essenceOption = By.xpath("(//span[@class='flex-1 whitespace-nowrap'][normalize-space()='ESSENCE'])[1]");
    public By epiTraxOption = By.xpath("(//span[@class='flex-1 whitespace-nowrap'][normalize-space()='EpiTrax'])[1]");
    public By respondPointOption = By.xpath("(//span[@class='flex-1 whitespace-nowrap'][normalize-space()='Respond Point-Of-Care'])[1]");
    public By nbsPage = By.xpath("(//h1[normalize-space()='InductiveHealth NBS'])[1]");
    public By essencePage = By.xpath("(//h1[normalize-space()='InductiveHealth ESSENCE'])[1]");
    public By essenceDemo = By.xpath("(//h1[normalize-space()='ESSENCE - Demo'])[1]");
    public By essenceDemoButton = By.xpath("(//button[@title='https://essencedemo.inductivehealth.com/ih_essence'])[1]");
    public By epiTraxPage = By.xpath("(//h1[normalize-space()='InductiveHealth EpiTrax Platform'])[1]");
    public By epiTraxDemo = By.xpath("(//h1[normalize-space()='EpiTrax Platform - Demo'])[1]");
    public By epiTraxDemoButton = By.xpath("(//button[@title='https://epitraxdemo.inductivehealth.com/epitrax'])[1]");
    public By respondPage = By.xpath("(//h1[normalize-space()='InductiveHealth EpiTrax Platform'])[1]");

    //Heal_17
    public By profileIcon = By.xpath("//p[contains(text(), 'Epitrax Inductive')]");
    public By contactSupportOption = By.xpath("(//button[normalize-space()='Contact Support'])[1]");
    public By giveFeedbackOption = By.xpath("(//button[normalize-space()='Give Feedback'])[1]");
    public By videoTutorialOption = By.xpath("(//a[normalize-space()='Video Tutorials'])[1]");
    public By aboutOption = By.xpath("(//button[normalize-space()='About'])[1]");
    public By logoutOption = By.xpath("(//a[normalize-space()='Log Out'])[1]");
    public By logoutPopup = By.xpath("(//div[@class='sm:flex'])[1]");
    public By yesButton = By.xpath("(//button[normalize-space()='Yes'])[1]");
    public By landingPage = By.xpath("(//div[@class='form-background rounded'])[1]");
    public By keepWorkingButton = By.xpath("(//button[normalize-space()='No, Keep Working'])[1]");

    //Heal-18
    public By tutorialOption = By.xpath("(//a[normalize-space()='Video Tutorials'])[1]");
    public By videoTutorialPage = By.xpath("(//h1[normalize-space()='Video Tutorials'])[1]");

}

