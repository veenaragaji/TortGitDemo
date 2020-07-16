/* IMPORTANT:- DriverSetup --getWebDriver()
-------------------------------------------------
PLEASE DO NOT MAKE ANY CHANGES OR MOFICATIONS IN THIS PROGRAM */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class DriverSetup
{ 
    private static WebDriver driver;
    public static WebDriver getWebDriver()
	{
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
	//	System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp au-620tx\\Desktop\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		
		FirefoxBinary firefoxBinary = new FirefoxBinary();
	firefoxBinary.addCommandLineOptions("--headless");
	    FirefoxProfile profile=new FirefoxProfile();
	    //profile.setPreference("marionette.logging", "TRACE");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		firefoxOptions.setProfile(profile);
		driver=new FirefoxDriver(firefoxOptions);
	    String baseUrl = "http://webapps.tekstac.com/Shopify/";
	    driver.get(baseUrl);
	    return driver;
	}
}

