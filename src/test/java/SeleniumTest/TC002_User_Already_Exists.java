package SeleniumTest;

import BaseTest.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class TC002_User_Already_Exists extends BaseClass {

    public static void main(String[] args) throws IOException {
        setup();
        try {
            driver.findElement(By.xpath("//a[@href='/login']")).click();
        } catch (Exception e) {
            System.out.println("It is taking more than expected time to load");
        }
        String webpageTitle = driver.getTitle();
        System.out.println(webpageTitle);
        //Enter Value
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Tushar");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("8igciwwe@punkproof.com");

        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        WebElement Alert_message = driver.findElement(By.xpath("//p[starts-with(text(),'Email')]"));
        String Alert = Alert_message.getText();
        if (Alert.equalsIgnoreCase("Email Address already exist!")) {
            System.out.print("Validation completed");
        }
        driver.quit();
    }


}
