package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature" , glue="StepDefinition", monochrome=true )
public class TestNgRunner extends AbstractTestNGCucumberTests {

	

	}


