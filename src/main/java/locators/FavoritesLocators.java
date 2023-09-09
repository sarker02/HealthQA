package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FavoritesLocators {
    public static WebDriver driver;

    public By inductiveHealthLogo = By.xpath("(//img[@alt='Inductive Health Solutions'])[1]");
    public By noFavoritesAlertText = By.xpath("(//p[@class='text-sm'])[1]");
    public By chartList = By.xpath("//div[@class='break-inside-avoid-column']");
//    public By starIcon = By.xpath("//button[@title='Remove Favorite']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]");
    public By starIcon = By.xpath("(//button[@title='Remove Favorite'])");
    public By favoriteButton = By.xpath("(//button)[1]");
    public By favoritePageText = By.xpath("//h1[normalize-space()='Favorites']");

}

