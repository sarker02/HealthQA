package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessageFlowPage {
	
	private WebDriver driver;

	public MessageFlowPage(WebDriver driver) {
		this.driver = driver;
	}
	public By clkonMessageflow_btn = By.xpath("//*[text()='Message Flow']");
	public By clkonELRdata_btn = By.xpath("//*[text()='ELR Data Quality']");
	public By clkonELRReport_btn = By.xpath("//*[text()='ELR Flow Report']");	
}
