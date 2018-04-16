package pom.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class way2social_HomePage {
   
	WebDriver driver;
	public static final Logger log=Logger.getLogger(way2social_HomePage.class.getName());
	
	 @FindBy(xpath="//button[@class='btn-invite']")
	 WebElement loginToAdvertiserBtn;
	
     @FindBy(xpath=".//*[@id='popupContainer']/div[1]/div[8]/div/div[4]/button")
	 WebElement LoginToInfluencerBtn;

	
	@FindBy(xpath="//*[@id=\"mobile_menu\"]/div[2]/div/nav/a[1]")
	 WebElement AboutUs;

	@FindBy(xpath="//*[@id=\"mobile_menu\"]/div[2]/div/nav/a[2]")
	 WebElement Privacy_policy;
	

	@FindBy(xpath="//*[@id=\"mobile_menu\"]/div[2]/div/nav/a[3]")
	 WebElement Terms_conditions;
	

	@FindBy(xpath="//*[@id=\"mobile_menu\"]/div[2]/div/nav/a[4]")
	 WebElement Contact;
	
	//Advertiser login locaters
	@FindBy(xpath="html/body/div[1]/div[4]/div/div[2]/form/div[1]/input[2]")
	WebElement Advertiser_EmailId;
	
	@FindBy(xpath="html/body/div[1]/div[4]/div/div[2]/form/div[2]/input")
	WebElement Advertiser_Password;
	
	@FindBy(xpath=".//*[@id='popupContainer']/div[1]/div[4]/div/div[2]/form/button")
	WebElement Advertiser_SignIn;
	
	@FindBy(xpath=".//*[@id='popupContainer']/div[1]/div[4]/div/div[2]/div[2]/div/div/button")
	WebElement Advertiser_LoginWithFacebookLink;
	
	@FindBy(xpath=".//*[@id='popupContainer']/div[1]/div[4]/div/div[2]/div[3]/div/div/button")
	WebElement Advertiser_CreateNewAccount;
	
	//Influencer login locators
	@FindBy(xpath="html/body/div[1]/div[3]/div/div[2]/form/div[1]/input[2]")
	WebElement Influencer_EmailId;
	

	@FindBy(xpath="html/body/div[1]/div[3]/div/div[2]/form/div[2]/input")
	WebElement Influencer_Password;
	
	@FindBy(xpath=".//*[@id='popupContainer']/div[1]/div[3]/div/div[2]/form/button")
	WebElement Influencer_SignIn;
	
	@FindBy(xpath=".//*[@id='popupContainer']/div[1]/div[3]/div/div[2]/div[2]/div/div/button")
	WebElement Influencer_LoginWithFaceBook;
	
	@FindBy(xpath=".//*[@id='popupContainer']/div[1]/div[3]/div/div[2]/div[3]/div/div/button")
	WebElement Influencer_CreateNewAccount;
	
	@FindBy(xpath=".//*[@id='popupContainer']/div[1]/div[1]/div[2]/div/div/div[2]/div/button[2]")
	WebElement Influencer_Logout;
	
	public way2social_HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);	
      }
	
   /*=====================HomePage UI Actions========================== */
	
	//Advertiser valid login
	public void AdvertiserToLogin(String username,String password)
	{
		loginToAdvertiserBtn.click();
	   driver.switchTo().window("");
	   Advertiser_EmailId.sendKeys(username);
	   Advertiser_Password.sendKeys(password);
	   Advertiser_SignIn.click();
	 }
	
	//Influencer  valid Login
	public void InfluencerToLogin(String username,String password) throws Exception
	{
		LoginToInfluencerBtn.click();
		driver.switchTo().window("");
		//Thread.sleep(3000);
		Influencer_EmailId.sendKeys(username);
		Influencer_Password.sendKeys(password);
		Influencer_SignIn.click();
	}
	
	//Influencer logOut symbol existing 
	public boolean verifyLogoutDispaly()
	{
		try{
			Influencer_Logout.isDisplayed();
			log.info("logout is dispalyed and object is:-"+Influencer_Logout.toString());
			return true;
		}catch(Exception e)
		{
			return false;
		}
		
	}
	
	//Login get Error message
	
	
	//Influencer Logout
	
	public void clickOnLogout()
	{
		Influencer_Logout.click();
	}
	}
	
	
	
	
	