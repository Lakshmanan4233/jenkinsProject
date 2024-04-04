package Pages;

import Reuse.Reusable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static Reuse.Reusable.getTitle;

public class GoogleLoginPage extends Reusable{


    public void get(){

        getTitle();
    }

    public void scenarioTest(String keysend){
        extentTest.info("Sceanrio Test method");
        System.out.println(getTitle());
        Sendkeys(By.id("APjFqb"),keysend);
        System.out.println(Thread.currentThread().getId());
        extentTest.info(String.valueOf(Thread.currentThread().getId()));
        Assert.assertFalse(true);
    }

}
