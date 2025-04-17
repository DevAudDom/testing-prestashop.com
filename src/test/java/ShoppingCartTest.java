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
import java.util.WeakHashMap;

import org.openqa.selenium.Keys;

public class ShoppingCartTest {
    WebDriver chromeDriver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\danie\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.setCapability("unhandledPromptBehavior", "accept"); // Accept all alerts automatically (cookies or some popup)
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize(); // Maximize the window
    }

    @org.testng.annotations.Test
    public void shoppingcart() throws InterruptedException {
        chromeDriver.get("https://demo.prestashop.com/#/en/front");
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));
        Thread.sleep(12000);
        js.executeScript("window.scrollBy(0,800)");
        Thread.sleep(1000);
        WebElement mug1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#content > section:nth-child(2) > div > div:nth-child(8) > article > div > div.thumbnail-top")));
        mug1.click();
        Thread.sleep(1000);
        WebElement addQuantity = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#add-to-cart-or-refresh > div.product-add-to-cart.js-product-add-to-cart > div > div.qty > div > span.input-group-btn-vertical > button.btn.btn-touchspin.js-touchspin.bootstrap-touchspin-up")));
        addQuantity.click();
        Thread.sleep(2000);
        WebElement addCart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#add-to-cart-or-refresh > div.product-add-to-cart.js-product-add-to-cart > div > div.add")));
        addCart.click();
        Thread.sleep(1000);
        WebElement goCart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a")));
        goCart.click();
        Thread.sleep(1000);
        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main > div > div.cart-grid-right.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.js-cart-detailed-actions.card-block > div")));
        checkout.click();
        Thread.sleep(1000);
        //Checkout testing
        WebElement mister = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#customer-form > div > div:nth-child(1) > div.col-md-6.js-input-column.form-control-valign > label:nth-child(1) > span")));
        mister.click();
        Thread.sleep(1000);
        WebElement checkoutFirstName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#field-firstname")));
        checkoutFirstName.click();
        Thread.sleep(1000);
        checkoutFirstName.sendKeys("Daniel");
        Thread.sleep(1000);
        checkoutFirstName.sendKeys(Keys.ENTER);
        WebElement checkoutLastName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#field-lastname")));
        checkoutLastName.click();
        checkoutLastName.sendKeys("K");
        Thread.sleep(1000);
        checkoutLastName.sendKeys(Keys.ENTER);
        WebElement emailCheckout = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#field-email")));
        emailCheckout.click();
        emailCheckout.sendKeys("danielk@gmail.com");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        WebElement TermsConditions = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#customer-form > div > div:nth-child(9) > div.col-md-6.js-input-column > span")));
        TermsConditions.click();
        Thread.sleep(1000);
        WebElement privacy = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#customer-form > div > div:nth-child(11) > div.col-md-6.js-input-column > span")));
        privacy.click();
        Thread.sleep(1000);
        WebElement continue1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#customer-form > footer > button")));
        continue1.click();
        Thread.sleep(1000);
        WebElement address = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#field-address1")));
        address.click();
        Thread.sleep(1000);
        address.sendKeys("1234 ABC Lane");
        Thread.sleep(1000);
        WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#field-city")));
        city.click();
        Thread.sleep(1000);
        city.sendKeys("Fort Myers");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
        WebElement state = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#field-id_state")));
        state.click();
        Thread.sleep(1000);
        WebElement fl = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#field-id_state > option:nth-child(14)")));
        fl.click();
        Thread.sleep(1000);
        WebElement zip = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#field-postcode")));
        zip.click();
        Thread.sleep(1000);
        zip.sendKeys("10101");
        Thread.sleep(1000);
        WebElement continue2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#delivery-address > div > footer > button")));
        continue2.click();
        Thread.sleep(1000);
        WebElement continue3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-delivery > button")));
        continue3.click();
        Thread.sleep(2000);
        WebElement termsofService = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#conditions-to-approve")));
        termsofService.click();
        Thread.sleep(1000);

    }
}
