package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertInterfacePage {
	private WebDriver driver;

	public AlertInterfacePage(WebDriver driver) {
		this.driver = driver;
	}

	public By syndromicAnalytics = By.xpath("//*[contains(@class,'flex-1 whitespace-nowrap') and contains(normalize-space(),'Syndromic Analytics')]");
	public By essenceAlerts = By.xpath("//*[contains(@class,'flex-1 whitespace-nowrap')and contains(normalize-space(),'ESSENCE Alerts')]");
	public By createAlertButton = By.xpath("//*[contains(@class,'p-1.5 bg-white leaflet-bar leaflet-contr') and contains(normalize-space(),'Create Alert')]");
	public By createButton = By.xpath("//*[contains(@type,'submit')and contains(@class,'relative overflow-hidden')]");
	public By bellIcon = By.xpath("//*[contains(@class,'inline-flex relative items-center')]");
	public By markAllReadButton = By.xpath("//*[contains(text(), 'Mark All As Read')]");

	public void switchToWindowByTitle(String windowTitle) {
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
			if (driver.getTitle().equals(windowTitle)) {
				break; // Found the desired window, exit the loop
			}
		}
	}
	public void javaScriptClickElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);	
	}
}
