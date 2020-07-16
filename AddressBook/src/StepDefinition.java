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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;

public class StepDefinition {
	WebDriver driver;
	//public static String discountText;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp au-620tx\\Desktop\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary();
    	firefoxBinary.addCommandLineOptions("--headless");
        FirefoxProfile profile=new FirefoxProfile();
    	FirefoxOptions firefoxOptions = new FirefoxOptions();
    	firefoxOptions.setBinary(firefoxBinary);
    	firefoxOptions.setProfile(profile);
        driver=new FirefoxDriver(firefoxOptions);
        /*System.setProperty("webdriver.chrome.driver","C:\\Users\\hp au-620tx\\Desktop\\chromedriver_win32\\chromedriver.exe"); 
		driver=new ChromeDriver();*/
        
		//loadURL();		
	}
	@Given("^Launch the application$")
	public void loadURL() {
		String baseUrl = "https://webapps.tekstac.com/AddressBook/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		WebElement heading = driver.findElement(By.xpath("/html/body/center/h2"));
		
		ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return (heading.getText().equals("Address Book"));
                    }
                };
        
		WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(expectation);
	}

	@When("^address details are added$")
	public void testAddressBook(DataTable addressValues) {
		List<List<String>> data = addressValues.raw();
		driver.findElement(By.id("nickname")).sendKeys(data.get(1).get(0));
		driver.findElement(By.id("contact")).sendKeys(data.get(1).get(1));
		driver.findElement(By.id("company")).sendKeys(data.get(1).get(2));
		driver.findElement(By.id("city")).sendKeys(data.get(1).get(3));
		driver.findElement(By.id("country")).sendKeys(data.get(1).get(4));
		driver.findElement(By.id("type")).sendKeys(data.get(1).get(5));
		driver.findElement(By.id("add")).click();
		
		driver.findElement(By.id("nickname")).sendKeys(data.get(2).get(0));
		driver.findElement(By.id("contact")).sendKeys(data.get(2).get(1));
		driver.findElement(By.id("company")).sendKeys(data.get(2).get(2));
		driver.findElement(By.id("city")).sendKeys(data.get(2).get(3));
		driver.findElement(By.id("country")).sendKeys(data.get(2).get(4));
		driver.findElement(By.id("type")).sendKeys(data.get(2).get(5));
		driver.findElement(By.id("add")).click();	
		
		driver.findElement(By.id("nickname")).sendKeys(data.get(3).get(0));
		driver.findElement(By.id("contact")).sendKeys(data.get(3).get(1));
		driver.findElement(By.id("company")).sendKeys(data.get(3).get(2));
		driver.findElement(By.id("city")).sendKeys(data.get(3).get(3));
		driver.findElement(By.id("country")).sendKeys(data.get(3).get(4));
		driver.findElement(By.id("type")).sendKeys(data.get(3).get(5));
		driver.findElement(By.id("add")).click();
	}

	@When("^addresses are deleted$")
	public void deleteAddressBook(DataTable addressValues) {
		//List<List<String>> data = addressValues.raw();
		List<List<String>> data = addressValues.raw();
		String t=driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[1]")).getText();
		if(t.indexOf(data.get(1).get(0))!=-1){
			System.out.println("Data to be deleted match.");
			driver.findElement(By.id("radio0")).click();
			driver.findElement(By.id("delete")).click();
		}
		
	}
	
	@Then("^all addresses should be displayed to the right$")
	public void validateResult(DataTable expectedAddresses) {
		List<List<String>> data = expectedAddresses.raw();
		
		String t=driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[1]")).getText();
		System.out.println(t);
		if(t.indexOf(data.get(1).get(0))!=-1)
			System.out.println("Nickname found");
			
		String cont=driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[2]")).getText();
		String cmny=driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[3]")).getText();
		String city=driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[4]")).getText();
		String cntry=driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[5]")).getText();
		String type=driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[6]")).getText();
		
		////*[@id="result"]/table/tbody/tr[2]/td[1]
		assertEquals(cont, data.get(1).get(1));
		assertEquals(cmny, data.get(1).get(2));
		assertEquals(city, data.get(1).get(3));
		assertEquals(cntry, data.get(1).get(4));
		assertEquals(type, data.get(1).get(5));
	}

	@After
	public void tearDown(){
	//	driver.close();
		//driver.quit();
	}

}
