package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationPage {
	
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//img[@title='Create Organization...']")
	private WebElement plusimg;
	
	@FindBy(name = "accountname")
	private WebElement orgsname;
	
	@FindBy(name = "phone")
	private WebElement phonnum;
	
	@FindBy(id = "email1")
	private WebElement emailid;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	public WebElement getPlusimg() {
		return plusimg;
	}

	public WebElement getOrgname() {
		return orgsname;
	}

	public WebElement getPhonnum() {
		return phonnum;
	}

	public WebElement getEmailid() {
		return emailid;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public void clickplusimg(WebDriver driver)
	{
		plusimg.click();
	}
	public void enterorganisationdata(String orgname, String phnnum, String emaid)
	{
		orgsname.sendKeys(orgname);
		phonnum.sendKeys(phnnum);
		emailid.sendKeys(emaid);
	}
	
	public void clickonsavebutton(WebDriver driver)
	{
		savebutton.click();
	}
}
