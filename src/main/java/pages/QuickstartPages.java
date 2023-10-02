package pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuickstartPages {

	private WebDriver driver;

	public QuickstartPages(WebDriver driver) {
		this.driver = driver;
	}


	public By usernameTxt = By.xpath("//*[@id='username']");
	public By passwordTxt = By.xpath("//*[@id='password']");
	public By loginBtn = By.xpath("//*[@type='submit']");
	public By clkonsearc_box = By.xpath("//*[@id='default-search']");

	public By clkonfirstquiry = By.xpath("/html/body/div[2]/ul/li[1]/a/div[2]");


	public void login() {

		// enter username and password
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("inductiveEpitraxAdmin");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Pass!2345678");

		driver.findElement(By.xpath("//*[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		WebElement Epitraxinductive= driver.findElement(By.xpath("//*[text()='Epitrax Inductive']"));
		Assert.assertEquals(true, Epitraxinductive.isDisplayed());
		System.out.print("Epitraxinductive text is displayed");


	}



}
