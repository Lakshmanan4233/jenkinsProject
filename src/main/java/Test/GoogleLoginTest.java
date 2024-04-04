package Test;

import Pages.GoogleLoginPage;
import Reuse.Reusable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static Threadlocal.DriverManager.*;

public class GoogleLoginTest extends GoogleLoginPage {


//    public void setBrowser(String browser){
//
//        if(browser.equalsIgnoreCase("Chrome"))
//            setDriver(setChrome());
//        else if (browser.equalsIgnoreCase("Edge"))
//            setDriver(setEdge());
//        else
//            System.out.println("Unsupported command or driver not specified!!");
//
//    }
//
//
//    public ChromeDriver setChrome(){
//        System.setProperty("webdriver.chrome.driver","./src/main/resources/Browser/chromedriver.exe");
//        return new ChromeDriver();
//    }
//
//    public EdgeDriver setEdge(){
//        System.setProperty("webdriver.edge.driver","./src/main/resources/Browser/msedgedriver.exe");
//        return new EdgeDriver();
//    }
//
//    protected Reusable resu ;
//
//    @BeforeTest
//    @Parameters({"browser","url"})
//    public void SetallDatas(String browser,String url){
//
//        setBrowser(browser);
//        getDriver().get(url);
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        Reusable.driver = getDriver();
//
//    }
//
//    @AfterTest
//    public void cleardriver(){
//
//        removeDriver();
//        System.out.println(getDriver());
//    }


    @Parameters("keysend")
    @Test
    public void sceanrio1(String keysend){

        scenarioTest(keysend);

    }
}
