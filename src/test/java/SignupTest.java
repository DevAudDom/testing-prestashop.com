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


public class SignupTest {
    WebDriver chromeDriver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/anton/Downloads/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("unhandledPromptBehavior", "accept"); // Accept all alerts automatically (cookies or some popup)
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize(); // Maximize the window
    }

    @org.testng.annotations.Test
    public void login() throws InterruptedException {
        chromeDriver.get("https://demo.prestashop.com/#/en/front");
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));


        WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#_desktop_user_info > div > a > span")));
        signup.click();
        Thread.sleep(1000);
        WebElement createNew = chromeDriver.findElement(By.cssSelector("#content > div > a"));
        createNew.click();
        Thread.sleep(1000);
        WebElement Gender = chromeDriver.findElement(By.id("field-id_gender-1"));
        Gender.click();
        Thread.sleep(1000);
        WebElement FName = chromeDriver.findElement(By.id("field-firstname"));
        FName.sendKeys("Jose");
        Thread.sleep(1000);
        WebElement LName = chromeDriver.findElement(By.id("field-lastname"));
        LName.sendKeys("F");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(1000);
        WebElement Email = chromeDriver.findElement(By.id("field-email"));
        Email.sendKeys("antoniofdez2203@gmail.com");
        Thread.sleep(1000);
        WebElement Password = chromeDriver.findElement(By.id("field-password"));
        Password.sendKeys("Jose5445!!");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(1000);
        WebElement Birthdate = chromeDriver.findElement(By.id("field-birthday"));
        Birthdate.sendKeys("05/26/1991");
        Thread.sleep(1000);
        WebElement checkbox = chromeDriver.findElement(By.cssSelector("#customer-form > div > div:nth-child(8) > div.col-md-6.js-input-column > span > label > input[type=checkbox]"));
        checkbox.click();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(1000);
        WebElement checkbox2 = chromeDriver.findElement(By.cssSelector("#customer-form > div > div:nth-child(10) > div.col-md-6.js-input-column > span > label > input[type=checkbox]"));
        checkbox2.click();
        Thread.sleep(1000);
        WebElement save = chromeDriver.findElement(By.cssSelector("#customer-form > footer > button"));
        save.click();
        Thread.sleep(1000);

        chromeDriver.switchTo().defaultContent(); // get out of iframe
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive"))); // get back into iframe

        WebElement signOut = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#_desktop_user_info > div > a.logout.hidden-sm-down")));
        signOut.click();
        Thread.sleep(1000);

        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#_desktop_user_info > div > a > span")));
        login.click();
        Thread.sleep(1000);
        WebElement email = chromeDriver.findElement(By.id("field-email"));
        email.sendKeys("antoniofdez2203@gmail.com");
        Thread.sleep(1000);
        WebElement pass = chromeDriver.findElement(By.id("field-password"));
        Thread.sleep(1000);
        pass.sendKeys("Jose5445!!");
        Thread.sleep(1000);
        WebElement loginButton = chromeDriver.findElement(By.id("submit-login"));
        loginButton.click();
    }
}

