package launcher;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_006 extends BaseTest
{
  
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		init();
		launch("chromebrowser");
		navigateUrl("amazonurl");
		driver.manage().window().maximize();
          Thread.sleep(5000);
			/*
			 * driver.findElement(By.id("twotabsearchtextbox")).sendKeys("philips");
			 * Thread.sleep(3000); driver.findElement(By.name("field-keywords")).clear();
			 * 
			 * driver.findElement(By.xpath("//input[@aria-label=\"Search Amazon.in\"]")).
			 * sendKeys("sony");
			 * 
			 * Thread.sleep(2000);
			 * driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).clear();
			 * 
			 * Thread.sleep(2000);
			 * driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("samsung"
			 * );
			 * 
			 * //driver.findElement(By.xpath(
			 * "//a[@data-csa-c-id='kit85t-kgpocf-k4f8c6-hq88ns']")).click();
			 * 
			 * //driver.findElement(By.linkText("Customer Service")).click();
			 */		
		      //driver.findElement(By.partialLinkText("tomer Serv")).click();
            //driver.findElement(By.xpath("//a[@data-csa-c-content-id=\"nav_cs_help\"]")).click();
          
              List<WebElement> links = driver.findElements(By.tagName("a"));
              System.out.println(links.size());
              for(int i=0;i<links.size();i++)
              {
            	  if(!links.get(i).getText().isEmpty())
            	  System.out.println(links.get(i).getText());
              }
              
	}
	

}
