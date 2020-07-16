import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Add required imports

public class RelativeXpathLocator    //DO NOT Change the class Name
{
	static WebDriver driver;
	public WebDriver createDriver()    //DO NOT change the method signature
	{
		return DriverSetup.getWebDriver();
	   //Implement code to create Driver from DriverSetup and return it
	}
	public WebElement getRelativeXpathLocator(WebDriver driver)//DO NOT change the method signature
	{
		driver.get("http://webapps.tekstac.com/Shopify/");
		return driver.findElement(By.xpath("//tr[@id='tbrow']/td[3]"));
		
	   /*Replace this comment by the code statement to get the Web element */
	   /*Find and return the element */
       
	}
	public String getName(WebElement element)//DO NOT change the method signature
	{
		return element.getText();
	    //Get the attribute value from the element and return it
	}

    public static void main(String[] args){
	    RelativeXpathLocator r= new RelativeXpathLocator();
	    driver=r.createDriver();
	    WebElement element=r.getRelativeXpathLocator(driver);
	    System.out.println(r.getName(element));
	    
	    
	}
}

