package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessageflowELRReportpages {

	
	private WebDriver driver;

	public  MessageflowELRReportpages(WebDriver driver) {
		this.driver = driver;
	}

	

	public By clkonmessageflow_dropdown = By.xpath("//*[text()='Message Flow']");
	public By clkonELRReport_btn = By.xpath("//*[text()='ELR Flow Report']");
	
	
	
}
