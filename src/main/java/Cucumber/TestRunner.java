package Cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/main/java/Cucumber/Login.feature"}
,glue = "src/main/java/Cucumber" , dryRun = !true)
public class TestRunner{


}
