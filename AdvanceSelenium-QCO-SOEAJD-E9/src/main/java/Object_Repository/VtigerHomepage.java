package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Webdriver_Utility;

public class VtigerHomepage {
	
	public VtigerHomepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "Campaigns")
	private WebElement Campaignlink;
	
	@FindBy(linkText = "Organizations")
	private WebElement Organizationlink;
	
	@FindBy(linkText = "Products")
	private WebElement Productlink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admlink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;
	
	@FindBy(xpath = "//a[text()='More']")
	private WebElement morelink;

	public WebElement getCampaignlink() {
		return Campaignlink;
	}

	public WebElement getOrganizationlink() {
		return Organizationlink;
	}

	public WebElement getProductlink() {
		return Productlink;
	}

	public WebElement getAdmlink() {
		return admlink;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public WebElement getMorelink() {
		return morelink;
	}
	/**
	 * this method is used for click on Campaignlink
	 */
	public void Campaignlink()
	{
		Campaignlink.click();
	}
	/**
	 * this method is used for click onOrganizationlink
	 */
	public void  Organizationlink()
	{
		Organizationlink.click();
	}
	/**
	 * this method is used for click on Productlink
	 */
	public void Productlink()
	{
		Productlink.click();
	}
	/**
	 * this method is used for click on admlink
	 */
	public void admlink()
	{
		admlink.click();
	}
	/**
	 * this method is used for click on signoutlink
	 */
	public void signoutlink()
	{
		signoutlink.click();
	}
	/**
	 * this method is used for click on morelink
	 */
	public void morelink()
	{
		morelink.click();
	}
	public void logout(WebDriver driver)
	{
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.movetoelement(driver, admlink);
		signoutlink.click();
		
	}
}
