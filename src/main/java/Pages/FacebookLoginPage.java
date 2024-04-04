package Pages;

import Reuse.Reusable;
import org.openqa.selenium.By;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

public class FacebookLoginPage extends Reusable {

    public void faceBookTest(){
        extentTest.info("Facebook Test method");
        System.out.println(getTitle());
        Sendkeys(By.id("email"),"FacebookUserName");
        Sendkeys(By.id("pass"),"FacebookPassword");
        System.out.println(Thread.currentThread().getId());
        extentTest.warning(String.valueOf(Thread.currentThread().getId()));
    }
}
