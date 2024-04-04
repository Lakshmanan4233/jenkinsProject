package Reuse;

import Pages.SetBrowser;
import Threadlocal.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.time.Duration;

import static Threadlocal.DriverManager.getDriver;
import static Threadlocal.DriverManager.removeDriver;

public class Reusable extends SetBrowser {

    public static WebDriver driver;
    public  ExtentReports extentReport ;

    public ExtentTest extentTest;


    @BeforeSuite
    public void beforeSuite(ITestContext context){

        ExtentReportManager.setExtent(new ExtentReports());

        extentReport = ExtentReportManager.getExtent();

        ExtentSparkReporter spark_All_Case = new ExtentSparkReporter("./All_Report/OverallReport.html");
        ExtentSparkReporter spark_Failed_Case = new ExtentSparkReporter("./Failed Cases/FailedReport.html");
        spark_Failed_Case.filter().statusFilter().as(new Status[] {Status.FAIL});
        extentReport.attachReporter(spark_All_Case,spark_Failed_Case);

        extentReport.setSystemInfo("OS",System.getProperty("os.name"));
        extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
        extentReport.setSystemInfo("User Name",System.getProperty("user.name"));


    }


    @AfterSuite
    public void afterSuite(ITestContext context) throws IOException {

        extentReport.flush();
        ExtentReportManager.removeExtent();
        sendEmail("Automation Report","Checking Body",System.getProperty("user.dir")+"\\All_Report\\OverallReport.html");
        //Desktop.getDesktop().browse(new File("All_Report/AllCaseReport.html").toURI());
       // Desktop.getDesktop().browse(new File("Failed Cases/FailedCaseReport.html").toURI());

    }

    @AfterMethod
    public void afterMethod(Method method , ITestResult result) throws IOException {

        if(result.getStatus() == ITestResult.FAILURE) {
            extentTest.addScreenCaptureFromPath(captureScreenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg"));
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.pass(method.getName() + "  is Passed");
        }

    }


    public String captureScreenshot(String filename) throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        File dest = new File("./Screenshot/"+filename);
        FileUtils.copyFile(sourceFile,dest);
        return dest.getAbsolutePath();

    }

    @BeforeTest
    @Parameters({"browser"})
    public void SetallDatas(ITestContext context , String browser) throws MalformedURLException {

        setBrowser(browser);
        driver = getDriver();
        extentTest = extentReport.createTest(context.getName());

    }

    @AfterTest
    public void cleardriver(){

        removeDriver();
        System.out.println(getDriver());
    }


    @BeforeClass
    @Parameters("url")
    public void beforeClass(String url){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass(){
       driver.quit();
    }


    public static String getTitle(){
        return driver.getTitle();
    }

    public static void Sendkeys(By locators , String keysend){
        driver.findElement(locators).sendKeys(keysend);
    }
}
