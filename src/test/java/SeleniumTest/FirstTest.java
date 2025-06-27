package SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class FirstTest {

    public static void main(String[] args){
        ChromeOptions option = new ChromeOptions();
        //option.addArguments("--headless");
        option.setAcceptInsecureCerts(true);
        String browser = option.getBrowserName();
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();

        System.out.println(browser);
        driver.get("https://expired.badssl.com/");
        driver.quit();

    }
}
