package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public WebDriver driver;

    public By inductiveHealthLogo = By.xpath("(//img[@alt='Inductive Health Solutions'])[1]");
    public By noFavoritesAlertText = By.xpath("(//p[@class='text-sm'])[1]");
    public By chartList = By.xpath("//div[@class='break-inside-avoid-column']");
    public By starIcon = By.xpath("//div[@class='break-inside-avoid-column']");

}
