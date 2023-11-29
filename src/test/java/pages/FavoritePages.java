package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavoritePages {
	
	private WebDriver driver;

	public FavoritePages(WebDriver driver) {
		this.driver = driver;
	}
	
	public By diseaseSurveillance = By.xpath("//*[text()='Disease Surveillance']");
	public By diseaseAnalyticsTrends = By.xpath("//*[text()='Disease Analytics and Trends']");
	public By eventDateBtn = By.xpath("//*[text()='Event Date']");
	public By lastWeekBtn = By.xpath("//*[text()='Within the last 1 Week']");
	public By dropDown = By.xpath("//*[@id=\"root\"]/div[2]/div/main/div/section/div/main/div[1]/div[2]/div/div[2]/div/div/div[2]/div");
	public By dataTable = By.xpath("//*[text()='Data Table']");
	public By geographicDist = By.xpath("//*[text()='Geographical Distribution']");
	public By aboutUsBtn = By.xpath("//*[text()='About this data']");
	public By downloadBtn = By.xpath("//*[@class='h-6 text-ih-navy-700']");
	public By investigationManagment = By.xpath("//*[text()='Investigation Management']");
	public By utilizationDashboard = By.xpath("//*[text()='Utilization Dashboard']");
	public By allFilter = By.xpath("//*[@id=\"root\"]/div[2]/div/main/div/section/div/main/div[1]/div[1]");
	public By chartValueBox = By.xpath("//*[@class='pl-3 pt-1 text-gray-500 text-sm']");
	public By exportChartData = By.xpath("//*[text()='Export Chart Data (CSV)']");
	public By exportLineList = By.xpath("//*[text()='Export Line List (CSV)']");
	public By aboutThisDataTxt = By.xpath("//*[@class='font-bold text-lg md:text-md mr-2']");
	
}
