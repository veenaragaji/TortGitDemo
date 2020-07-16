import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Add required imports

public class CSSLocator     //DO NOT change the class name
{
	public static WebDriver driver;
	public WebDriver createDriver()  //DO NOT change the method signature
	{
		return DriverSetup.getWebDriver();
	   //Implement code to create Driver from DriverSetup and return it
	}
	
	public WebElement getCSSLocator(WebDriver driver)  //DO NOT change the method signature
	{
		driver.get("http://webapps.tekstac.com/Shopify/");
		return driver.findElement(By.cssSelector("input[id='username']"));
	   /*Replace this comment by the code statement to get the Web element of username*/
	   /*Find and return the element */ 
       
	}
	
	public String getName(WebElement element)  //DO NOT change the method signature
	{
		return element.getAttribute("placeholder");
	    //Get the attribute value from the element and return it
	}
	
    public static void main(String[] args){
	    CSSLocator c=new CSSLocator();
	    driver=c.createDriver();
	    WebElement e=c.getCSSLocator(driver);
	    String s=c.getName(e);
	    System.out.println(s);
	    
	    
	    
	    //Add required code
	    
	}
}

