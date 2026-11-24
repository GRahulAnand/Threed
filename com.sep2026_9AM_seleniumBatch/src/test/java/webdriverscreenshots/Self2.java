package webdriverscreenshots;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Self2 {

	public static void main(String[] args) throws IOException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
         List<WebElement> links = driver.findElements(By.linkText("Rajinikanth"));
         if(links.size()==0)
         {
        	 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	 FileHandler.copy(srcFile, new File("E:\\screenshot\\google.png"));
        	 
         }
         
	}

}
