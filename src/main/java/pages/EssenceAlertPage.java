package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EssenceAlertPage {

	private WebDriver driver;

	public EssenceAlertPage(WebDriver driver) {
		this.driver = driver;
	}

	public By syndromicBtn= By.xpath("//*[text()='Syndromic Analytics']");
	public By essenceAlertsBtn = By.xpath("//*[text()='ESSENCE Alerts']");
	public By downloadBtn = By.xpath("//button[contains(@type,'button') and  contains(@title,'Favorite')]/following-sibling::div/div/button");
	public By lineListBtn = By.xpath("//button[contains(text(),'Export Line List (CSV)')]");
	public By chartDataBtn = By.xpath("//button[contains(text(),'Export Chart Data (CSV)')]");
}
