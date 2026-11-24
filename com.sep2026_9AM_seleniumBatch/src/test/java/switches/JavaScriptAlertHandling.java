package switches;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;
  
public class JavaScriptAlertHandling {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("name")).sendKeys("Rahul");
		driver.findElement(By.id("alertbtn")).click();
		
		Alert a1=driver.switchTo().alert();
		
		System.out.println(a1.getText());
		String expval="Hello Rahul, share this practice page and share your knowledge";
		Assert.assertEquals(a1.getText(), expval);
		a1.accept();
		
		
	
	}

}
