import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.Keys;

public class SearchTest {
    WebDriver chromeDriver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\danie\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("unhandledPromptBehavior", "accept"); // Accept all alerts automatically (cookies or some popup)
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize(); // Maximize the window
    }

    @org.testng.annotations.Test
    public void search() throws InterruptedException {
        chromeDriver.get("https://demo.prestashop.com/#/en/front");
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));

        WebElement searchbar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search_widget > form > input.ui-autocomplete-input")));
        //Clicking Searchbar
        searchbar.click();
        Thread.sleep(1000);
        //Typing in searchbar
        searchbar.sendKeys("art");
        Thread.sleep(1000);
        //Searching
        searchbar.sendKeys(Keys.RETURN);
        Thread.sleep(2000);
        //Filtering items
        WebElement filter = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-product-list-top > div.col-lg-7 > div > div > button")));
        filter.click();
        Thread.sleep(1000);
        WebElement atoz = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-product-list-top > div.col-lg-7 > div > div > div > a:nth-child(2)")));
        atoz.click();
        Thread.sleep(1000);
        //Clicking a product from the search
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(1000);
        WebElement productArt = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-product-list > div.products.row > div:nth-child(5) > article > div > div.thumbnail-top")));
        productArt.click();
        Thread.sleep(2000);

    }
}
