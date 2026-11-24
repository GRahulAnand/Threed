package autoit;

import java.time.Duration;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v140.css.model.CSSStyleSheetHeader;
import org.openqa.selenium.devtools.v140.profiler.model.Profile;
import org.openqa.selenium.devtools.v141.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class FileDownloadingUsingOptions {

	public static void main(String[] args) throws InterruptedException 
	{   // https://www.bosch-mobility.com/media/global/general/various/test-files/pdf-placeholder.pdf
		//http://kb.mozillazine.org/about:config_entries
		//String fileType="DOC","DOCX";//this two line change//line 1
		String fileType="PDF";         // and line 2
		//For Chrome Browser
		
		  ChromeOptions option=new ChromeOptions();
		  option.addArguments("--disable-notifications"); 
		  HashedMap<String,Object>pref=new HashedMap<String, Object>();
		  pref.put("plugins.always_open_pdf_externally", true);
		  pref.put("download.default_directory", "E:\\FileDownloadingusingOptions");
		  
		  option.setExperimentalOption("prefs", pref);
		  
		  WebDriver driver=new ChromeDriver(option);
		  
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://file-examples.com/"); 
		  driver.findElement(By.xpath("//a[contains(@href,'https://file-examples.com/index.php/sample-documents-download/sample-doc-download/')]")).click(); Thread.sleep(5000); 
		  driver.findElement(By.xpath("(//a[contains(@href,'https://file-examples.com/wp-content/storage/2017/02/file-sample_100kB.doc')])[1]" )).click();
		  driver.findElement(By.xpath("//a[@href='/samples/document/doc/sample2.doc']")).click();
		 
		//For Edge Browser
		
//		 EdgeOptions option1=new EdgeOptions(); 
//		 option1.addArguments("C:\\Users\\RahulA\\AppData\\Local\\Temp\\scoped_dir9404_414893732\\Default");
//		 HashedMap<String, Object>pref1=new HashedMap<String, Object>();
//	     	 pref1.put("plugins.always_open_pdf_externally", true);
//		     pref1.put("download.default_directory", "E:\\FileDownloadingusingOptions");
//		     option1.setExperimentalOption("prefs", pref1);
//		  
//		  WebDriver driver1=new EdgeDriver(option1);
//		 driver1.manage().window().maximize();
//		  driver1.get("https://file-examples.com/"); driver1.findElement(By.xpath("//a[contains(@href,'https://file-examples.com/index.php/sample-documents-download/sample-doc-download/')]")).click(); 
//		  Thread.sleep(5000); 
//		  driver1.findElement(By.xpath("(//a[contains(@href,'https://file-examples.com/wp-content/storage/2017/02/file-sample_100kB.doc')])[1]")).click();
//		  driver1.findElement(By.xpath("//a[@href='/samples/document/doc/sample2.doc']")).click();
		 
		
//       FOR Firefox Browser
		/*FirefoxOptions option2=new FirefoxOptions();
		ProfilesIni p=new ProfilesIni();
		FirefoxProfile profile=p.getProfile("AprilFFProfile");
		
		
		Profile.setPreference("pdfjs.disabled",true);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		profile.setPreference("Browser.download.dir", "E:\\FileDownloadingusingOptions");
		profile.setPreference("browser.download.folderList", 2);
		option2.setProfile(profile);
		WebDriver driver2 = new FirefoxDriver(option2);
		
		//used in version WebDriver-2 & 3 series
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//used in version WebDriver-4 series
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver2.manage().window().maximize();
		driver2.get("https://file-examples.com/");
		driver2.manage().timeouts().getPageLoadTimeout();
		
		driver2.findElement(By.xpath("//a[contains(@href,'https://file-examples.com/index.php/sample-documents-download/sample-doc-download/')]")).click();
		driver2.findElement(By.xpath("(//a[contains(@href,'https://file-examples.com/wp-content/storage/2017/02/file-sample_100kB.doc')])[1]")).click();
		driver2.findElement(By.xpath("//a[@href='/samples/document/doc/sample2.doc']")).click();*/
		
	}

}
