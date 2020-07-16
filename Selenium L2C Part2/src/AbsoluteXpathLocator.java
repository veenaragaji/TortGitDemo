import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Add required imports

public class AbsoluteXpathLocator  //DO NOT Change the class Name
{
	static WebDriver driver;
	public WebDriver createDriver()
	{
		return DriverSetup.getWebDriver();
	   //Implement code to create Driver from DriverSetup and return it
	}
	public WebElement getAbsoluteXpathLocator(WebDriver driver)//DO NOT change the method signature
	{
		driver.get("http://webapps.tekstac.com/Shopify/");
		return driver.findElement(By.xpath("html/body/form/div/img"));
		
	   /*Replace this comment by the code statement to get the Web element of logo */
	   /*Find and return the element */ 
		
	}
	public String getName(WebElement element)    //DO NOT change the method signature
	{
		return element.getAttribute("src");
	    //Get the attribute value from the element and return it
	}

    public static void main(String[] args){
	    AbsoluteXpathLocator p=new AbsoluteXpathLocator();
	    driver=p.createDriver();
	    WebElement e=p.getAbsoluteXpathLocator(driver);
	    
	    System.out.println(p.getName(e));
	    
	   //Add required code    
	}

}

