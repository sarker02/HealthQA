package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagementPage {
	
		private WebDriver driver;

		public  ManagementPage(WebDriver driver) {
			this.driver = driver;
		}
		public By ClkonManagment_btn = By.xpath("//*[text()='Management']");
		public By ClkInvestigationResolution_btn = By.xpath("//*[text()='Investigation Resolution']");
		public By clkonuserActivity_btn = By.xpath("//*[text()='User Activity']");	
	}

