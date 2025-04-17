import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.Keys;




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

    @org.testng.annotations.Test(priority = 1)
    public void Signup() throws InterruptedException {
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
        WebElement signOut = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#_desktop_user_info > div > a.logout.hidden-sm-down")));
        signOut.click();
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = {"Signup"})
    public void login() throws InterruptedException {
        Thread.sleep(1000);
        WebElement login = chromeDriver.findElement(By.cssSelector("#_desktop_user_info > div > a > span"));
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
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = {"login"})
    public void contactUs() throws InterruptedException {
        String filePath = "C:\\Users\\anton\\testing-cars.com\\resources\\Screenshot 2025-04-16 231754.png";
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(20));
        chromeDriver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#contact-link > a"))).click();
        Thread.sleep(1000);

        WebElement chooseFile = chromeDriver.findElement(By.cssSelector("input[type='file']")); // changed to direct file input
        chooseFile.sendKeys(filePath);
        Thread.sleep(1000);

        WebElement comment = chromeDriver.findElement(By.id("contactform-message"));
        comment.sendKeys("I'm a cool cat");
        WebElement send = chromeDriver.findElement(By.cssSelector("#content > section > form > footer > input.btn.btn-primary"));
        send.click();
        Thread.sleep(1000);
        chromeDriver.switchTo().defaultContent();
    }

    @Test(dependsOnMethods = {"contactUs"})
    public void navigateToMensClothes() throws InterruptedException {
        chromeDriver.get("https://demo.prestashop.com/#/en/front");
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));
        Thread.sleep(1000);
        WebElement parentMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#category-3 > a")));
        parentMenu.click();
        WebElement menButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#left-column > div.block-categories > ul > li:nth-child(2) > ul > li:nth-child(1) > a")));
        menButton.click();
    }

    @Test(dependsOnMethods = {"navigateToMensClothes"})
    public void filterMensClothes() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        WebElement medium = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("custom-checkbox")));
        medium.click();
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = ("filterMensClothes"))
    public void sortByClothing() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        Thread.sleep(1000);
        WebElement sortBy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#js-product-list-top > div.col-lg-7 > div > div.col-xs-8.col-sm-7.col-md-9.products-sort-order.dropdown > button")));
        sortBy.click();
        js.executeScript("window.scrollBy(0,250)");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,200)");
        WebElement lowToHighDDB = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-product-list-top > div.col-lg-7 > div > div.col-xs-8.col-sm-7.col-md-9.products-sort-order.dropdown.open > div > a:nth-child(5)")));
        lowToHighDDB.click();
        Thread.sleep(1000);

        js.executeScript("window.scrollBy(0,250)");
        WebElement sortByButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-product-list-top > div.col-lg-7 > div > div.col-xs-8.col-sm-7.col-md-9.products-sort-order.dropdown > button")));
        sortByButton2.click();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,250)");
        WebElement nameDD = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-product-list-top > div.col-lg-7 > div > div.col-xs-8.col-sm-7.col-md-9.products-sort-order.dropdown.open > div > a:nth-child(2)")));
        nameDD.click();
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = ("sortByClothing"))
    public void filteredProduct() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-product-list > div.products.row > div > article > div > div.thumbnail-top > a > picture > img")));
        product.click();
        Thread.sleep(1000);
        WebElement quant = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#add-to-cart-or-refresh > div.product-add-to-cart.js-product-add-to-cart > div > div.qty > div > span.input-group-btn-vertical > button.btn.btn-touchspin.js-touchspin.bootstrap-touchspin-up > i")));
        quant.click();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,250)");
    }

    @Test(dependsOnMethods = ("filteredProduct"))
    public void Wishlist() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));

        chromeDriver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("framelive")));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[3]/a"))).click();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
        // Add item 1
        chromeDriver.findElement(By.xpath("/html/body/main/section/div/div/div[2]/section/section/div[3]/div[1]/div[1]/article/div/button")).click();
        Thread.sleep(1000);
        chromeDriver.findElement(By.xpath("/html/body/main/footer/div[2]/div/div[1]/div[4]/div[1]/div/div/div[2]/div/ul/li")).click();
        Thread.sleep(1000);
        // Add item 2
        chromeDriver.findElement(By.xpath("/html/body/main/section/div/div/div[2]/section/section/div[3]/div[1]/div[3]/article/div/button/i")).click();
        Thread.sleep(1000);
        chromeDriver.findElement(By.xpath("/html/body/main/footer/div[2]/div/div[1]/div[4]/div[1]/div/div/div[2]/div/ul/li")).click();
        Thread.sleep(1000);
        // Add item 3
        chromeDriver.findElement(By.xpath("/html/body/main/section/div/div/div[2]/section/section/div[3]/div[1]/div[5]/article/div/button/i")).click();
        Thread.sleep(1000);
        chromeDriver.findElement(By.xpath("/html/body/main/footer/div[2]/div/div[1]/div[4]/div[1]/div/div/div[2]/div/ul/li")).click();
        Thread.sleep(1000);

        // Navigate to Wishlist
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/footer/div[2]/div/div[1]/div[2]/ul/li[5]/a"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section/div/div/div/section/div[1]/section/div/ul/li/a/p"))).click();
        Thread.sleep(2000);

        // Delete an item
        chromeDriver.findElement(By.xpath("/html/body/main/section/div/div/div/section/div[1]/section/ul/li[1]/div/div/button[2]/i")).click();
        Thread.sleep(1000);
        chromeDriver.findElement(By.xpath("/html/body/main/footer/div[2]/div/div[1]/div[5]/div[1]/div/div/div[3]/button[2]")).click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section/div/div/div/section/div[2]/a[2]"))).click();
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods = ("Wishlist"))
    public void shoppingCart() throws InterruptedException {
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

