package FormRegistrationAdvanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class Registration 
{
	String fName;
	static WebDriver driver;
	static String baseUrl; 
	
	public WebDriver setupDriver()
	{
	    
	    driver=DriverSetup.getWebDriver();
	    return driver;
	}
	
	public void setElements()
	{
	    baseUrl="http://webapps.tekstac.com/Shopify/";
	    driver.get(baseUrl);
	    
	    driver.findElement(By.id("firstname")).sendKeys("Mithali");
	    driver.findElement(By.id("lastname")).sendKeys("Raj");
	    driver.findElement(By.id("username")).sendKeys("Mithali Raj");
	   
	    Select dd=new Select( driver.findElement(By.id("selectcity")));
	    dd.selectByIndex(2); 
	    driver.findElement(By.xpath("/html/body/form/div[6]/input[2]")).click();
	    
	    
	    driver.findElement(By.id("pass")).sendKeys("pass#123");
	    
	    driver.findElement(By.id("reg")).click();
		/*Using the driver, Find the elements by id 
	      Set the values to the elements
	      Register the form*/
       
	}
	
	public static void main(String[] args)
	{
	    Registration reg=new Registration();
	    driver=reg.setupDriver();
	    reg.setElements();
	    /* Implement the code here */
	   
	}

}

