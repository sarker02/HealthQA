package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	public By favoritesBtn = By.xpath("//h1[contains(text(),'Favorites')]");
	public By solutionPortalTxt = By.xpath("//*[text()='Solutions Portal']");
	public By searchBar = By.xpath("//*[@id='default-search']");
    public By firstUserInSearchResults = By.xpath("/html/body/div[2]/ul/li[1]/a/div[2]");
    public By noSearchResultsFoundTxt = By.xpath("//*[text()='No results found']");

    public By patientCassinRendaRecord = By.xpath("//*[contains(text(), 'Renda')]");
    public By patientCassinVasilikiRecord = By.xpath("//*[contains(text(), 'Vasiliki')]");
    public By patientCassinVelvaRecord = By.xpath("//*[contains(text(), 'Velva')]");
    
    public void performSearch(String searchString) throws InterruptedException {
		driver.findElement(searchBar).click();
		driver.findElement(searchBar).sendKeys(searchString);
		Thread.sleep(5000);
    }
}
