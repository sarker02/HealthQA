package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InductiveHealthLogoPage {
	private WebDriver driver;

	public InductiveHealthLogoPage(WebDriver driver) {
		this.driver = driver;
	}
	public By tutorialOption = By.xpath("//*[contains(normalize-space(),'Video Tutorials') and contains(@class,'font-medium text-gray')]");
	public By videoTutorialPage = By.xpath("//*[contains(normalize-space(),'Video Tutorials') and contains(@class,'inline-block font-bold text-2xl')]");
}
