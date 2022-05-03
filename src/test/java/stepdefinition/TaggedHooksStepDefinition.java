package stepdefinition;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaggedHooksStepDefinition {
	/*
	@BeforeTest(order=0)
	public void setUP(){
		System.out.println("launch FF");
		System.out.println("Enter URL for Free CRM APP");
	}

	@AfterTest(order=0)
	public void tearDown(){
		System.out.println("close the browser");
	}
	
	@BeforeTest(order=1)
	public void setUP1(){
		System.out.println("launch FF");
		System.out.println("Enter URL for Free CRM APP");
	}

	@AfterTest(order=1)
	public void tearDown1(){
		System.out.println("close the browser");
	}
	
	@BeforeTest("@First")
	public void beforeFirst(){
		System.out.println("before only first scenario");
	}
	
	@AfterTest("@First")
	public void afterFirst(){
		System.out.println("after only first sceanrio");
	}
	
	@BeforeTest("@Second")
	public void beforeSecond(){
		System.out.println("before only second scenario");
	}
	
	@AfterTest("@Second")
	public void afterSecond(){
		System.out.println("after only second sceanrio");
	}
	
	@Before("@Third")
	public void beforeThird(){
		System.out.println("before only third scenario");
	}
	
	@After("@Third")
	public void afterThird(){
		System.out.println("after only third sceanrio");
	}*/
	
	
	@Given("^this is the first step$")
	public void this_is_the_first_step() throws Throwable {
		System.out.println("1st step");
	}

	@When("^this is the second step$")
	public void this_is_the_second_step() throws Throwable {
		System.out.println("2nd step");
	}

	@Then("^this is the third step$")
	public void this_is_the_third_step() throws Throwable {
		System.out.println("3rd step");
	}
	
	
	

}
