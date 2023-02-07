package cucumber;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(plugin= {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},features = "src/test/java/resources", glue = "src/test/java/cucumber")
public class CucumberRunnerTest extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		// TODO Auto-generated method stub
		return super.scenarios();
	}
}
