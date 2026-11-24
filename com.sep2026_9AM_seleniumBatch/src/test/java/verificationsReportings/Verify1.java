package verificationsReportings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verify1 {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//String actualLink = driver.findElement(By.xpath("//a[text()='Customer Service']")).getText();
		String actualLink = driver.findElement(By.xpath("//a[text()='Customer Service']")).getAttribute("innerHTML");
		System.out.println("Text: "+actualLink);
		
		String expectedLink="Customer Ser";
		
		
		System.out.println("ActualLink:"+actualLink);
		System.out.println("ExpectedLink:"+expectedLink);
		
		//if(actualLink.equals(expectedLink))
		//if(actualLink.equalsIgnoreCase(expectedLink))
		
		  if(actualLink.contains(expectedLink))
		   {
			System.out.println("Both are equal..");
		    }
		   else
		  {
			System.out.println("Both are not equal...");
		}
	}

}
