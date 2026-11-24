package launcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example1 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[text()='Gainers'])[3]")).click();
		String d = driver.findElement(By.xpath("(//table[@class=\"dataTable\"]/tbody/tr[5]/td[@class=\"alignR\"])[2]")).getText();
           System.out.println("Current Price (Rs)-: "+d);
       String d1= driver.findElement(By.xpath("((//table[@class=\"dataTable\"]/tbody/tr)[6]/td)[4]")).getText();
           System.out.println("Current Price (Rs)-: "+d1);
           
       String d3 = driver.findElement(By.xpath("//a[text()='Ardee Industries']//parent::td//following-sibling::td[@class='alignR'][2]")).getText();
       System.out.println("Current Price (Rs)-: "+d3);
	}

}
 