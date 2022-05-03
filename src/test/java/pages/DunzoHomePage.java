package pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DunzoHomePage {

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Set Location')]")
	WebElement setLocation;

	@FindBy(how=How.XPATH,using="//p[text()='Meat and Fish']")
	WebElement category;

	@FindBy(how=How.XPATH,using="//h1[text()='Meat & Fish in Mumbai']/following::p[2]")
	WebElement add_item;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Search for area, location name')]")
	WebElement enterLocation;

	//@FindBy(how = How.XPATH, using = "//div[contains(text(),'search results')]/parent::div/descendant::p[contains(text(),'Indira Nagar')]")
	//WebElement listOfLocations;

	@FindAll({	
				@FindBy(how=How.XPATH,using="//div[@id='__next']//button[1]/../../div[3]//button")
			})////*[text()='others']/../a/div/div[3]
	List<WebElement> available_items;
	
	@FindAll({	
		@FindBy(how=How.XPATH,using="//div[contains(text(),'search results')]/parent::div/descendant::p[contains(text(),'Indira Nagar')]")
	})
	List<WebElement> listOfLocations;

	@FindBy(how=How.XPATH,using="//*[text()='others']/../a/div/div[2]/p[1]")
	WebElement list_items;
	
	@FindBy(how=How.XPATH,using="//*[text()='others']/../a/div/div[2]/p[1]")
	WebElement items;
	
	WebDriver driver;
	

	public DunzoHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getHeaderLocation() {
		return setLocation.getText();
	}
	
	public void addItemClick()
	{
		click_element(add_item);
	}
	
	public void categoryClick()
	{
		click_element(category);
	}
	
	public void setLocationClick() {
		click_element(setLocation);
	}

	public void typeLocations(String location) {
		send_keys(enterLocation,location);
		//new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(enterLocation)).sendKeys(location);;	
	}
	
	public List<String> getListOfLocations() {
		return get_List(listOfLocations);
	}
	
//	public List<String> listOfMenu()
//	{
//		return get_List(available_items);
//	}
	
	//click method
	public void click_element(WebElement click_element)
	{
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(click_element))
		.click();
	}	
	
	//sendkeys method
	public void send_keys(WebElement sendkeys_element,String location) {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(sendkeys_element)).sendKeys(location);;
	}
	
	//list of Elements
	public List<String> get_List(List<WebElement> ele) {
		return new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfAllElements(ele)).stream().map(e -> e.getText())
				.collect(Collectors.toList());
		
	}

	//select value from List
	public void selectListValue(List<WebElement> ele,WebElement item)
	{
		List<String> x=get_List(ele);
		System.out.println("size of list: "+ele.size());
		for(WebElement option:ele)
	    //for(int i=0;i<get_List(ele).size();i++)
		{
	    	if(option.isDisplayed())
	    	{
	    		item.getText();
	    		option.click();
	    		System.out.println(item.getText());
	    	}   	
	    }
	}
	
	public void select_list_items()
	{
		selectListValue(available_items, items);
	}
	
	public void selectnthLocation(int n) {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElements(listOfLocations)).get(n-1).click();
	}
}
