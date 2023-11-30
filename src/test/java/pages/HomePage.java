package pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import steps.QuickSearchSteps;

public class HomePage {
	
	
	public static Logger logger = Logger.getLogger(HomePage.class.getName());
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	public By favoritesBtn = By.xpath("//h1[contains(text(),'Favorites')]");
	public By solutionPortalTxt = By.xpath("//*[text()='Solutions Portal']");
	public By searchBar = By.xpath("//*[@id='default-search']");
    public By firstUserInSearchResults = By.xpath("/html/body/div[2]/ul/li[1]/a/div[2]");
    public By noSearchResultsFoundTxt = By.xpath("//*[text()='No results found']");
    public By patientCassinClaudineRecord = By.xpath("//*[contains(text(),'Claudine')]");
    public By patientCassinMclaughlinRecord = By.xpath("/html/body/div[3]/ul/li[1]/a/div[1]");
    public By patientCassinSanjuanitaRecord = By.xpath("/html/body/div[3]/ul/li[4]/a");
    

   
    public By resultsContainingText(String text) {
        return By.xpath("//*[contains(text(),'" + text + "')]");
    }

    public void performSearch(String searchString) throws InterruptedException {
		driver.findElement(searchBar).click();
		driver.findElement(searchBar).sendKeys(searchString);
		Thread.sleep(5000);
    }
    
    public void compareTwoOptions (By option1,By option2 ) {
    	
    	try {
			boolean displayedOption1=driver.findElement(option1).isDisplayed();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean displayedOption2 =driver.findElement(option2).isDisplayed();

			if(displayedOption1 && displayedOption2) {
				System.out.print("Options are available");
                 logger.info("Options are available");
			}else {

				System.out.print("Options are not available");
				 logger.info("Options are not available");
			}

		}catch (Exception e) {

			System.out.print("This Option is not available= \t" + e);
			 logger.info("This options is not available");
		}

    } 
}
