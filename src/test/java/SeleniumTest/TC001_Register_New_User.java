package SeleniumTest;

import BaseTest.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TC001_Register_New_User extends BaseClass {
    public static void main(String[] args) throws IOException {
        setup();
        try {
            driver.findElement(By.xpath("//a[@href='/login']")).click();
        } catch (Exception e) {
            System.out.println("It is taking more than expected time to load");
        }
        //create new user   D
        driver.manage().window().maximize();
        // driver.findElement(By.xpath("//a[@href='/login']")).click();
        //Enter Value
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Tushar");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("8ilciww9@punkproof.com");


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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("arguments[0].click();", checkboxes);

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


        WebElement createAccount = driver.findElement(By.xpath("//button[text()='Create Account']"));
        js.executeScript("arguments[0].click();", createAccount);
        WebElement Success_Message = driver.findElement(By.xpath("//b"));
        String success = Success_Message.getText();
        System.out.println(success);

        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\JavaTest\\Browser.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String action = prop.getProperty("Action_item");

        WebElement delete = driver.findElement(By.cssSelector("[href='/delete_account']"));
        WebElement logout = driver.findElement(By.cssSelector("[href='/logout']"));
        if (action.equalsIgnoreCase("delete")) {
            delete.click();
            String output_message = driver.findElement(By.xpath("//b")).getText();
            System.out.println(output_message);
        }

        if (action.equalsIgnoreCase("logout")) {
            logout.click();
            String output_message = driver.findElement(By.cssSelector(".login-form")).getText();
            System.out.println(output_message);
        }

        driver.quit();
    }
}