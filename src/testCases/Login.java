package testCases;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import automation.runner.annotations.Order;
import pages.BookStorePage;
import pages.Dashboard;
import pages.HomePage;
import pages.LoginPage;

public class Login {
	
	private final String URL = "https://demoqa.com/login";	
	private final String sUserName = "kasliwaln";
	private final String sPassword = "Password@2022";
	private final String sSearch = "Git";
	
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		
		//Creating object of home page
		HomePage home = new HomePage(driver);
		
		//Creating object of Login page
		LoginPage login = new LoginPage(driver);
		
		//Creating object of Dashboard
		Dashboard dashboard = new Dashboard(driver);
		
		//Creating object of BookStorePage
		BookStorePage book = new BookStorePage(driver);
	 }
	
		@Order(1)
		@Test
		public void testVerifyLogin() {
		try
		{			
			//Click on Login button
			home.clickLogin();
			
			//Enter username & password
			login.enterUsername(sUserName);
			login.enterPassword(sPassword);
			
			//Click on login button
			login.clickLogin();
			Thread.sleep(3000);		
			
			//Capture the page heading and print on console
			System.out.println("The page heading is --- " +dashboard.getHeading());
		}
		catch(Exception e) {
			Log.errorHandler("Error displayed in testVerifyBookAddedToCollection()");
		}
		}
		
		
		@Order(2)
		@Test
		public void testVerifyBookAddedToCollection() {
		try
		{
			//Perform search and display search string on console
			dashboard.enterSearchStr(sSearch);
			
			book.clickGoToBookStore();
			dashboard.enterSearchStr(sSearch);
			book.clickBookName();
			Thread.sleep(1000);
			book.clickAddCollectionBtn();
			book.clickOkButton();
			book.clickProfile();
			book.verifyBookAddedToCollection();
			//CLick on Logout button
			dashboard.clickLogout();
		}
		catch(Exception e) {
			Log.errorHandler("Error displayed in testVerifyBookAddedToCollection()");
		}
		}	
		
		@AfterClass
		public void terminate() {
			try {
				driver.close();							
			} catch (Exception e) {
				Log.errorHandler("Error in terminate method");
			}
		}

}