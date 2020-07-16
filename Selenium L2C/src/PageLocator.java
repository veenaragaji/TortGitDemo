import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Add required imports

public class PageLocator    //DO NOT Change the class Name
{
	static WebDriver driver;
	static WebElement element;
	public WebDriver createDriver()  //DO NOT change the method signature
	{
	   return DriverSetup.getWebDriver();
	}
	
	public WebElement getPageLocator(WebDriver driver)  //DO NOT change the method signature
	{
	   return driver.findElement(By.id("lastname"));
    
	}
	public String getName(WebElement element)  //DO NOT change the method signature
	{
	    return element.getAttribute("placeholder");
	    
	}
	
	public static void main(String[] args){
	    PageLocator p=new PageLocator();
	    driver=p.createDriver();
	    element=p.getPageLocator(driver);
	    System.out.println(p.getName(element));
	  
	}

}

