package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class PageObjectManager {
    private WebDriver driver;
    private WebDriverWait wait;
    private int defaultWaitTime = 5;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * wait until element is visible for default wait time
     *
     * @param locator
     */
    public void waitUntilElementIsVisible(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * wait until element is visible for specific time
     *
     * @param locator
     * @param waitTime
     */
    public void waitUntilElementIsVisible(By locator, int waitTime) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * wait until element is clickable for specific time
     *
     * @param locator
     * @param waitTime
     */
    public void waitUntilElementIsClickable(By locator, int waitTime) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * click an element
     *
     * @param locator
     */
    public void clickElement(By locator) {
        waitUntilElementIsVisible(locator);
        driver.findElement(locator).click();
    }

    /**
     * click an element using javascript executor
     *
     * @param locator
     * @param waitTime
     */
    public void javaScriptClick(By locator, int waitTime) {
        waitUntilElementIsClickable(locator, waitTime);
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * click an element using javascript executor
     *
     * @param locator
     */
    public void javaScriptClick(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * click an element using javascript executor
     *
     * @param element
     */
    public void javaScriptClickElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * send inputs to an input field
     *
     * @param locator
     * @param inputText
     */
    public void sendKeysToElement(By locator, String inputText) {
        waitUntilElementIsVisible(locator);
        driver.findElement(locator).sendKeys(inputText);
    }

    /**
     * @param locator
     * @return true if element is displayed
     */
    public boolean isElementDisplayed(By locator) throws InterruptedException {
        Thread.sleep(1000);
        waitUntilElementIsVisible(locator);
        return driver.findElement(locator).isDisplayed();
    }

    /**
     * @param locator
     * @return text of an element
     */
    public String getTextOfElement(By locator) {
        waitUntilElementIsVisible(locator);
        return driver.findElement(locator).getText();
    }

    /**
     * @param locator
     * @return WebElement
     */
    public WebElement getWebElement(By locator) {
        waitUntilElementIsVisible(locator);
        return driver.findElement(locator);
    }

    /**
     * @param locator
     * @return WebElement
     */
    public List<WebElement> getWebElements(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Scroll down the web page by the visibility of the element
     *
     * @param locator
     */
    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * @return current url
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * check if a new window is opened with a specific title
     *
     * @param titleText
     * @return true if the title match
     */
    public boolean isTabOpened(String titleText) {
        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        wait.until(ExpectedConditions.titleContains(titleText));
        return driver.getTitle().contains(titleText);
    }

    /**
     * mouse hover with element
     *
     * @param locator
     */
    public static void performMouseHover(WebDriver driver, By locator) {
        WebElement targetElement = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(targetElement).build().perform();
    }

    /**
     * @param driver
     * @param locator
     * @param expectedText
     */
    public void assertElementText(WebDriver driver, By locator, String expectedText) {
        try {
            WebElement element = driver.findElement(locator);
            String actualText = element.getText();
            Assert.assertEquals(actualText, expectedText, "Element text does not match with expected text.");
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            // Handle exceptions if the element is not found or stale
            Assert.fail("Element not found or text not available.");
        }
    }

    /**
     * @param driver
     * @param chartLocator
     * @param starIconLocator
     * @return
     */
    // Reusable method to check if a bar chart is displayed and highlight the star icon if it is
    public boolean isBarChartDisplayedAndHighlightStar(WebDriver driver, By chartLocator, By starIconLocator) {
        try {
            // Check if the bar chart element is displayed
            WebElement chartElement = driver.findElement(chartLocator);
            if (chartElement.isDisplayed()) {
                // Highlight the star icon element
                WebElement starIconElement = driver.findElement(starIconLocator);
                highlightElement(driver, starIconElement);
                return true; // Bar chart is displayed
            }
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            // Handle exceptions if the elements are not found or stale
        }
        return false; // Bar chart is not displayed
    }

    /**
     * @param driver
     * @param element
     */
    // Helper method to highlight an element using JavaScript
    private void highlightElement(WebDriver driver, WebElement element) {
        try {
            if (driver instanceof JavascriptExecutor) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
            }
        } catch (Exception e) {
            // Handle exceptions if highlighting fails
        }
    }

    /**
     *
     * @param driver
     * @param starIconLocator
     */
    // Reusable method to remove multiple bar charts by clicking the star button
    public void removeChartsByLocator(WebDriver driver, By starIconLocator) {
        // Find all star icons with the provided locator
        List<WebElement> starIcons = driver.findElements(starIconLocator);

        // Iterate through star icons and click to remove charts
        for (WebElement starIcon : starIcons) {
            try {
                Thread.sleep(1000);
                starIcon.click();

                // Handle any confirmation or additional steps if needed
                // For example, you may need to confirm the removal through a dialog

                // You can wait for a brief moment here if necessary
                Thread.sleep(1000);
            } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
                // Handle exceptions if the star icon element is not found or stale
            } catch (InterruptedException e) {
                // Handle InterruptedException if sleep is interrupted
            }
        }
    }
}
