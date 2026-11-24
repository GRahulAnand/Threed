package webdriverscreenshots;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Self3 {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		String txt=driver.findElement(By.linkText("Images")).getText();
		System.out.println(txt);
		
		System.out.println("-----------");
		
		List<WebElement> txt1 = driver.findElements(By.tagName("a"));
		for(int i=0;i<txt1.size();i++)
		{
			if(!txt1.get(i).getText().isEmpty())
			System.out.println(txt1.get(i).getText());
		}
		System.out.println("-----------");
		 List<WebElement> txt2 = driver.findElements(By.xpath("//header[@id='gb']/div"));
		    for(int j=0;j<txt2.size();j++)
		    {
		    	if(!txt2.get(j).getText().isEmpty())
		    	{
		    		System.out.println(txt2.get(j).getText());
		    	}
		    }
       
	}

}
