package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Insightmanagmentpages {

	
	
	private WebDriver driver;

	public Insightmanagmentpages(WebDriver driver) {
		this.driver = driver;
	}

	public By clkonsurvilence_btn = By.xpath("//*[text()='Disease Surveillance']");
	public By clkonanalytictrends_btn = By.xpath("//*[text()='Disease Analytics and Trends']");
	public By clkeventdate_Btn = By.xpath("//*[text()='Event Date']");
	public By clkonlastweek_btn = By.xpath("//*[text()='Within the last 1 Week']");
	
	public By clkondrpdwn_btn = By.xpath("//*[@id=\"root\"]/div[2]/div/main/div/section/div/main/div[1]/div[2]/div/div[2]/div/div/div[2]/div");
	
	public By clkondatatable = By.xpath("//*[text()='Data Table']");

	
	
	
	
}
