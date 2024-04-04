package Cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepDefn {

    WebDriver driver = Hooks.driver;

    @Given("Given one")
    public void given_one() {

        driver.findElement(By.id("username")).sendKeys("Lsanthanam");

    }
    @Then("Then one")
    public void then_one() {

        System.out.println("Sceanrio one finished");

    }


    @Given("Given Two")
    public void given_two() {

        driver.findElement(By.id("password")).sendKeys("Password");


    }
    @Then("Then Two")
    public void then_two() {

        System.out.println("Scenario two finished");

    }
}
