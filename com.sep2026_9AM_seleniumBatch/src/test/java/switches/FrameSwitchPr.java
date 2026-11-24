package switches;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameSwitchPr {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icici.bank.in/");
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class=\"ipal-iframe-container android-device\"]")));
		driver.findElement(By.xpath("//div[@class=\"input-content \"]")).click();
		
	}

}
