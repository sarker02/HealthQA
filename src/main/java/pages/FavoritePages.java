package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavoritePages {
	
	private WebDriver driver;

	public FavoritePages(WebDriver driver) {
		this.driver = driver;
	}
	
	public By diseaseSurveillanceBtn = By.xpath("//*[text()='Disease Surveillance']");
	public By clkondiseasanalyticstrends_btn = By.xpath("//*[text()='Disease Analytics and Trends']");
	public By clkoneventdate_btn = By.xpath("//*[text()='Event Date']");
	public By clkonwithinlastweek_btn = By.xpath("//*[text()='Within the last 1 Week']");

	public By clkondropdown_btn = By.xpath("//*[@id=\"root\"]/div[2]/div/main/div/section/div/main/div[1]/div[2]/div/div[2]/div/div/div[2]/div");

	public By clkondatatable = By.xpath("//*[text()='Data Table']");

	public By clkonaboutus_btn = By.xpath("//*[text()='About this data']");
	public By clkondownload_btn = By.xpath("//*[@class='h-6 text-ih-navy-700']");
	
	
	public By clkonInvestigationmanagment_btn = By.xpath("//*[@href='/insights/epi/quality']");
	
}
