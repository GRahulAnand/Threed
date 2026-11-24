package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action2 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Thread.sleep(15000);	
		
	  WebElement drag=driver.findElement(By.id("draggable"));
	  WebElement drop = driver.findElement(By.id("droppable"));
	  
	     Actions a = new Actions(driver);
	     //a.dragAndDrop(drag, drop).perform();
       a.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
	}

}
