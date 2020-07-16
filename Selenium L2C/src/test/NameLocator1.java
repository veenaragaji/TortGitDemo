package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class NameLocator1 
{
	String fName;  
	static WebDriver driver;  
	
	public WebDriver setupDriver()
	{
	    /*Invoke the getWebDriver method from the DriverSetup File*/
		//DriverSetup ds=new DriverSetup();
		driver=DriverSetup.getWebDriver();
	    return driver;
	}
	public String getNameLocator()
	{
       /*Identify the Firstname
	     Get the placeholder value
         Store the placeholder value in the static variable fName.*/
		//driver=setupDriver();	
		fName=driver.findElement(By.name("fname")).getAttribute("placeholder");
		return fName;
	}
	
	public static void main(String[] args)
	{
	    NameLocator1 namLocator=new NameLocator1();
	    driver=namLocator.setupDriver();
	    String name=namLocator.getNameLocator();
	    System.out.println("The name is "+name);
	}

}

