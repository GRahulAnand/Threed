package actions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScripExectorDemo {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('_R_1h6kqsqppb6amH1_').value='Rahul'");
		String title = js.executeScript("return document.title").toString();
		System.out.println(title);
		
		//js.executeScript("window.scrollBy(0,100)");
		//js.executeScript("window.scrollBy(0,100)");
		js.executeScript("document.getElementsByClassName('x1lliihq x193iq5w x6ikm8r x10wlt62 xlyipyv xuxw1ft').item(2).scrollIntoView()");
		js.executeScript("document.getElementsByClassName('x1lliihq x193iq5w x6ikm8r x10wlt62 xlyipyv xuxw1ft').item(2).click()");
	     js.executeScript("window.history.back()");
	     js.executeScript("window.history.forward()");
	     js.executeScript("window.history.go(0)");
	     
		
	}

}
