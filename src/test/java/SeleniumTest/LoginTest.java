package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class LoginTest {
    public static void main(String[] args) {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        option.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        //create new user
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //Enter Value
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Tushar");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("8igciwwe@punkproof.com");


        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        WebElement element = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String success_message = element.getText();
        System.out.println(success_message);

        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.id("password")).sendKeys("Tushar123");
        WebElement days = driver.findElement(By.id("days"));

        //Select Date of Birth
        Select sel = new Select(days);
        sel.selectByVisibleText("18");

        Select sel_month = new Select(driver.findElement(By.id("months")));
        sel_month.selectByVisibleText("January");

        Select sel_year = new Select(driver.findElement(By.id("years")));
        sel_year.selectByVisibleText("1991");

      //lect The checkboxes

        WebElement checkboxes = driver.findElement(By.id("newsletter"));
        if (!checkboxes.isSelected()) {
            checkboxes.click();
        }

        WebElement Address_Message = driver.findElement(By.xpath("//b[text()='Address Information']"));
        String new_message = Address_Message.getText();
        System.out.println(new_message);

        //Enter Address details
        driver.findElement(By.id("first_name")).sendKeys("Tushar");
        driver.findElement(By.id("last_name")).sendKeys("Chaudhary");
        driver.findElement(By.id("company")).sendKeys("TCS");
        driver.findElement(By.id("address2")).sendKeys("78 sector 10");
        driver.findElement(By.id("address1")).sendKeys("Itanagr");
        WebElement select_country = driver.findElement(By.id("country"));
        Select select = new Select(select_country);
        select.selectByVisibleText("India");

        driver.findElement(By.id("state")).sendKeys("Arunanchal Pradesh");
        driver.findElement(By.id("city")).sendKeys("Itanagr");
        driver.findElement(By.id("zipcode")).sendKeys("100001");
        driver.findElement(By.id("mobile_number")).sendKeys("1234567890");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");



        driver.findElement(By.xpath("//button[text()='Create Account']")).click();
        WebElement Success_Message = driver.findElement(By.xpath("//b"));
        String success = Success_Message.getText();
        System.out.println(success);

        driver.quit();









}}