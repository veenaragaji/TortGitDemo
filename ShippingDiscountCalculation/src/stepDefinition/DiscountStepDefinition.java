package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxBinary;

import cucumber.api.java.en.*;


public class DiscountStepDefinition {

	WebDriver driver;
	String text;


	@Given("^User loads the application and navigate to DATAX shipping company home$")
	public void setUp() {
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
		driver.get("https://webapps.tekstac.com/CompanyOffersDiscount/");
		System.out.println("Application is launched");
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" on Company Offers Discount page$")
	public void testDiscount(String weight, String distance) {	
	    driver.findElement(By.id("weight")).sendKeys(weight);
	    driver.findElement(By.id("distance")).sendKeys(distance);
	    driver.findElement(By.id("submit")).click();
	}

	@Then("^The text \"([^\"]*)\" should be displayed$")
	public void validateResult(String Message) {
		String r=driver.findElement(By.id("result")).getText();
		assertEquals(r, Message);
		if(r.equals(Message)){
			System.out.println("Discount");
		}
		
		driver.quit();
	}

}


