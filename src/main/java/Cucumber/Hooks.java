package Cucumber;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    public static WebDriver driver ;

    @BeforeAll
    public void beforeAll(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/Browser/chromedriver.exe");
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.get("https://adactinhotelapp.com/index.php");
    }


    @AfterAll
    public void afterAll(){

        driver.quit();

    }
}
