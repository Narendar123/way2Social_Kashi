package pom.Advertiser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.way2social_AdvertiserPage;
import pom.pages.way2social_HomePage;
import pom.testBase.TestBase;

public class TS_002_AdvertiserCampaign_Creation  extends TestBase{

	way2social_HomePage homepage;
	way2social_AdvertiserPage advertiserpage;
	@BeforeClass
	public void setup() throws Exception
	{
		init();
	}
	@Test
	public void influencerCreation()
	{
		 homepage=new way2social_HomePage(driver);
		 advertiserpage=new way2social_AdvertiserPage(driver);
		 homepage.AdvertiserToLogin("rabbanimohammad70@gmail.com","way2online");
		
		 
	}
}
