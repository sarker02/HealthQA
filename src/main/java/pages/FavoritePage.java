package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavoritePage {
	private WebDriver driver;

	public FavoritePage(WebDriver driver) {
		this.driver = driver;
	}
	public By diseaseSurveillanceBtn = By.xpath("//span[@class='flex-1 whitespace-nowrap'][normalize-space()='Disease Surveillance']");
	public By clkondiseasanalyticstrends_btn = By.xpath("//span[@class='flex-1 whitespace-nowrap'][normalize-space()='Disease Analytics and Trends']");
	public By clkoneventdate_btn = By.xpath("//div[normalize-space()='Event Date']");
	public By clkonwithinlastweek_btn = By.xpath("//*[text()='Within the last 1 Week']");
	public By clkondropdown_btn = By.xpath("//*[@id=\"root\"]/div[2]/div/main/div/section/div/main/div[1]/div[2]/div/div[2]/div/div/div[2]/div");
	public By clkondatatable = By.xpath("//*[text()='Data Table']");
	public By clkonaboutus_btn = By.xpath("//*[text()='About this data']");
	public By clkondownload_btn = By.xpath("//button[contains(@type,'button') and  contains(@title,'Favorite')]/following-sibling::div/div/button");
	public By clkonInvestigationmanagment_btn = By.xpath("//*[@href='/insights/epi/quality']");
	public By clkonUtilizationdashboard_btn = By.xpath("//*[@href='/insights/epi/utilization']");
}
