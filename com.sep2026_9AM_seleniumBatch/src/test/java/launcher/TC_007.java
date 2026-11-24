package launcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_007 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id=\"nav-xshop\"]//ancestor::a[contains(text(),'Customer Service')]")).click();
				

	}

}
