package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxBinary;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	WebDriver driver;
	String text;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
    	FirefoxBinary firefoxBinary = new FirefoxBinary();
    	firefoxBinary.addCommandLineOptions("--headless");
        FirefoxProfile profile=new FirefoxProfile();
    	FirefoxOptions firefoxOptions = new FirefoxOptions();
    	firefoxOptions.setBinary(firefoxBinary);
    	firefoxOptions.setProfile(profile);
        driver=new FirefoxDriver(firefoxOptions);
		/*System.setProperty("webdriver.chrome.driver","C:\\Users\\hp au-620tx\\Desktop\\chromedriver_win32\\chromedriver.exe"); 
		driver=new ChromeDriver();*/
	}
	
	@Given("^I have navigated to shipping application home page$")
	public void loadUrl(){
		driver.get("https://webapps.tekstac.com/CostCalculation/");	    
		System.out.println("Application is launched");
	    
	}
	
	@When("^I enter \"(.*)\" and select \"(.*)\" Transport mode$")
	public void testCalculateCost(String weight, String transportmode){
		driver.findElement(By.id("weight")).sendKeys(weight);
		driver.findElement(By.id(transportmode)).click();
		//driver.findElement(By.id("premium")).click();
		driver.findElement(By.id("calculate")).click();
	}

	
	@Then("^I validate the message with total shipping cost$")
	public void validateResult(){
		List<WebElement> l=driver.findElements(By.name("mode"));
		String mode="";
		String etext="";
		for(WebElement e:l){
			if(e.isSelected()==true){
				//System.out.println("Mode found"+e.getAttribute("id"));
				mode=e.getAttribute("id");
			}
		}
		//System.out.println(mode);
		if(mode.equals("air"))
			etext="Dear Customer, your total shipping cost is $100";
		if(mode.equals("ship"))
			etext="Dear Customer, your total shipping cost is $70";
		if(mode.equals("road"))
			etext="Dear Customer, your total shipping cost is $50";
		//System.out.println(mode+etext);
		text=driver.findElement(By.id("result")).getText();
		//System.out.println(text+'\n'+Message);
		if(text.equals(etext))
			System.out.println("Validation Success");
		else
			System.out.println("Validation failure");
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
}
