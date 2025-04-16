import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignupTest {
    WebDriver chromeDriver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/domlu/OneDrive - Florida Gulf Coast University/Spring 2025/ST/Installations/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        chromeDriver = new ChromeDriver(); // why new?
        chromeDriver.manage().window().maximize();
    }

    @Test ()
    public void enterNewEmail() throws InterruptedException {
        chromeDriver.get("https://www.spotify.com/us/signup?forward_url=https%3A%2F%2Fopen.spotify.com%2F");

        WebElement emailAddress = chromeDriver.findElement(By.id("username"));
        emailAddress.sendKeys("pronoodlesoup@gmail.com");
        WebElement nextButton = chromeDriver.findElement(By.cssSelector(".Button-sc-qlcn5g-0.VsdHm.encore-text-body-medium-bold"));
        Thread.sleep(2000); // button seems not to get pressed unless we wait before
        nextButton.click();}
    @Test ()
    public void enterNewPassword() throws InterruptedException {
        Thread.sleep(2000); // wait for page to load
        WebElement newPassword = chromeDriver.findElement(By.id("new-password"));
        newPassword.sendKeys("123456789a");
        WebElement nextButton = chromeDriver.findElement(By.cssSelector(".Button-sc-qlcn5g-0.VsdHm.encore-text-body-medium-bold"));
        Thread.sleep(2000);
        nextButton.click();
    }
    @Test ()
    public void enterStep2Signup() throws InterruptedException {
        Thread.sleep(2000); // wait for page to load
        WebElement newName = chromeDriver.findElement(By.id("displayName"));
        newName.sendKeys("test name");
        WebElement DOBMonth = chromeDriver.findElement(By.id("month"));
        // use seleniums special select object and pass in element
        Select monthDD = new Select(DOBMonth);
        Thread.sleep(2000);
        monthDD.selectByValue("1");
        WebElement DOBDay = chromeDriver.findElement(By.id("day"));
        DOBDay.sendKeys("01");
        WebElement DOBYear = chromeDriver.findElement(By.id("year"));
        DOBYear.sendKeys("2000");
        WebElement gender = chromeDriver.findElement(By.xpath("//span[text()='Something else']"));
        gender.click();
        WebElement nextButton = chromeDriver.findElement(By.cssSelector(".Button-sc-qlcn5g-0.VsdHm.encore-text-body-medium-bold"));
        Thread.sleep(2000); // button seems not to get pressed unless we wait before
        nextButton.click();
    }

    @Test ()
    public void enterStep3Signup() throws InterruptedException {
        Thread.sleep(2000); // wait for page to laod
        WebElement checkbox = chromeDriver.findElement(By.cssSelector(".Indicator-sc-1airx73-0.lhZnAn"));
        checkbox.click();
        WebElement signUpButton = chromeDriver.findElement(By.cssSelector(".ButtonInner-sc-14ud5tc-0.hvvTXU.encore-bright-accent-set"));
        Thread.sleep(2000); // button seems not to get pressed unless we wait before
        signUpButton.click();
    }
}
