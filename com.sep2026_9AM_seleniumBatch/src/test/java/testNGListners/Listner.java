package testNGListners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import launcher.BaseTest;

public class Listner extends BaseTest implements ITestListener
{
    public void onTestStart(ITestResult result)
    {
    	Reporter.log("Test Started Running:"+result.getMethod().getMethodName());
    }
    public void onTestSuccess(ITestResult result)
    {
    	if(result.isSuccess())
    	{
    		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    		try 
    		{
				FileHandler.copy(srcFile, new File(projectPath+"//success//"+filePath+".png"));
				Reporter.log("<a href='" +projectPath+"//success//"+filePath+".png" + "'> <img src='" +projectPath+"//success//"+filePath+"+.png" + "' height='100' width='100'/></a>");
				Reporter.log("Test has success:"+result.getMethod().getMethodName());
				Reporter.log(result.getThrowable().getMessage());
			}
    		catch (IOException e) 
    		{
				e.printStackTrace();
			}
    	}
    }
    public void onTestFailure(ITestResult result)
    {
    	if(!result.isSuccess())
    	{
    		
    		try 
    		{
    			File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(srcFile, new File(projectPath+"//failure//"+filePath+".png"));
				
			}
    		catch (IOException e) 
    		{
				e.printStackTrace();
    		}
    		Reporter.log("<a href='" +projectPath+"//failure//"+filePath+".png" + "'> <img src='" +projectPath+"//success//"+filePath+"+.png" + "' height='100' width='100'/></a>");
			Reporter.log("Test has failure:"+result.getMethod().getMethodName());
         }
    	
    }
    public void onTestSkipped(ITestResult result)
    {
    	Reporter.log("Test is skipped"+result.getMethod().getMethodName());
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
    	
    }
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
    
}
