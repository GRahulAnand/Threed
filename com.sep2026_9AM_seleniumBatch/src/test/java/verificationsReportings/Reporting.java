package verificationsReportings;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

import launcher.BaseTest;

public class Reporting extends BaseTest  
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test=rep.createTest("Reporting");
		logInfo("Init the Properties files.....");
		
		launch("chromebrowser");
		logInfo("Opening the Browser:-"+p.getProperty("chromebrowser"));
		//test.log(Status.INFO, "Opening the Browser:-"+p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		logInfo("Navigating to application: " +childProp.getProperty("amazonurl"));
		//test.log(Status.INFO, "Navigating to application: " +childProp.getProperty("amazonurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String expectedLink= "Customer Servic";
		
		if(!isLinkEqual(expectedLink))
		{
			reportFailure("Both Links are not equal");
			
		}
		else
		{
			reportSuccess("Both Links are equal");
		}
		rep.flush();
	}
	}


