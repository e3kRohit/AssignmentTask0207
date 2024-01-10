package StepDefinition;

import java.time.Duration;

import org.checkerframework.checker.calledmethods.qual.EnsuresCalledMethods.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.Assertion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainSteps {
	public WebDriver driver;

	
	@Given("user is on home page")
	public void user_is_on_home_page() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\divya\\Documents\\chrome-win64");	
		driver.get("https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo");
		throw new io.cucumber.java.PendingException();
	}
	@Given("user enters credentials for state, zipcode, and purpose")
	public void user_enters_credentials_for_state_zipcode_and_purpose() {
		Actions actions = new Actions(null);
		actions.perform();
        Select selectState = (Select) driver.findElement(By.xpath("//select)[1]"));
        selectState.selectByVisibleText("Victoria");
        WebElement postalCode = driver.findElement(By.xpath("//input[@aria-labelledby='postal-code-hint']"));
        postalCode.sendKeys("3000");
        WebElement privateRadioButton = driver.findElement(By.xpath("//div[@class='wb-radio-control__indicator'])[1]"));
        privateRadioButton.click();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
	    throw new io.cucumber.java.PendingException();
	}
	@Given("user clicks on filter button top left blue button")
	public void user_clicks_on_filter_button_top_left_blue_button() {
		    
		    WebElement filterButton = driver.findElement(By.xpath("//*[@id=\\\"app\\\"]/div[1]/main/div[2]/div[1]/div[2]/div[1]/span"));
		    filterButton.click();    
	        throw new io.cucumber.java.PendingException();
	}
	@Given("user selects vehicle color")
	public void user_selects_vehicle_color() {
		WebElement preOwnedButton = driver.findElement(By.xpath("//span[.=' Pre-Owned']"));
        preOwnedButton.click();
        Actions actions = new Actions(driver);
		actions.perform();
		
		WebElement preOwnedColorOption = driver.findElement(By.xpath("//div[@class='category-filter-row-headline'])[7]"));
        preOwnedColorOption.click();
        
        WebElement colorDropdown = driver.findElement(By.xpath("//a[@class='dcp-multi-select-dropdown__frame dcp-multi-select-dropdown-frame'])[2]"));
        colorDropdown.click();
        
        WebElement preOwnedColorSelection = driver.findElement(By.xpath("//li[@class='dcp-multi-select-dropdown-card__pill-wrapper dcp-multi-select-dropdown-card-pill-wrapper']")); 
        preOwnedColorSelection.click();	   	
	    throw new io.cucumber.java.PendingException();
	}
	@Given("user selects the most expensive car")
	public void user_selects_the_most_expensive_car() {
		java.util.List<WebElement> carList = driver.findElements(By.xpath("//div[@class='wb-button-text']"));
		java.util.List<WebElement> priceList = driver.findElements(By.xpath("div[@class='wb-button-text']"));
		int maxPrice = Integer.MIN_VALUE;
        int index = 0;
        
        for (int i = 0; i < priceList.size(); i++) {
            int price = Integer.parseInt(priceList.get(i).getText().substring(2));
            if (price > maxPrice){
                maxPrice = price;
                index = i;
            }
        }
		
        carList.get(index).click();
				
	    throw new io.cucumber.java.PendingException();
	}
	@When("user enters invalid email for contact info")
	public void user_enters_invalid_email_for_contact_info() {
		 WebElement userButtonIcon = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/header/div/div[1]/div[3]/div[3]/button/wb-icon"));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(userButtonIcon).perform();
		 WebElement loginButton = driver.findElement(By.xpath("//button[@aria-label='Login'])[1]"));
	     loginButton.click();
		 WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
	     emailInput.sendKeys("invalidEmail.com");	  
	     throw new io.cucumber.java.PendingException();
	}
	@Then("verify that invalid email error message has been displayed successfully")
	public void verify_that_invalid_email_error_message_has_been_displayed_successfully() {
		Assertion assertion = new Assertion();
		assertion.assertEquals(driver.findElement(By.xpath("//wb-control-error[@data-test-id='lwdxmw9nx__default-input']")).getText(), "Please enter a valid email address using a minimum of six characters.");
	    throw new io.cucumber.java.PendingException();
	}
	
	
}
