package launcher;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(6000);
		driver.get("https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Goibibo-Flight&utm_term=!SEM!DF!G!Brand!RSA&cmp=SEM|D|DF|G|Google-CPC-Brand|DF-Brand-EM|Goibibo-Flight|RSA%3e&gad_source=1&gad_campaignid=108599293&gbraid=0AAAAADrlxCebQ7jZozDJxsGqCvAthvy6l&gclid=CjwKCAjw1vXTBhB-EiwAEKr_k_YnFBzSf9ZdPn7H5zBPjaL7zF-tkLSoitucEX-7-0gou7et-Ca0xRoCXJAQAvD_BwE");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//label[@for=\"departure\"]")).click();
		Thread.sleep(6000);
		String price = driver.findElement(By.xpath("//p[@style=\"color: rgb(255, 255, 255);\"]")).getText();
                  System.out.println("today price:-" +price);
		
		  //int i=0;
		    List<WebElement> months = driver.findElements(By.xpath("(//div[@class='DayPicker-Caption']/div)"));
		    for( int i=1;i<=months.size();i++)
		    while(i<3)
		    {
		      WebElement m = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)"+"["+(i)+"]"));
		    	System.out.println(m.getText());
		    	
		    	if(!m.getText().contains("october 2026"))
		    		i++;
		    	
		    	else	
		    		driver.findElement(By.xpath("//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]")).click();
		    	}
		    }
		    
			/*
			 * System.out.println(months.get(i).getText());
			 * while(!months.get(i).getText().contains("November 2026")) { if(i<3) i++; else
			 * driver.findElement(By.
			 * xpath("//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]")).
			 * click(); i=1; }
			 */
	}


