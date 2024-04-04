package Threadlocal;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;

public class ExtentReportManager {


    public static ThreadLocal<ExtentReports> threadDriver = new ThreadLocal<>();

    public static void setExtent(ExtentReports extent){

        threadDriver.set(extent);

    }

    public static ExtentReports getExtent(){
        return threadDriver.get();
    }

    public static void removeExtent(){
        threadDriver.remove();
    }
}
