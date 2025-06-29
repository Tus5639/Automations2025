package SeleniumTest;

import BaseTest.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TC002_User_Already_Exists extends BaseClass {

        public static void main(String[] args) throws IOException {
           setup();
            try {
                driver.findElement(By.xpath("//a[@href='/login']")).click();
            } catch (Exception e) {
                System.out.println("It is taking more than expected time to load");
            }
            //create new user   D
           // driver.manage().window().maximize();

            //Enter Value
            driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Tushar");
            driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("8igciww9092@punkproof.com");

//




        }


}
