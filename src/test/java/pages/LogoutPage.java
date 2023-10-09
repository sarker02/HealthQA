/**
 * 
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 */
public class LogoutPage {
	private WebDriver driver;

	public LogoutPage (WebDriver driver) {
		this.driver = driver;
	}
	public By inductiveHealthLogo = By.xpath("//*[contains(@alt,'Inductive Health Solutions') and contains(@class,'object-scale-down mt-4 mb-0.5')]");
	public By profileIcon = By.xpath("//*[contains(text(), 'Epitrax Inductive')]");
	public By contactSupportOption = By.xpath("//*[contains(normalize-space(),'Contact Support') and contains(@type,'button')]");
	public By giveFeedbackOption = By.xpath("//*[contains(normalize-space(),'Give Feedback') and contains(@type,'button')]");
	public By videoTutorialOption = By.xpath("//*[contains(normalize-space(),'Video Tutorials') and contains(@class,'font-medium text-gray')]");
	public By aboutOption = By.xpath("//*[contains(normalize-space(),'About')and contains(@type,'button')]");
	public By logoutOption = By.xpath("//*[contains(normalize-space(),'Log Out') and contains(@role,'menuitem')]");
	public By logoutPopup = By.xpath("(//div[@class='sm:flex'])[1]");
	public By yesButton = By.xpath("//*[contains(normalize-space(),'Yes') and contains(@class,'w-full mt-2 p-2.5 flex-1 text-white bg-i')]");
	public By landingPage = By.xpath("(//div[@class='form-background rounded'])[1]");
	public By keepWorkingButton = By.xpath("(//button[normalize-space()='No, Keep Working'])[1]");


}
