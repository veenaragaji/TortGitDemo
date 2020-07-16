package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxBinary;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.*;


public class StepDefinition {

	WebDriver driver;
	String text;

	@Given("^User loads the application and navigate to home page$")
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
		driver.get("https://webapps.tekstac.com/Handling_Reg_Expression");
		System.out.println("Application is launched");
	}

	@When("^User enters \"([^\"]*)\" on the tracking page$")
	public void testUserDetails(String Name){
		driver.findElement(By.xpath("//*[@id='userId']")).sendKeys(Name);
		driver.findElement(By.id("track")).click();
		
	}

	@Then("^following should be displayed$")
	public void validateResult(DataTable ShipmentDetails) {
		String name;
		List<List<String>> data = ShipmentDetails.raw();
	      //System.out.println(data.get(1).get(1)); 
	    
	      //Enter data
	       	  String xPathWithVariable = "//*[@id='result']";
		      String n=driver.findElement(By.xpath(xPathWithVariable)).getText();
		      //System.out.println(n);
		     
		      String an=data.get(1).get(0);
		      String aid=data.get(1).get(1);
		      String ap=data.get(1).get(2);
		      String ae=data.get(1).get(3);
		      
		      if(n.indexOf(an)!=-1 && n.indexOf(aid)!=-1 && n.indexOf(ap)!=-1 && n.indexOf(ae)!=-1){
		    	  
		    	  System.out.println("All Valid data");
		    	  
		      }
		      else{
		    	  System.out.println(("Data Mismatch"));
		      }
	          
	     
	}
	
	@After
	public void closeDriver(){
		driver.quit();
	}
}


