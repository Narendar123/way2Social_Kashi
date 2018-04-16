package pom.Influencer;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import pom.pages.way2social_HomePage;
import pom.testBase.TestBase;

public class TS_002_VerifyLoginWithDifferntInfluencer extends TestBase {
	
	public static final Logger log=Logger.getLogger(TS_002_VerifyLoginWithDifferntInfluencer.class.getName());
	
	way2social_HomePage homepage;
	
	@DataProvider(name="logindata")
	public String[][] getTestData()
	{
		String[][] testRecords=getData("Sample.xlsx","TestData");
		return testRecords;
		
	}
	@BeforeClass
      public void setup() throws Exception
      {
    	 init(); 
      }
	
		
		@Test(dataProvider="logindata")	
	 public void verifyLoginWithDifferntRecords(String emailAddress,String loginPassword,String runMode)
	 {
		homepage=new way2social_HomePage(driver);
		if(runMode.equalsIgnoreCase("n"))
		{
			throw new SkipException("user marked this record as no run");
		}
		try{
			log.info("================Starting VerifyLoginWithDifferntRecords Test=============");
			homepage.InfluencerToLogin(emailAddress, loginPassword);
			getScreenShot("login email is"+emailAddress);
			boolean status=homepage.verifyLogoutDispaly();
			if(status)
			{
				homepage.clickOnLogout();
			}
			Assert.assertEquals(status,false);
			log.info("============= Finished VerifyLoginWithDifferentRecords Test===========");
			
	 }catch(Exception e)
		{
		 getScreenShot("verifyLoginWithDifferentRecords");
		}
	 }
		@AfterClass
		public void closeBrowser()
		{
			driver.close();
		}
}
