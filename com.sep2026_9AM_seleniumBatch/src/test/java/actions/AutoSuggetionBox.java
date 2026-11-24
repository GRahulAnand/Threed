package actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggetionBox {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.name("q")).sendKeys("Hadoop tutorial1");
		String val=driver.findElement(By.name("q")).getAttribute("value");
		         System.out.println(val);
		List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"gDtRnb\"]//li[1]"));
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getText().equalsIgnoreCase(val))
			{
				list.get(i).click();
				return;
			}
		}
	}

}
