

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	   fName=e.getText();
	   driver.close();
	   return fName;
	   
		/*Using the driver, Find the element ancestor and its text and assign the text to 'fName' */
       /*Close the driver*/
      
	}
	
	public static void main(String[] args)
	{
	    NameLocator n=new NameLocator();
	    driver=n.setupDriver();
	    fName=n.getNameLocator();
	    System.out.println(fName);
	    //Add required code here
	}

}

