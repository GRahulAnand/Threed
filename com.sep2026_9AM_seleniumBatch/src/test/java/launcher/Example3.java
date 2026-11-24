package launcher;
import org.openqa.selenium.By;
////nav[@aria-label="pagination"]//child::button[text()='1']/following-sibling::button[text()='2']
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example3 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		 driver.get("https://datatables.net/releases/3/examples/advanced_init/dt_events.html");
		int pageMaxSize = driver.findElements(By.xpath("//nav[@aria-label=\"pagination\"]/button")).size();
		 System.out.println("Total number of pags:" +pageMaxSize);
			for(int i=3;i<pageMaxSize-1;i++)
			{
				driver.findElement(By.xpath("//nav[@aria-label='pagination']/button"+"["+(i)+"]")).click();
				Thread.sleep(5000);
			}
	}

}
