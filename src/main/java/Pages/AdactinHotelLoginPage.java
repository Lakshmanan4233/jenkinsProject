package Pages;

import Reuse.Reusable;
import org.openqa.selenium.By;

public class AdactinHotelLoginPage extends Reusable {

    public void adactin(){
        extentTest.info("Adactin Test method");
        System.out.println(getTitle());
        Sendkeys(By.id("username"),"Lsanthanam");
        System.out.println(Thread.currentThread().getId());
        extentTest.warning(String.valueOf(Thread.currentThread().getId()));
    }
}
