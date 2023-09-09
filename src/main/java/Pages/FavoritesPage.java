package Pages;

import locators.FavoritesLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class FavoritesPage extends FavoritesLocators {
    public FavoritesPage(WebDriver driver) {
        this.driver = driver;
    }
    public List<WebElement> getSaveButtonList() {
        return driver.findElements(starIcon);
    }



}
