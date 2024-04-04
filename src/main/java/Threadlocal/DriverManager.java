package Threadlocal;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){

        threadDriver.set(driver);

    }

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public static void removeDriver(){
        threadDriver.remove();
    }

}
