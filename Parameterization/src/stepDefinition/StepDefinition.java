package stepDefinition;
import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefinition {
	public WebDriver driver;
	String text;
	
	@Given("^Start firefox browser and open the application$")
	public void SetUp() throws Throwable {
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
		driver.get("http://webapps.tekstac.com/shippingDetails/");
	}
	@When("^Test the text in H2 tag and the \"([^\"]*)\" for ShipmentID$")
	public void testShippingDetails(String arg1) throws Throwable {
		String title;
		title=driver.findElement(By.xpath("/html/body/div[1]/center/h2")).getText();
		Assert.assertEquals("Shipping Details", title);
		List<WebElement> l=driver.findElements(By.tagName("a"));
		for(WebElement e:l){
			if(e.getText().equals(arg1)){
				text=e.getText();
				assertEquals(text, arg1);
				e.click();
			}
		}	
		String t1=driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[1]/td[1]/b")).getText();
		String t2=driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[1]/td[2]/b")).getText();
		
		assertEquals(t1, "Ship From");
		assertEquals(t2, "Ship To");
			
	}
	@Then("^Validate the Customer name \"([^\"]*)\" is displayed$")
	public void validateResult(String arg1) throws Throwable {
		String text=driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[1]")).getText();
		assertEquals(text, arg1);
		System.out.println("Customer name matches");
	}

	/*@When("^Test the text is present in h(\\d+) tag$")
	public void testShippingDetails(int arg1) throws Exception {
		String title;
		title=driver.findElement(By.xpath("/html/body/div[1]/center/h"+arg1)).getText();
		Assert.assertEquals("Shipping Details", title);
	}*/

	/*@Then("^Test the text \"([^\"]*)\" as a link$")
	public void validateResult(String arg1) throws Exception {
		List<WebElement> l=driver.findElements(By.tagName("a"));
		for(WebElement e:l){
			if(e.getText().equals(arg1)){
				e.click();
			}
		}	
		String t1=driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[1]/td[1]/b")).getText();
		String t2=driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[1]/td[2]/b")).getText();
		
		assertEquals(t1, "Ship From");
		assertEquals(t2, "Ship To");
			
		
	}	
	@And("^Text \"([^\"]*)\" should be present in the table\\.$")
	public void text_should_be_present_in_the_table(String arg1) throws Exception {
		String text=driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[1]")).getText();
		assertEquals(text, arg1);
		driver.close();
	}*/
	@Then("^Quit the browser$")
	public void Quit_the_browser() throws Throwable {
	driver.close();
	}
	
}
