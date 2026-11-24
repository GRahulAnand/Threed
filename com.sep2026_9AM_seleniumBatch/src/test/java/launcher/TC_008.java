package launcher;

import org.apache.log4j.Logger;

import com.sun.tools.sjavac.Log;




public class TC_008 extends BaseTest 
{
     private static  final Logger log=Logger.getLogger(TC_008.class); 
     
	public static void main(String[] args) throws Exception
	{
		init();
		log.info("Init the Properties file...");
		
		launch("chromebrowser");
		log.info("Opening the Browser:- "+p.getProperty("chromebrowser"));
		navigateUrl("amazonurl");
		log.info("Navigating to application : " + childProp.getProperty("amazonurl"));
		
		
		
	selectOption("amazondropbox_id","Books");
	log.info("Selecting option Books By usong locator: "+ orProp.getProperty("amazondropbox_id"));
		
	typeText("amazonsearchtextbox_id","Harry Potter");
	log.info("Typing text Harry Potter By using Locator :"+ orProp.getProperty("amazonsearchtextbox_id"));
	clickElement("amazonsearchbutton_xpath");
	
	log.info("Clicked on Element By ussong Locator: " + orProp.getProperty("amazonsearchbutton_xpath") );
		
		
		

	}

}
