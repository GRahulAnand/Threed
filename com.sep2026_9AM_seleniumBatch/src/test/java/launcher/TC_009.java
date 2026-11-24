package launcher;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

public class TC_009 extends BaseTest
{
	
    
	public static void main(String[] args) throws Exception
	{
		init();
		test=rep.createTest("TC_009");
		test.log(Status.INFO,"Init the Properties files....");
		
		launch("chromebrowser");

		test.log(Status.PASS,"Opening the Browser:- "+p.getProperty("chromebrowser"));
		navigateUrl("amazonurl");
		
		test.log(Status.INFO,"Navigating to application : " + childProp.getProperty("amazonurl"));
		
		
	selectOption("amazondropbox_id","Books");
	test.log(Status.FAIL, "Selecting option Books By usong locator: "+ orProp.getProperty("amazondropbox_id"));
		
	typeText("amazonsearchtextbox_id","Harry Potter");
	test.log(Status.PASS,"Typing text Harry Potter By using Locator :"+ orProp.getProperty("amazonsearchtextbox_id"));
	
	clickElement("amazonsearchbutton_xpath");
	test.log(Status.PASS,"Clicked on Element By ussong Locator: " + orProp.getProperty("amazonsearchbutton_xpath"));  
		
		rep.flush();
		

	}

	

}
