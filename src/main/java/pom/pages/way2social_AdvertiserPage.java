package pom.pages;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class way2social_AdvertiserPage {
 
	 WebDriver driver;
	 
	 @FindBy(xpath=".//*[@id='leftnav']/div[1]/a[1]")
	 WebElement Way2SocailLogo;
	 
	 @FindBy(xpath=".//*[@id='createamp']")
	 WebElement CreateCampaignButton;
	 
	 @FindBy(xpath=".//*[@id='managecamp']/a")
	 WebElement ManageCampaignsButton;
	 

	 @FindBy(xpath=".//*[@id='statstrack']")
	 WebElement CampaignsStatsButton;
	 
	 @FindBy(xpath=".//*[@id='paymenthistory']")
	 WebElement PaymentsButton;
	 
	 @FindBy(xpath=".//*[@id='leftnav']/nav[1]/a[4]")
	 WebElement SettingButton;
	 
	 @FindBy(xpath=".//*[@id='leftnav']/div[2]/p")
	 WebElement TotalAvailbleButton;
	 
	 @FindBy(xpath=".//*[@id='leftnav']/div[2]/div/span")
	 WebElement AmountDisplayText;
	 
	 @FindBy(xpath=".//*[@id='addamoutstep']")
	 WebElement AddAmountButton;
	 
	 @FindBy(xpath=".//*[@id='leftnav']/nav[2]/a")
	 WebElement LogOutButton;
	 
	 // ======================== Create Campaign locators =========================//
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[1]/div[2]/div/div/div[1]/div[1]/h3")
	 WebElement CreateCampaignText;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[1]/div/div[1]")
	 WebElement CreateCampaignStatusBar;
	 
	 @FindBy(xpath=".//*[@id='promotion_title']")
	 WebElement promotionTitle;
	 
	 @FindBy(xpath="//*[@id='campaign_start_date']/span")
	 WebElement StartDate;
	 
	 @FindBy(xpath=".//*[@id='campaign_end_date']/span")
	 WebElement EndDate;
	 
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[2]/div/div/div/form/div[4]/button")
	 WebElement PromateButton;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[3]/div[1]/div/div/h3")
	 WebElement WhereToPromateText;
	 
	 @FindBy(xpath="//div[@class='form-group']/label[1]/input")
	 WebElement FaceBookButton;
	 
	 @FindBy(xpath="//div[@class='form-group']/label[2]/input")
	 WebElement TwitterButton;
	 
	 @FindBy(xpath="//div[@class='form-group']/label[3]/input")
	 WebElement InstagramButton;
	 
	 @FindBy(xpath="//div[@class='form-group']/label[4]/input")
	 WebElement YouTubeButton;
	 
	 @FindBy(xpath=".//*[@id='description']")
	 WebElement Description;
	 
	 @FindBy(xpath=".//*[@id='redirect_url']")
	 WebElement RedirectURL;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[3]/div[1]/div/form/div[2]/div[3]")
	 WebElement AutoapporvalofInfluencerLabel;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[3]/div[1]/div/form/div[2]/div[3]/div/label[1]/input")
	 WebElement AutoApporvalOfInfluencerLabel_YesBtn;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[3]/div[1]/div/form/div[2]/div[3]/div/label[2]/input")
	 WebElement AutoApporvalOfInfluencerLabel_NoBtn;
	 
	 
	 @FindBy(xpath=".//*[@id='camp_type']/div/label[1]/input")
	 WebElement SelectContentType_Image;
	 
	 @FindBy(xpath=".//*[@id='camp_type']/div/label[2]/input")
	 WebElement SelectContentType_Video;
	 
	 @FindBy(xpath=".//*[@id='camp_type']/div/label[3]/input")
	 WebElement SelectContentType_Text;
	 
	 
	 @FindBy(xpath=".//*[@id='camp_content_url']")
	 WebElement Upload_Image_Browse;
	 
	 @FindBy(xpath=".//*[@id='camp_video_url']")
	 WebElement Upload_video_Browse;
	 
	 @FindBy(xpath=".//*[@id='hash_tag']")
	 WebElement Hash_tag;
	 
	 @FindBy(xpath=".//*[@id='example_post_url']")
	 WebElement Example_Post_Url;
	 
	 @FindBy(xpath="//button[@class='btn-invite pull-right ng-scope']")
	 WebElement SetBudget;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[2]/form/div/div/div[1]/div[2]/input")
	 WebElement TotalPromotionBudget_Text;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[2]/form/div/div/div[1]/div[3]/label[2]/input")
	 WebElement BudgetPerInfluencer_Fixed;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[2]/form/div/div/div[1]/div[3]/label[3]/input")
	 WebElement BudgetPerInfluencer_Range;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[2]/form/div/div/div[1]/div[4]/input")
	 WebElement Fixed_Budget_Text;
	 
	 @FindBy(xpath="//button[@class='btn-invite pull-right ng-scope']")
	 WebElement SetDemography;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[2]/div/div/div[1]/div/select")
	 WebElement ChooseCountry;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[2]/div/div/div[2]/div/select")
	 WebElement ChooseCity;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[2]/div/div/div[3]/div/select")
	 WebElement ChooseAge;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[2]/div/div/div[4]/div/select")
	 WebElement ChooseGender;
	 
	 @FindBy(xpath="//div[@class='well-sm text-center']/div/div")
	 WebElement CaetgoriesOptions;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[4]/div/button[2]")
	 WebElement ApplyButton;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[4]/div/button[3]")
	 WebElement ResetButton;
	 
	 @FindBy(xpath=".//*[@id='body']/div[1]/div[3]/div[1]/div/div[1]/div/nav/button")
	 WebElement SaveAsDraftButton;
	 
	 public way2social_AdvertiserPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	 
	 /*===========================Advertiser UI Actions ==============================*/
	  
	 //create campaign opeartion
	 public void selectDateInClendar(String simpleDate)
	 {
		 SimpleDateFormat dt=new SimpleDateFormat("yyyy-MMMM-dd");
		 Date d=new Date(simpleDate);
		 String date=dt.format(d);
		 System.out.println(date);
		 //spilt the date
		 
		 
	 }
	 public void createcampaign(String title)
	 {
		 CreateCampaignButton.click();
		 promotionTitle.sendKeys(title);
		 
	 }
	 
}
