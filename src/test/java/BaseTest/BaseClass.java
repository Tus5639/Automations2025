package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver ;
    public static void setup() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\JavaTest\\Browser.properties");
        Properties prop  =new Properties();
        prop.load(fis);
        String browser = prop.getProperty("browser");
        String url = prop.getProperty("UAT_Test");
        if (browser.equalsIgnoreCase("chrome")){
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--headless");
            option.setAcceptInsecureCerts(true);
            driver = new ChromeDriver(option);
        }

        if(browser.equalsIgnoreCase("edge")){
            EdgeOptions option = new EdgeOptions();
            option.addArguments("--headless");
            option.setAcceptInsecureCerts(true);
            driver = new EdgeDriver(option);
        }
        driver.get(url);
        driver.manage().window().maximize();


    }
}
