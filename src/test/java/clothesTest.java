import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class clothesTest {
    WebDriver chromeDriver;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/domlu/OneDrive - Florida Gulf Coast University/Spring 2025/ST/Installations/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        chromeDriver = new ChromeDriver(); // why new?
        chromeDriver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void navigateToMensClothes() throws InterruptedException {
        chromeDriver.get("https://demo.prestashop.com/#/en/front");
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));
        Thread.sleep(5000);
        WebElement parentMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"category-3\"]")));
        parentMenu.click();
         // load clothes page
        WebElement menButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a")));
        Thread.sleep(5000);
        menButton.click();
    }
    @Test(priority = 2)
    public void filterMensClothes() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        Actions action = new Actions(chromeDriver);
        chromeDriver.get("https://rabid-poison.demo.prestashop.com/en/3-clothes");
        // Medium size filter
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));
        WebElement menButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a")));
        Thread.sleep(5000);
        menButton.click();
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
            // check medium size box
        WebElement medButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"facet_15123\"]/li[2]/label/a")));
        medButton.click();
//        //Black Shirt filter
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));
//        Thread.sleep(5000);
//        js.executeScript("window.scrollBy(0,500)");
//        WebElement blackFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"facet_22650\"]/li[2]/label/span")));
//        blackFilter.click();
//        // In stock filter
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));
//        Thread.sleep(5000);
//        js.executeScript("window.scrollBy(0,500)");
//        WebElement inStockFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"facet_93738\"]/li[2]/label/span")));
//        inStockFilter.click();
    }
//    @Test()
//    public void likeClothing() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
//        chromeDriver.get("https://demo.prestashop.com/#/en/front");
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));
//        Thread.sleep(2000);
//        WebElement parentMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"category-3\"]")));
//        parentMenu.click();
//        // load clothes page
//        WebElement menButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a")));
//        menButton.click();
//    }
//    @Test()
//    public void preCheckoutClothingModifications() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
//        chromeDriver.get("https://demo.prestashop.com/#/en/front");
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));
//        Thread.sleep(2000);
//        WebElement parentMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"category-3\"]")));
//        parentMenu.click();
//        // load clothes page
//        WebElement menButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a")));
//        menButton.click();
//    }
//    @Test()
//    public void enhanceAndSSClothingImage() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
//        chromeDriver.get("https://demo.prestashop.com/#/en/front");
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));
//        Thread.sleep(2000);
//        WebElement parentMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"category-3\"]")));
//        parentMenu.click();
//        // load clothes page
//        WebElement menButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a")));
//        menButton.click();
//    }


//    public void searchNewCar() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
//        chromeDriver.get("https://demo.prestashop.com/#/en/front");
//
//        try
//        }
//        catch (Exception createPlaylistException){
//            System.out.println("Error occurred on locating element within 15 seconds. Error Message: " + createPlaylistException.getMessage());
//        }
//
//
//    @Test ()
//    public void enterNewPassword() throws InterruptedException {
//        Thread.sleep(2000); // wait for page to load
//        WebElement newPassword = chromeDriver.findElement(By.id("new-password"));
//        newPassword.sendKeys("123456789a");
//        WebElement nextButton = chromeDriver.findElement(By.cssSelector(".Button-sc-qlcn5g-0.VsdHm.encore-text-body-medium-bold"));
//        Thread.sleep(2000);
//        nextButton.click();
//    }
//    @Test ()
//    public void enterStep2Signup() throws InterruptedException {
//        Thread.sleep(2000); // wait for page to load
//        WebElement newName = chromeDriver.findElement(By.id("displayName"));
//        newName.sendKeys("test name");
//        WebElement DOBMonth = chromeDriver.findElement(By.id("month"));
//        // use seleniums special select object and pass in element
//        Select monthDD = new Select(DOBMonth);
//        Thread.sleep(2000);
//        monthDD.selectByValue("1");
//        WebElement DOBDay = chromeDriver.findElement(By.id("day"));
//        DOBDay.sendKeys("01");
//        WebElement DOBYear = chromeDriver.findElement(By.id("year"));
//        DOBYear.sendKeys("2000");
//        WebElement gender = chromeDriver.findElement(By.xpath("//span[text()='Something else']"));
//        gender.click();
//        WebElement nextButton = chromeDriver.findElement(By.cssSelector(".Button-sc-qlcn5g-0.VsdHm.encore-text-body-medium-bold"));
//        Thread.sleep(2000); // button seems not to get pressed unless we wait before
//        nextButton.click();
//    }
//
//    @Test ()
//    public void enterStep3Signup() throws InterruptedException {
//        Thread.sleep(2000); // wait for page to laod
//        WebElement checkbox = chromeDriver.findElement(By.cssSelector(".Indicator-sc-1airx73-0.lhZnAn"));
//        checkbox.click();
//        WebElement signUpButton = chromeDriver.findElement(By.cssSelector(".ButtonInner-sc-14ud5tc-0.hvvTXU.encore-bright-accent-set"));
//        Thread.sleep(2000); // button seems not to get pressed unless we wait before
//        signUpButton.click();
//    }
}
