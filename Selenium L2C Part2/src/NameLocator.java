import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NameLocator {      //DO NOT change the class name
 
    private static final boolean True = false;
	public static String baseUrl; //Assign 'http://webapps.tekstac.com/Handling_Regular_Expression/' for baseUrl
    public static WebDriver driver;
	
	public WebDriver createDriver()
	{
	    driver=DriverSetup.getWebDriver();
	    return driver;
		//Create driver. Assign it to static variable 'driver' and return it
	}
	
	public void navigate(WebDriver driver){
	     //Navigate to the baseUrl
		baseUrl="http://webapps.tekstac.com/Handling_Regular_Expression/";
		driver.navigate().to(baseUrl);
			
	}
	
   	public void setFormValues(WebDriver driver)
	{
	    driver.findElement(By.id("userId")).sendKeys("Shamili");
	    driver.findElement(By.id("track")).click();
   		//set the value for 'Shipment for user' and submit form
	}

    public WebElement getNameResultElement(WebDriver driver) {
    	return driver.findElement(By.xpath("//div[@id='result']/table/tbody/tr[1]/td[2]"));
        //Find the element of 'Shamili' and return it
        
    }
    public WebElement getShipmentResultElement(WebDriver driver) {
    	return driver.findElement(By.xpath("//div[@id='result']/table/tbody/tr[2]/td[2]"));
        
    	//Find the element of 'SHIP1236' and return it
    }
    public WebElement getEmailResultElement(WebDriver driver) {
    	return driver.findElement(By.id("e- mail"));
        //Find the element of 'shamili93@gamil.com' and return it
    }
    
    public boolean validateEmail(String eMailID) {
    	
    	String mail="\\b[A-Z0-9a-z-]+@[a-z]+\\.[a-z]{2,4}\\b";
    	Pattern p=Pattern.compile(mail);
    	Matcher m=p.matcher(eMailID);
    	if(m.matches())
    		return true;
    	else
    			return false;
       //Validate email using regex. 
        
    }
    public boolean validateShipmentId(String shipmentId) {
		String Id="[A-Z0-9]{8}";
		System.out.println(shipmentId);
		Pattern p=Pattern.compile(Id);
    	Matcher m=p.matcher(shipmentId);
    	if(m.matches())
    		return true;
    	else
    		return false;
        //Validate shipmentId using regex
        
    }         
        
       
  
    public static void main(String[] args)
	{
	   NameLocator n= new NameLocator();
	   driver=n.createDriver();
	   n.navigate(driver);
	   n.setFormValues(driver);
	   WebElement email=n.getEmailResultElement(driver);
	   WebElement id=n.getShipmentResultElement(driver);
	   System.out.println("Email status-"+n.validateEmail(email.getText()));
	   System.out.println(n.validateShipmentId(id.getText()));
	   
	}

  
}
