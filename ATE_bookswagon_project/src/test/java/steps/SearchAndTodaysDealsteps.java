package steps;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.SearchboxPage;
import pages.TodaysDealPage;
import utilities.XLS_DataProvider;
import utilities.Mylistener;
import utilities.Retry;
    
@Listeners(Mylistener.class)
public class SearchAndTodaysDealsteps extends SharedStep{
	//public static void main(String[] args) throws InterruptedException {
		
		SearchboxPage sp;
		TodaysDealPage tp;
		SharedStep ss;
		//ScreenshotUtility su;
		
		
		

		@Test(priority='1',dataProvider = "testdata",retryAnalyzer=Retry.class)
		public void search(String search,String email,String password) throws MalformedURLException, InterruptedException
		{
			
			sp.searchitem(search);
			sp.wishlistsearch();
			Thread.sleep(1500);
			sp.loginsearch(email,password);
	
			sp.loginbutton1();
		}
		@Test(priority='2',retryAnalyzer=Retry.class)
		public void dealstoday() throws InterruptedException, IOException
		{ 
			tp.todaysdeallog();

		}
		@BeforeClass()
		public void setup() throws InterruptedException, IOException
		{

			
			getBrowser();
		
		   sp=new SearchboxPage();
		   tp=new TodaysDealPage();
           ss=new SharedStep();
      //     su=new ScreenshotUtility();
     
		}  
	
			@AfterClass()
			public void generateReports() throws IOException
			{
				driver.close();
				
		   
			}

			@DataProvider(name="testdata")
			public Object[][] datasupplier() throws EncryptedDocumentException, IOException
			{

				Object[][] inputdata = XLS_DataProvider.getTestData("Sheet3");
				
				return inputdata;
			}
			

}
