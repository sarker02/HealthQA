package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessageflowdataQualitypages {

	private WebDriver driver;

	public MessageflowdataQualitypages(WebDriver driver) {
		this.driver = driver;
	}

	

	public By clkonMessageflow_btn = By.xpath("//*[text()='Message Flow']");
	public By clkonELRdata_btn = By.xpath("//*[text()='ELR Data Quality']");
	
	
	
}
