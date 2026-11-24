package testNG;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import launcher.BaseTest;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class TNG_002 extends BaseTest
{
 
  @BeforeMethod(groups= {"regression","sanity"})
  public void startUp() throws IOException 
  {
	  
	    init();
		test=rep.createTest("TC_009");
		test.log(Status.INFO,"Init the Properties files....");
		
		launch("chromebrowser");

		test.log(Status.PASS,"Opening the Browser:- "+p.getProperty("chromebrowser"));
		navigateUrl("amazonurl");
		
		test.log(Status.INFO,"Navigating to application : " + childProp.getProperty("amazonurl")); 
  }

  @Test(groups= {"regression","sanity"})
  public void amazon() 
  {
	    selectOption("amazondropbox_id","Books");
		test.log(Status.FAIL, "Selecting option Books By usong locator: "+ orProp.getProperty("amazondropbox_id"));
			
		typeText("amazonsearchtextbox_id","Harry Potter");
		test.log(Status.PASS,"Typing text Harry Potter By using Locator :"+ orProp.getProperty("amazonsearchtextbox_id"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(Status.PASS,"Clicked on Element By ussong Locator: " + orProp.getProperty("amazonsearchbutton_xpath"));  
			
  }
  @AfterMethod(groups= {"regression","sanity"})
  public void endProcess() 
  {
	  rep.flush();
	  driver.quit();
  }

}
