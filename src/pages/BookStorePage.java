package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;

public class BookStorePage {

	WebDriver driver;
	//Creating object of Dashboard
	Dashboard dashboard = new Dashboard(driver);
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public BookStorePage(WebDriver driver) {
          this.driver = driver;
	}
	
	//Locator for Go to book store button
	By goToBookStoreBtn = By.id("gotoStore");
	
	//Locator for search field
	By searchBtn = By.id("searchBox");
	
	//Locator for the Book name link
	By bookNameLink = By.partialLinkText("Git Pocket Guide");
	
	//Locator for Add To Your Collection button
	By addToYourCollectionBtn = By.id("addNewRecordButton");
	
	//Locator for Profile link
	By profileLink = By.xpath("//ul[@class='btn btn-light active']/li[@class='btn btn-light active']//span[@class='text']");
	
	
	//Method to click on Go To Book Store button
	public void clickGoToBookStore() {
		driver.findElement(goToBookStoreBtn).click();
	}
	
	//Method to click on the book name link
	public void clickBookName() {
		driver.findElement(bookNameLink).click();
	}
	
	//Method to click on the OK button on the alert window
	public void clickAddCollectionBtn() {
		driver.findElement(addToYourCollectionBtn).click();
	}
	
	//Method to click on the OK button on the alert window
	public void clickOkButton() {
		Alert simpleAlert = driver.switchTo().alert();
	    simpleAlert.accept();
	}
	
	
	//Method to click on Profile link
	public void clickProfile() {
		driver.findElement(profileLink).click();
	}
	
	
	//check if element visible
	public void verifyBookAddedToCollection() {
		boolean t = driver.findElement(bookNameLink).isDisplayed();
	    if (t) {
	       System.out.println("Element is dispalyed");
	    } else {
	       System.out.println("Element is not dispalyed");
	    }
	}
	
	public void searchBookAndAddToCollection( String BookName ) throws InterruptedException{
	try {
			dashboard.enterSearchStr(BookName);
			clickGoToBookStore();
			dashboard.enterSearchStr(BookName);
			clickBookName();
			Thread.sleep(1000);
			clickAddCollectionBtn();
			clickOkButton();
			clickProfile();
			verifyBookAddedToCollection();
			//CLick on Logout button
			dashboard.clickLogout();
	  }
	catch(Exception e) {
		throw(e);
	}
	
    }
	
	
	
}
