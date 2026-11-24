package launcher;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest 
{
	 public static WebDriver driver;
	 public static String projectPath=System.getProperty("user.dir");
	 public static FileInputStream fis;
	 public static Properties p;
	 public static Properties mainProp;
	 public static Properties childProp;
	 public static Properties orProp;
	 public static ExtentReports rep;
	 public static ExtentTest test;
	 public static String filePath;
	 
	 static
	 {
		 Date dt=new Date();
		 filePath=dt.toString().replace(':', '_').replace(' ', '_');
	 }
	 
	 public static void init() throws IOException
	 {
		 fis=new FileInputStream(projectPath+"/src/test/resources/environment.properties");
		  mainProp=new Properties();
		  mainProp.load(fis);
		  String e = mainProp.getProperty("env");
		  System.out.println(e);
		  
		  fis=new FileInputStream(projectPath+"/src/test/resources/"+e+".properties");
		  childProp=new Properties();
		  childProp.load(fis);
		  String url = childProp.getProperty("amazonurl");
		   System.out.println(url);
		 
		 
		 fis = new FileInputStream(projectPath+"/src/test/resources/data.properties");
		 p=new Properties();
         p.load(fis);
		//=======================================
		//String e = p.getProperty("chromebrowser"); 
		//System.out.println(e);
		//===========================================
		fis=new FileInputStream(projectPath+"/src/test/resources/or.properties");
		orProp=new Properties();
		orProp.load(fis);
		
		fis=new FileInputStream(projectPath+"/src/test/resources/log4config.properties");
		PropertyConfigurator.configure(fis);
         
		rep=ExternalManager.getInstance();

	 } 
	 
  public static void launch(String browserKey)
	 //public static void launch(String browser)
  {
	  if(p.getProperty(browserKey).equals("chrome"))
	  //if(browser.equals("chrome"))
	  {
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
	  }
	  else if(p.getProperty(browserKey).equals("firefox"))
	  //else if(browser.equals("firefox"))
	  {
		  driver=new FirefoxDriver();
	  }
	  //ChromeOptions settings = new ChromeOptions();
		//Map<String, Object> prefs = new HashMap<>();
		//prefs.put("profile.password_manager_leak_detection", false);
		//settings.setExperimentalOption("prefs", prefs);
		////WebDriver driver = new ChromeDriver(settings); 
		//WebDriver driver=new ChromeDriver(settings);
  }
 
  
  
  
  
  
  public static void navigateUrl(String urlKey)
  {
	  //driver.get(url);
	  driver.navigate().to(childProp.getProperty(urlKey));
  }
  
  public static void selectOption(String locatorKey,String option)
 	{
	  //driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
	  getElement(locatorKey).sendKeys(option);
 	}

 	

	public static void typeText(String locatorkey,String text) 
 	{
 		
 		//driver.findElement(By.id(orProp.getProperty(locatorkey))).sendKeys(text);
 		getElement(locatorkey).sendKeys(text);
 	}
 	
 	public static void clickElement(String locatorKey)
 	{
 		//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
 		getElement(locatorKey).click();
 		
 	}
 	public static WebElement getElement(String locatorKey) 
 	{
	  WebElement element=null;
	  
	  //check for Element Present
	  if(!isElementPresent(locatorKey))//true
		 //report Failure
		  System.out.println("Element is not Present:"+locatorKey);	  
	  
	  element=driver.findElement(getLocator(locatorKey));
	  
		/*
		 * if(locatorKey.endsWith("_id")) {
		 * element=driver.findElement(By.id(orProp.getProperty(locatorKey))); } else
		 * if(locatorKey.endsWith("_name")) {
		 * element=driver.findElement(By.name(orProp.getProperty(locatorKey))); } else
		 * if(locatorKey.endsWith("_classname")) {
		 * element=driver.findElement(By.className(orProp.getProperty(locatorKey))); }
		 * else if(locatorKey.endsWith("_xpath")) {
		 * element=driver.findElement(By.xpath(orProp.getProperty(locatorKey))); } else
		 * if(locatorKey.endsWith("_css")) {
		 * element=driver.findElement(By.cssSelector(orProp.getProperty(locatorKey))); }
		 * else if(locatorKey.endsWith("_linktext")) {
		 * element=driver.findElement(By.linkText(orProp.getProperty(locatorKey))); }
		 * else if(locatorKey.endsWith("_partiallinktext")) { element=
		 * driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey))); }
		 */
	return element;
     }

	public static boolean isElementPresent(String locatorKey) 
	{
		System.out.println("Checking for Element Presence:"+locatorKey);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try 
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			/*
			 * if(locatorKey.endsWith("_id")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.
			 * getProperty(locatorKey)))); } else if(locatorKey.endsWith("_name")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.
			 * getProperty(locatorKey)))); } else if(locatorKey.endsWith("_className")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.
			 * getProperty(locatorKey)))); } else if(locatorKey.endsWith("_Xpath")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.
			 * getProperty(locatorKey)))); } else if(locatorKey.endsWith("_css")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orProp.
			 * getProperty(locatorKey)))); } else if(locatorKey.endsWith("_linktext")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.
			 * getProperty(locatorKey)))); } else
			 * if(locatorKey.endsWith("_particallinktext")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(
			 * orProp.getProperty(locatorKey)))); }
			 */
		} 
		catch (Exception e) 
		{
			
			return false;
		} 
		return true;
	}
		public static By getLocator(String locatorKey)
		{
			By by=null;
			
			if(locatorKey.endsWith("_id"))
			{
				by=By.id(orProp.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_name"))
			{
				by=By.name(orProp.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_classname"))
			{
				by=By.className(orProp.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_xpath"))
			{
				by=By.xpath(orProp.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_css"))
			{
				by=By.cssSelector(orProp.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_linktext"))
			{
				by=By.linkText(orProp.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_partiallinktext"))
			{
				by=By.partialLinkText(orProp.getProperty(locatorKey));
			} 
			return by;
		}
		//**************************Verifications*********************************
		    public  static boolean isLinkEqual(String expectedLink) 
		{
			String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
			if(actualLink.equals(expectedLink))
			return true;
			else
				return false;
		}
		//******************* Reportings   *******************
		    public static void logInfo(String logInfomation)
			{
				test.log(Status.PASS, logInfomation);
			}
		    
		    
		    
		    public static void reportSuccess(String successMessage)
			{
				test.log(Status.PASS, successMessage);
			}

			public  static void reportFailure(String failureMessage) throws IOException 
			{
				
				test.log(Status.FAIL, failureMessage);
				takesScreenshot();
		
			}
			
		 public static void takesScreenshot() throws IOException 
		 {
			 Date dt=new Date();
				System.out.println(dt);
				String dateFormat = dt.toString().replace(':','_').replace(' ', '_')+".png";
				 File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    
			FileHandler.copy(srcFile, new File(projectPath+"//failurescreenshots//"+dateFormat));
			
			logInfo("Screenshot ---->"+test.addScreenCaptureFromPath(projectPath+"//failurescreenshots//"+dateFormat));
			
		     
		  }
}
