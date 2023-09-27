package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavoritesIntractChartPage {

	private WebDriver driver;

	public  FavoritesIntractChartPage(WebDriver driver) {
		this.driver = driver;
	}
	public By clkonsurvilence_btn = By.xpath("//*[text()='Disease Surveillance']");
	public By clkondiseasanalyticstrends_btn = By.xpath("//*[text()='Disease Analytics and Trends']");
	public By clkoneventdate_btn = By.xpath("//*[text()='Event Date']");
	public By clkonwithinlastweek_btn = By.xpath("//*[text()='Within the last 1 Week']");
	public By clkondropdown_btn = By.xpath("//*[@id=\"root\"]/div[2]/div/main/div/section/div/main/div[1]/div[2]/div/div[2]/div/div/div[2]/div");
	public By clkondatatable = By.xpath("//*[text()='Data Table']");
	public By clkonaboutus_btn = By.xpath("//*[text()='About this data']");
	public By clkondownload_btn = By.xpath("//*[@class='h-6 text-ih-navy-700']");
	public By eventDateBtn = By.xpath("//*[@id='eventDate-WithinLastPicker']");
	public By thisDataTxt = By.xpath("//*[@style='opacity: 1; height: auto;']");
	public By downloadIcon = By.xpath("//*[@class='h-6 text-ih-navy-700']");
	public By chartDataTxt = By.xpath("//button[contains(text(),'Export Chart Data (CSV)')]");
	public By lineListTxt = By.xpath("//button[contains(text(),'Export Line List (CSV)')]");
}