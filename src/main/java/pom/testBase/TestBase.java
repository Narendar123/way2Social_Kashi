package pom.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pom.excelReader.Excel_Reader;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestBase {
	
	public WebDriver driver;
	public Properties prop=new Properties();
	public static final Logger log=Logger.getLogger(TestBase.class.getName());
      Excel_Reader excel;
      public static ExtentReports extent;
  	public static ExtentTest test;
	
	//load the properties file
      public void loadData() throws Exception  
    {
    	File file=new File(System.getProperty("user.dir")+"//src//main//java//pom//config//config.properties");
    	FileInputStream fis=new FileInputStream(file);
    	prop.load(fis);
    }
      
      //initilaiza the browser
      
      public void init() throws Exception
      {
    	  loadData();
    	  String log4jconfigpath="log4j.properties";
    	  PropertyConfigurator.configure(log4jconfigpath);
    	  System.out.println(prop.getProperty("browser"));
    	  selcetBrowser(prop.getProperty("browser"));
    	  getUrl(prop.getProperty("url"));
      }
      
      //Selecting Browser
      
      public void selcetBrowser(String browser)
      {
    	  //OS is Widows machine 
    	  System.out.println(System.getProperty("os.name"));
  		if (System.getProperty("os.name").contains("Window")) {
  			if (browser.equals("chrome")) {
  				System.out.println(System.getProperty("user.dir"));
  				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
  				driver = new ChromeDriver();
  				
  			} else if (browser.equals("firefox")) {
  				System.out.println(System.getProperty("user.dir"));
  				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
  				driver = new FirefoxDriver();
  				
  			}
  			
  			//OS is MAC machine
  		} else if (System.getProperty("os.name").contains("Mac")) {
  			if (browser.equals("chrome")) {
  				System.out.println(System.getProperty("user.dir"));
  				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
  				driver = new ChromeDriver();
  				
  			} else if (browser.equals("firefox")) {
  				System.out.println(System.getProperty("user.dir"));
  				System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/drivers/geckodriver");
  				driver = new FirefoxDriver();
  				
  			}
  		}
  		
  		
      }
      
      //get the url
      public void getUrl(String url) {
  		log.info("navigating to :-" + url);
  		driver.get(url);
  		driver.manage().window().maximize();
  		driver.manage().deleteAllCookies();
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  	}
    
      //Excel Reader code through Data Provider
		public String[][] getData(String excelName, String sheetName) {
			String path = System.getProperty("user.dir") + "/src/main/java/pom/testData/" + excelName;
			excel = new Excel_Reader(path);
			String[][] data = excel.getDataFromSheet(sheetName, excelName);
			return data;
		}
		//For ScreenShot Method
		public void getScreenShot(String name) {

			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/pom/screenshot/";
				File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
				FileUtils.copyFile(scrFile, destFile);
				// This will help us to link the screen shot in testNG report
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


     /* //Extent Reportering 
		static {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			extent = new ExtentReports(System.getProperty("user.dir") + "/src/main/java/pom/reports/test/" + formater.format(calendar.getTime()) + ".html", false);
		}
		public String captureScreen(String fileName) {
			if (fileName == "") {
				fileName = "blank";
			}
			File destFile = null;
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/pom/screenshot/";
				destFile = new File((String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
				FileUtils.copyFile(scrFile, destFile);
				// This will help us to link the screen shot in testNG report
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return destFile.toString();
		}

		public void log(String data) {
			log.info(data);
			Reporter.log(data);
			test.log(LogStatus.INFO, data);
		}

		public void getresult(ITestResult result) {
			if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(LogStatus.PASS, result.getName() + " test is pass");
			} else if (result.getStatus() == ITestResult.SKIP) {
				test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
			} else if (result.getStatus() == ITestResult.FAILURE) {
				test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
				String screen = captureScreen("");
				test.log(LogStatus.FAIL, test.addScreenCapture(screen));
			} else if (result.getStatus() == ITestResult.STARTED) {
				test.log(LogStatus.INFO, result.getName() + " test is started");
			}
		}

		@AfterMethod()
		public void afterMethod(ITestResult result) {
			getresult(result);
		}

		@BeforeMethod()
		public void beforeMethod(Method result) {
			test = extent.startTest(result.getName());
			test.log(LogStatus.INFO, result.getName() + " test Started");
		}

		@AfterClass(alwaysRun = true)
		public void endTest() {
			closeBrowser();
		}

		public void closeBrowser() {
			//driver.quit();
			log.info("browser closed");
			extent.endTest(test);
			extent.flush();
		}*/
}
