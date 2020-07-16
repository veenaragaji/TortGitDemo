
package demo;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.GetScreenshot;

public class ExtentReport{
	ExtentReports report;
	WebDriver driver;
	ExtentTest test;
	private static Logger log=LogManager.getLogger(ExtentReport.class.getName());
	
	@BeforeTest
	public void extentConfig() {
		String path = System.getProperty("user.dir") + "//ExtentReports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Basic Extent Report");
		reporter.config().setReportName("Demo Report");

		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("tester", "veena");
	}

	@AfterMethod
	public void tearDown(ITestResult res) throws IOException {
		//
		if (res.getStatus() == ITestResult.FAILURE) {
			String path = GetScreenshot.getScreenshot(driver);

			test.fail("Test case Failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}

		// MediaEntityBuilder.createScreenCaptureFromPath(path);
		driver.close();
		report.flush();
	}

	@Test
	public void extentDemo() throws IOException, InterruptedException {
		
		test = report.createTest("First Report Test");
		log.trace("This is demo trace");
		log.debug("Setting system property");
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hp au-620tx\\Desktop\\Selenium\\SW\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		log.info("Window maximized");
		driver.get("https://rahulshettyacademy.com/#/index");
		test.log(Status.PASS, "Passed step 1 " + test.addScreenCaptureFromPath(GetScreenshot.getScreenshot(driver)));

	
		Thread.sleep(1000);
		test.addScreenCaptureFromPath(GetScreenshot.getScreenshot(driver));
		try{
		driver.findElement(By.xpath("//a[@class='theme-btn register-bt']")).click();
		}
		catch(Exception e){
			log.error("Step failed - Exception"+e.getMessage());
			
		}
		
		// GetScreenshot.getScreenshot(driver);
		// Assert.assertEquals(driver.getTitle(),"VeenaRagaji");
		// test.log(Status.PASS, "Passed step 3
		// "+test.addScreenCaptureFromPath(GetScreenshot.getScreenshot(driver)));

	}

}
