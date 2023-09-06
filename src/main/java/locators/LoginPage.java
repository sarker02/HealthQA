package locators;

import org.openqa.selenium.By;

public class LoginPage {
    public By usernameField = By.id("username");
    public By passwordField = By.id("password");
    public By loginButton = By.xpath("(//input[@value='Sign in'])[1]");
    public By invalidUserInfo = By.id("userMessageText");
}
