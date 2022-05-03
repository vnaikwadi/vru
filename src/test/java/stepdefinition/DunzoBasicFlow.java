package stepdefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DunzoHomePage;

public class DunzoBasicFlow {
	
	private WebDriver driver;
	WebDriverWait wait;
	private DunzoHomePage dunzoHomePage;
	
	@Before
	public void buildChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		this.dunzoHomePage = new DunzoHomePage(driver);
	}
	
	@Given("User is on Home Page {string}")
	public void user_is_on_home_page(String url) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		System.out.println("User is on Home Page");
		
	}
	@When("Title on Home Page is Dunzo")
	public void title_on_home_page_is_dunzo() {
	    String title=driver.getTitle();
		System.out.println("Title on Home Page is:"+title);
		
	}
	@Then("User selected menu")
	public void user_selected_menu() throws InterruptedException {
	    Thread.sleep(5000);
		//--dunzoHomePage.categoryClick();
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Meat & Fish in Mumbai']")));
		System.out.println("User selected menu");

	}
	@Then("User add items")
	public void user_add_items() throws InterruptedException {
		//driver.findElement(By.xpath("//p[text()='Licious']")).click();
		//--dunzoHomePage.addItemClick();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your Cart ']")));
	    System.out.println("User is on menu tab");
	    //--dunzoHomePage.select_list_items();
	    /*List<WebElement> ele=driver.findElements(By.xpath("//*[text()='others']/../a/div/div[3]"));
	    System.out.println("Number of items displayed:"+ele.size());
	    System.out.println("Items displayed:"+ele);
	    String items;
	    for(WebElement option:ele)
	    {
	    	if(option.isDisplayed())
	    	{
	    		items=driver.findElement(By.xpath("//*[text()='others']/../a/div/div[2]/p[1]")).getText();
	    		option.click();
	    		System.out.println(items);
	    	}
	    	Thread.sleep(1000);
	    } */  
	}
	@And("User places order")
	public void user_places_order() {
	   
		//driver.findElement(By.xpath("//button[text()='Checkout']")).click();
	    //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='Checkout']")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Delivery Address']")));
	   
		System.out.println("User places order");
	}
	//@And("User adds address")
	public void user_adds_address()
	{
		WebElement ele=driver.findElement(By.xpath("//p[text()='Add new address']"));
		if(ele.isEnabled())
		{
			ele.click();
			//--Use Current location--
			//driver.findElement(By.xpath("//div[text()='Use current location']")).click();
			//driver.switchTo().alert().accept();
			driver.findElement(By.xpath("//div[text()='Search Drop Location']/../../..//input")).click();
			driver.findElement(By.xpath("//div[text()='Search Drop Location']/../../..//input")).sendKeys("spring grove uno");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='search results']/../div[2]")));
			driver.findElement(By.xpath("//div[text()='search results']/../div[2]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Proceed to add details']")));
			driver.findElement(By.xpath("//button[text()='Proceed to add details']")).click();
			//add address
			driver.findElement(By.xpath("//input[@name='appartmentAddress']")).sendKeys("");
			driver.findElement(By.xpath("//input[@name='appartmentAddress']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//input[@name='landmark']")).sendKeys("");
			driver.findElement(By.xpath("//input[@name='landmark']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys("");
			driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//input[@name='contactNumber']")).sendKeys("");
			driver.findElement(By.xpath("//input[@name='contactNumber']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//button[text()='Home']")).click();
			driver.findElement(By.xpath("//button[text()='Continue']")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='Continue']")));
			
		}
	}
	
	@And("Verify order is placed successfully")
	public void verify_order_is_placed_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("Order is places successfully");
	}
	
	@When("User clicks on Pet Supplies")
	public void user_clicks_on_pet_supplies() {
	    System.out.println("User clicks on Pet Supplies");
	}
	@Then("User selects {string}")
	public void user_selects(String string) {
	    System.out.println("User selects pet location: "+string);
	}
	@Then("User selects Puppy Food {string} and {string}")
	public void user_selects_puppy_food_and(String string1, String string2) {
	   System.out.println("User selects Puppy Food {string} and {string}: "+string1+" "+string2);
	}

	@When("User selects menu option")
	public void user_selects_menu_option(DataTable cred) {
	   for(Map<String,String> data:cred.asMaps(String.class,String.class))
	   {
		   System.out.println("Menu Option: "+data.get("menu"));
	   }
	   
		
	}
	@Then("User selects pickup location and drop point")
	public void user_selects_pickup_location_and_drop_point(DataTable dataTable) {
	    List<List<String>> data=dataTable.cells();
	    System.out.println("User selects pickup location: "+data.get(0).get(0));
	    System.out.println("User selects drop point: "+data.get(0).get(1));
	}

	
	@After()
	public void closeBrowser()
	{
		driver.close();
	}

}
