package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberProject.cucumber.TestBase;

public class StepDefinition {
	WebDriver driver;
	@Before
	public void init(){
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/executables/chromedriver.exe");
		//driver=new ChromeDriver();
		TestBase tb=TestBase.getInstance();
		driver=tb.getDriver();
	}
	@Given("^user launch the url$")
	public void user_launch_the_url() throws Throwable {
		driver.get("https://www.facebook.com/");
	    System.out.println("user launch the url");
	}

	@When("^user enters following and click login$")
	public void user_enters_following_and_click_login(DataTable table) throws Throwable {
	    //Accessing datatable through index
		WebElement euser=driver.findElement(By.id("email"));
		WebElement epass=driver.findElement(By.id("pass"));
		WebElement ebutton=driver.findElement(By.id("u_0_b"));
		/*System.out.println("User enters following and click login");
	    List<List<String>> data=table.raw();
	    System.out.println("UserName-"+data.get(1).get(0));
	    System.out.println("Password-"+data.get(1).get(1));*/
	    
	    //Accessing datatable through Pojo class
	    List<User> users=new ArrayList<User>();
	    users=table.asList(User.class);
	    
	    
	    
	    
	
	    for(User user:users){
	    	System.out.println("Pojo username-"+user.username);
	    	System.out.println("Pojo password-"+user.password);
	    	euser.sendKeys(user.username);epass.sendKeys(user.password);
	    	
	    }
	    
	}

	@Then("^verify login is successful$")
	public void verify_login_is_successful() throws Throwable {
	 System.out.println("verify login is successful");   
	 
	}
	
	@After
	public void tearDown(){
		driver.close();
	}


}

class User{
	String username;
	String password;
	
	User(String username,String password){
		this.username=username;
		this.password=password;
	}
}
