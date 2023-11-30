package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaunchServiceEnvironmentPage {
	private WebDriver driver;

	public LaunchServiceEnvironmentPage(WebDriver driver) {
		this.driver = driver;
	}
	public By nbsOption = By.xpath("//*[contains(normalize-space(),'NBS') and contains(@class,'flex-1 whitespace-nowrap') ]");
	public By essenceOption = By.xpath("//*[@class='flex-1 whitespace-nowrap'][normalize-space()='ESSENCE']");
	public By epiTraxOption = By.xpath("//*[@class='flex-1 whitespace-nowrap'][normalize-space()='EpiTrax']");
	public By respondPointOption = By.xpath("//*[@class='flex-1 whitespace-nowrap'][normalize-space()='Respond Point-Of-Care']");
	public By nbsPage = By.xpath("//*[contains(text(),'InductiveHealth NBS')]");
	public By essencePage = By.xpath("//*[contains(normalize-space(),'InductiveHealth ESSENCE')and contains(@class,'inline-block ')]");
	public By essenceDemo = By.xpath("//*[normalize-space()='ESSENCE - Demo']");
	public By essenceDemoButton = By.xpath("//*[@title='https://essencedemo.inductivehealth.com/ih_essence']");
	public By epiTraxPage = By.xpath("//*[contains(normalize-space(),'EpiTrax') and contains(@class,'flex-1 whitespace-nowrap') ]");
	public By epiTraxDemo = By.xpath("//*[normalize-space()='EpiTrax Platform - Demo']");
	public By epiTraxDemoButton = By.xpath("//span[contains(text(),'Launch Demo EpiTrax')]");
	public By respondPage = By.xpath("//*[contains(normalize-space(),'InductiveHealth Respond Point-Of-Care') and contains(@class,'inline-block font')]");
}
