package TestNG;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class TestCalss {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.F5);
        action.click().build().perform();


    }
}
