package switches;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameSwitch 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(5000);
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=\"courses-iframe\"]")));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//iframe[@id=\"courses-iframe\"]")).click();
		driver.switchTo().defaultContent();
		

	} 
}
