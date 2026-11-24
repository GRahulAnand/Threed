package launcher;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class HighlightingtTakeScreenShot extends BaseTest
{

	public static void main(String[] args) throws  IOException, InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		Thread.sleep(3000);
		
		
		WebElement linktxt=driver.findElement(By.linkText("Customer Service"));
		
		JavascriptExecutor jsExecutor=(JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", linktxt);
		Date dt=new Date();
		System.out.println(dt);
		String linktxt1 = dt.toString().replace(':','_').replace(' ', '_')+".png";
		 File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    
	     
		FileHandler.copy(srcFile, new File(projectPath+"//failurescreenshots//"+linktxt1));
	}

}
