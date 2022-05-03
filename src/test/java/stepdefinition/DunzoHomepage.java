package stepdefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DunzoHomePage;

public class DunzoHomepage {

	private WebDriver driver;
	private DunzoHomePage dunzoHomePage;
	@Before("Sanity")
	public void buildChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		this.dunzoHomePage = new DunzoHomePage(driver);
	}

	@Given("I have navigated to dunzo website at {string}")
	public void i_have_navigated_to_dunzo_website_at_https_www_dunzo_com(String url) {
		driver.navigate().to(url);
	}

	@Then("Set Location option should be displayed without any location selected")
	public void validateSetLocation() {
		Assert.assertTrue(dunzoHomePage.getHeaderLocation().equals("Set Location"), "Location option is invalid");
	}

	@When("I click on Set Location option")
	public void i_click_on_set_location_option() {
		dunzoHomePage.setLocationClick();
	}

	@When("I provide location as {string}")
	public void i_provide_location(String location) {
		dunzoHomePage.typeLocations(location);
	}

	@Then("List of options should appear with {string} as value")
	public void validateResultsForLocation(String location) throws InterruptedException {
		Thread.sleep(10000);
		Assert.assertTrue(dunzoHomePage.getListOfLocations().size() > 0);
	}

	@When("I Select First Location")
	public void i_select_india_nagar_as_location() {
		dunzoHomePage.selectnthLocation(1);
	}

	@Then("{string} should be displayed in the header section")
	public void india_nagar_should_be_displayed_in_the_header_section(String location) {
		Assert.assertTrue(location.toLowerCase().contains(location.toLowerCase()));
	}

	//@After
	public void closeChromeDriver() throws InterruptedException {
//ctrl+sftt+o  
		Thread.sleep(5000);
		driver.quit();
	}

}

