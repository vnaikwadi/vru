package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "C:\\Vrushali\\NewAutomation\\vrushali\\src\\test\\java\\features\\DunzoBasicFlow.feature",
				glue = "stepdefinition",
				//format= {"pretty","html:test-output", "json:json_output/cucumber.json"}, //to generate different types of reporting
				monochrome = true, //display the console output in a proper readable format
				//strict = true, //it will check if any step is not defined in step definition file
				dryRun = false, //to check the mapping is proper between feature file and step def file
				//tags = ("@UAT"),//,@RegressionTest"),//imp // , "@RegressionTest"}//, "~@End2End"}			
				//plugin = "json:target/cucumber-reports/CucumberTestReport.json" --working correct
				plugin= {"pretty" ,"json:target/cucumber-reports/CucumberTestReport.json"}//"html:target/cucumber-reports"
		)

public class TestRunner extends AbstractTestNGCucumberTests {

	
}
