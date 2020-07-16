package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.TestBase;

public class HRMHome extends TestBase{
	WebDriver driver;
	public HRMHome(String browser) {
		super();
		driver=setUp(browser);
	}
	public void login(){
	String user_name="Admin";
	
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");		
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
	
	WebElement e=driver.findElement(By.xpath("//a[@id='welcome'][text()='Welcome "+user_name+"']"));
	System.out.println(e.getText());
	}
	public void tearDown(){
		driver.close();
	}
}
