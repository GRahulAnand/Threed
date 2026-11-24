package switches;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchWindow1 {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.icici.bank.in/");
		Thread.sleep(5000);
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		
		String title = driver.getTitle();
		System.out.println(title);
		
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        while(wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//img[contains(@src,\"/content/dam/icicibank/india/managed-assets/images/banner-2-ak-default-image-url-mob.webp\")]")))).isDisplayed())
        {
        	boolean t1 = driver.findElement(By.xpath("//img[contains(@src,\"/content/dam/icicibank/india/managed-assets/images/banner-2-ak-default-image-url-mob.webp\")]")).isDisplayed();
        	System.out.println(t1);
        	break;
        }
        driver.findElement(By.xpath("//img[contains(@src,\"/content/dam/icicibank/india/managed-assets/images/banner-2-ak-default-image-url-mob.webp\")]")).click();
        
        Set<String> windows = driver.getWindowHandles();
        ArrayList<String> nwinds = new ArrayList<String>(windows);
        for(String i:nwinds)
        {
        	System.out.println(i);
        }
         driver.switchTo().window(nwinds.get(1));
         
         String title1 = driver.getTitle();
		System.out.println(title1);
		driver.close();
		 driver.switchTo().window(nwinds.get(0));
		 String title2 = driver.getTitle();
			System.out.println(title2);
			
	
	}
}
