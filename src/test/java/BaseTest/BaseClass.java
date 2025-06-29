package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;

    @BeforeClass
    public static void setup() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\JavaTest\\Browser.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String browser = prop.getProperty("browser");
        String url = prop.getProperty("UAT_Test");
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--headless");
            option.setAcceptInsecureCerts(true);
            driver = new ChromeDriver(option);
        }

        if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions option = new EdgeOptions();
            option.addArguments("--headless");
            option.setAcceptInsecureCerts(true);
            driver = new EdgeDriver(option);
        }
        driver.get(url);
        driver.manage().window().maximize();


    }

    @AfterClass
    public void TearDown() {
        driver.quit();
    }

    public void waitforVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
