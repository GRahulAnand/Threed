package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action3 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/slider/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		WebElement drag = driver.findElement(By.id("slider"));
		//a.dragAndDropBy(drag, 100, 0).perform();
		a.clickAndHold(drag).moveByOffset(100, 0).release(drag).build().perform();
		
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		//RightClick on Element
		WebElement element = driver.findElement(By.linkText("Selectable"));
		a.contextClick(element).perform();
		
		//a.keyDown(Keys.TAB);//search the webside apply the it all method;
	}

}
