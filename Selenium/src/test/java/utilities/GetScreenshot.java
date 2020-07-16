package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot {
	public static String getScreenshot(WebDriver driver) throws IOException{
		String path;
		TakesScreenshot t=(TakesScreenshot)driver;
		File src=t.getScreenshotAs(OutputType.FILE);
	//	if(res.getStatus()==ITestResult.SUCCESS)
			path=System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
		//else
			//path=System.getProperty("user.dir")+"/ScreenshotsFailed/"+System.currentTimeMillis()+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
}


