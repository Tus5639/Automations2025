package SeleniumTest;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

public class WebTable {

    public static void main(String[] args) throws IOException {
        WebDriver driver = null;
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\JavaTest\\Browser.properties");
        prop.load(fis);
        String browsernmae = prop.getProperty("browser");
        String url = prop.getProperty("url");
        if (browsernmae.equals("chrome")) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--headless");
            driver = new ChromeDriver(option);
        }

        if(browsernmae.equals("edge")){
            EdgeOptions option = new EdgeOptions();
          //  option.addArguments("--headless");
            option.setAcceptInsecureCerts(true);
            driver = new EdgeDriver(option);
        }

        driver.get(url);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // driver.navigate().to("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.33.0");
        //  WebElement el =  driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
        //wait.until(ExpectedConditions.elementToBeClickable(el));
        //el.click();
        String parent_Window = driver.getWindowHandle();
        System.out.println(parent_Window);
        TakesScreenshot scs = (TakesScreenshot) driver;

        File srcFile = scs.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"\\screenshhots";
        File DestFile = new File(path);
       // FileUtils.copyFile(srcFile, DestFile);

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(parent_Window)) {
                driver.switchTo().window(parent_Window);
                break;
            }
        }
    }

}
