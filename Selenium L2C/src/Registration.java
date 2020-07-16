import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class Registration    //DO NOT Change the class Name
{
	
	static String baseUrl; //Assign the value for baseUrl
	static WebDriver driver;
	
	public WebDriver createDriver()       //DO NOT change the method signature
	{
	   return DriverSetup.getWebDriver();
	}
	
	public void navigate(WebDriver driver)   //DO NOT change the method signature
	{
	    baseUrl=" http://webapps.tekstac.com";
		driver.get(baseUrl);
		driver.navigate().to("http://webapps.tekstac.com/InvoiceUpdates/");
	    
	}
	
	public Select getCategoryElement(WebDriver driver)  //DO NOT change the method signature
	{
	  WebElement element=driver.findElement(By.xpath("//form[@name='myform']/table/tbody/tr[5]/td[2]/select"));
		 
	 // System.out.println(e.g);
	Select dd=new Select(element);
	dd.selectByValue("utility invoice");
	return dd;
	   
	   /* Select Value "Utility Invoice" from 'Category' (drop-down) and return the select element  
             * Declare the drop-down element as an instance of the Select class. 
             * Return select object    */
       
	}
	public void setFormValues(WebDriver driver)  //DO NOT change the method signature
	{
	    /*Using the driver, Find the elements by id and send the values to the elements */
      
      /*  Send 'Rakesh' for 'name'  
               '123' for 'number'
                'new user' for user type 
                'Utility Invoice' for select 
                '1000' for 'amount'
                '9876543210' for phone 
                'New User Invoice' for 'comments'
      */ 
      driver.findElement(By.id("name")).sendKeys("Rakesh");
      driver.findElement(By.id("number")).sendKeys("123");
      driver.findElement(By.id("newUser")).click();
      driver.findElement(By.name("amount")).sendKeys("1000");
      driver.findElement(By.name("num")).sendKeys("9876543210");
      driver.findElement(By.name("comments")).sendKeys("New User Invoice");
      
      driver.findElement(By.id("submit")).click();
	}
	
	public WebElement getSuccessMessageElement(WebDriver driver) //DO NOT change the method signature
	{
	    //Get the message element and return it
		return driver.findElement(By.id("result"));
	    //After registration a success message is displayed. Identify and return the WebElement of the same. 
	}

	public String getSuccessMessage(WebElement element)  //DO NOT change the method signature
	{
	    //Get the attribute value from the WebElement of success message displayed and return it. 
		return element.getText();
	}

    public static void main(String[] args){
	    Registration reg=new Registration();
	    driver=reg.createDriver();
	    reg.navigate(driver);
	    reg.getCategoryElement(driver);
	    reg.setFormValues(driver);
	    WebElement element=reg.getSuccessMessageElement(driver);
	    reg.getSuccessMessage(element);
	    
	    //Add required code
	    
	    
	}
}

