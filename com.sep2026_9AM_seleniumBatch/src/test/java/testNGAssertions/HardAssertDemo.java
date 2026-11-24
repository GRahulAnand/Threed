package testNGAssertions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class HardAssertDemo {
  @Test
  public void f()  
  {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon";
	  String actualTitle=driver.getTitle(); 
	  //Assert.assertEquals(actualTitle, expectedTitle);
	  Assert.assertTrue("Both title are not equal...",actualTitle.equals(expectedTitle));
	  
	  driver.findElement(By.xpath("//a[text()='Fresh']")).click();
	  }
}
