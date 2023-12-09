package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodaysDealPage extends BasePage {
	
	
		@FindBy(xpath=("//li[@id='ctl00_li4']"))
		static WebElement todaysdeal;
		@FindBy(xpath=("(//img[@class='card-img-top bklazy'])[1]"))
		static WebElement selectingtodaysdeal;
		@FindBy(xpath=("//input[@value='Buy Now']"))
		static WebElement buynowtodaysdeal;
	
		public TodaysDealPage()
		{
			PageFactory.initElements(driver, this);

		}
	public void todaysdeallog() {
	
		todaysdeal.click();
		selectingtodaysdeal.click();
		buynowtodaysdeal.click();
		
	}

}
