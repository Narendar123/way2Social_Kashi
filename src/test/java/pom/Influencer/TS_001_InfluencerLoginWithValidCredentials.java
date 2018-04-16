package pom.Influencer;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.way2social_HomePage;
import pom.testBase.TestBase;

public class TS_001_InfluencerLoginWithValidCredentials  extends TestBase{

	way2social_HomePage homepage;
	 public static final Logger log=Logger.getLogger(TS_001_InfluencerLoginWithValidCredentials.class.getName());
		@BeforeClass
	  public void setup() throws Exception
		{
			init();
		}
		
	  @Test
	  public void verifyLoginWithValidCredentails() throws Exception
	  {
		  log.info("=========== Starting verifyLoginWithvalidCredentails Test=============");
		  
		  homepage=new way2social_HomePage(driver);
		  homepage.InfluencerToLogin("imranmyfrnd@gmail.com","way2online");
		  String title=driver.findElement(By.xpath("//div[@class='acc-info']/span")).getText();
		  System.out.println(title);
		  Assert.assertEquals(title, "imran i");
		  
		  log.info("=========== Finishing verifyLoginWithvalidCredentails Test=============");
	  }
}
