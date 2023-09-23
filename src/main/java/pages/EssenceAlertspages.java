package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EssenceAlertspages {

	private WebDriver driver;

	public EssenceAlertspages(WebDriver driver) {
		this.driver = driver;
	}

	public By clkonSynadromic_btn = By.xpath("//*[text()='Syndromic Analytics']");
	public By EssenceAlerts_btn = By.xpath("//*[text()='ESSENCE Alerts']");


}
