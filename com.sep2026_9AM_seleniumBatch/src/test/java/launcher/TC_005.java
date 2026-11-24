package launcher;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_005 extends BaseTest
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		init();
		
		launch("chromebrowser");
		navigateUrl("amazonurl");
		driver.manage().window().maximize();
		selectOption("amazondropbox_id","Books");
		typeText("amazonsearchtextbox_id","Harry Potter");
		clickElement("amazonsearchbutton_xpath");
		
		
		
				
		//WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		//loc.sendKeys("Books");
				
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
				
		
		
		//driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
	}

	
	

	

	
}
