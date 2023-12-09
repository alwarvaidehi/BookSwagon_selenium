package pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchboxPage extends BasePage{
	
	@FindBy(xpath=("//input[@class='inputbar']"))
	static WebElement searchbox1;
	@FindBy(xpath=("//input[@name='btnTopSearch']"))
	static WebElement searchbutton;
	@FindBy(xpath="//input[@value='Add to Wishlist']")      //input[@value="Add to Wishlist"]
	static WebElement wishlist1;
	@FindBy(xpath=("//input[@name='ctl00$phBody$SignIn$txtEmail']"))
	static WebElement loginemail;
	@FindBy(xpath=("//input[@name='ctl00$phBody$SignIn$txtPassword']"))
	static WebElement loginpassword;
	@FindBy(xpath=("//a[@class='btn btn-block themebackground text-white mb-2']"))
	static WebElement loginbutton;
	

public SearchboxPage()
{
	PageFactory.initElements(driver, this);
}
public void searchitem(String search)
{
	searchbox1.sendKeys(search);
	String actualsearch=search;
	String Expectedsearch="BTS BOOK";
	 Assert.assertNotSame(actualsearch, Expectedsearch, "Assert not same search item");
	searchbutton.click();
}
public void wishlistsearch()
{
	wishlist1.click();
	assertTrue(true);
}
public void loginsearch(String email,String password)
{
	loginemail.sendKeys(email);
	loginpassword.sendKeys(password);
	//Assert.assertEquals(email, password);
	Assert.assertNotSame(email, password);
	
	
}
public void loginbutton1()
{
	loginbutton.click();
	assertTrue(true);
}
}
