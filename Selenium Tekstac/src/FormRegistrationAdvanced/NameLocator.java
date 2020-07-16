package FormRegistrationAdvanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class NameLocator      //DO NOT Change the class name
{
    //Use the declared variables for stroing required values
	static String fName;
	static WebDriver driver;
	
	public WebDriver setupDriver()           //DO NOT Change the method Signature
	{
	    return DriverSetup.getWebDriver();
	}
	public String getNameLocator()              //DO NOT Change the method Signature
	{
	   driver.get("http://webapps.tekstac.com/AddressBook/");
	   WebElement e=driver.findElement(By.xpath("//div[@id='t1']/table/tbody/tr[1]/td[1]//ancestor::div"));
	  // System.out.println(e+"\n"+e.toString());
	  
	   fName=e.getText();
	   return fName;
	  // driver.close();
	  // return fName;
	   
		/*Using the driver, Find the element ancestor and its text and assign the text to 'fName' */
       /*Close the driver*/
	   
	   //assertEquals(actual, expected);
      
	}
	
	public static void main(String[] args)
	{
	    NameLocator n=new NameLocator();
	    driver=n.setupDriver();
	     n.getNameLocator();
	   // System.out.println(fName);
	    //Add required code here
	}

}

