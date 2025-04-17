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
//    @Test(priority = 2)
//    public void filterMensClothes() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
//        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
//        Actions action = new Actions(chromeDriver);
//        chromeDriver.get("https://rabid-poison.demo.prestashop.com/en/3-clothes");
//        // Medium size filter
////        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));
//        WebElement menButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a")));
//        Thread.sleep(5000);
//        menButton.click();
//        Thread.sleep(5000);
//
//        js.executeScript("window.scrollBy(0,500)");
//        Thread.sleep(1000);
//            // check medium size box
//        WebElement medButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[@id=\"facet_15123\"]/li[2]/label/a")));
//        medButton.click();
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
//    }
    @Test(priority = 2)
    public void sortByClothing() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        Actions action = new Actions(chromeDriver);
        // navigate to clothes and click mens
        chromeDriver.get("https://expert-motion.demo.prestashop.com/en/3-clothes");
        WebElement menButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a")));
        Thread.sleep(5000);
        menButton.click();
        Thread.sleep(5000);
        // mens clothing has loaded
        //click low to high
        js.executeScript("window.scrollBy(0,250)");
        Thread.sleep(2000);
        WebElement sortByButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"js-product-list-top\"]/div[2]/div/div[1]/button")));
        sortByButton.click();
        WebElement lowToHighDDB = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"js-product-list-top\"]/div[2]/div/div[1]/div/a[5]")));
        lowToHighDDB.click();
        //click name
        js.executeScript("window.scrollBy(0,250)");
        wait.until(ExpectedConditions.elementToBeClickable(sortByButton));
        Thread.sleep(2000);
        WebElement sortByButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"js-product-list-top\"]/div[2]/div/div[1]/button")));
        sortByButton2.click();
        WebElement nameDD = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"js-product-list-top\"]/div[2]/div/div[1]/div/a[3]")));
        nameDD.click();

    }
    @Test()
    public void viewClothingDetails() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
        Actions action = new Actions(chromeDriver);
        chromeDriver.get("https://expert-motion.demo.prestashop.com/en/3-clothes");
        // load clothes page
        WebElement menButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a")));
        menButton.click();
        WebElement clothingThumbnail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a")));
        action.moveToElement(clothingThumbnail).perform();
        Thread.sleep(5000);
        WebElement quickView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/div/a")));
    }
//    @Test()
//    public void changeClothingSpecs() throws InterruptedException {
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



}
