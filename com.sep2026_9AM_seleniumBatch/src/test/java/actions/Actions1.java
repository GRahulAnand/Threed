package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions1 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		Thread.sleep(15000);
		Actions a = new Actions(driver);
		WebElement loc = driver.findElement(By.xpath("//span[text()='Login']"));
		a.moveToElement(loc).click().perform();
		 driver.findElement(By.xpath("//div[text()='Your Account']")).click();

	}

}
